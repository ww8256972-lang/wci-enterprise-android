import * as functions from "firebase-functions";
import * as admin from "firebase-admin";
import { onCall, HttpsError } from "firebase-functions/v2/https";

// Parses uploaded 100-Q PDF (text extracted client-side or via storage trigger),
// strips answers for student view, seals answer key in vault.
export const parseExamPdf = onCall(async (request) => {
  if (!request.auth || request.auth.token.role !== "teacher") {
    throw new HttpsError("permission-denied", "Teacher only");
  }
  const { examId, rawText } = request.data as { examId: string; rawText: string };
  const lines = rawText.split(/\r?\n/);
  const questions: any[] = [];
  const answerKey: Record<string, string> = {};
  let current: any = null;
  for (const line of lines) {
    const qm = line.match(/^Q(\d+)\.\s*(.*)/);
    if (qm) {
      if (current) questions.push(current);
      current = { qNo: parseInt(qm[1]), text: qm[2], options: {} };
      continue;
    }
    const om = line.match(/^\s*([A-D])\)\s*(.*)/);
    if (om && current) { current.options[om[1]] = om[2]; continue; }
    const am = line.match(/^ANSWER:\s*([A-D])/i);
    if (am && current) { answerKey[`Q${current.qNo}`] = am[1]; continue; }
  }
  if (current) questions.push(current);
  if (questions.length !== 100) {
    throw new HttpsError("invalid-argument", `Expected 100 questions, got ${questions.length}`);
  }
  const db = admin.firestore();
  const batch = db.batch();
  // Sanitized (no answers) for students
  batch.set(db.collection("exam_questions_sanitized").doc(examId), { questions, campusId: "WCI_UNNAO_MAIN" });
  // Sealed answer key (server-only collection, denied to clients)
  batch.set(db.collection("exam_answer_vault").doc(examId), { answerKey, sealedAt: admin.firestore.FieldValue.serverTimestamp() });
  await batch.commit();
  // Purge raw PDF reference (client should delete storage object)
  return { ok: true, count: questions.length };
});