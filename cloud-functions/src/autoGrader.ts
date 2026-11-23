import * as functions from "firebase-functions";
import * as admin from "firebase-admin";
import { onTaskDispatched } from "firebase-functions/v2/tasks";

export const gradeExam = onTaskDispatched(async (req) => {
  const { examId, studentId, submissionId } = req.data as any;
  const db = admin.firestore();
  const vaultSnap = await db.collection("exam_answer_vault").doc(examId).get();
  const key = vaultSnap.get("answerKey") as Record<string, string>;
  const subSnap = await db.collection("exam_submissions").doc(submissionId).get();
  const answers = subSnap.get("answers") as Record<string, string>;
  let score = 0;
  const perQuestion: Record<string, boolean> = {};
  for (let i = 1; i <= 100; i++) {
    const q = `Q${i}`;
    const correct = key[q] === answers[q];
    if (correct) score++;
    perQuestion[q] = correct;
  }
  // Topic analytics (placeholder mapping)
  const topicStats: Record<string, { correct: number; total: number }> = {};
  // Merkle seal: hash of result
  const crypto = await import("crypto");
  const resultHash = crypto.createHash("sha256").update(JSON.stringify({ examId, studentId, score, perQuestion })).digest("hex");
  await db.collection("exam_results").doc(submissionId).set({
    examId, studentId, score, total: 100, perQuestion, topicStats, resultHash,
    gradedAt: admin.firestore.FieldValue.serverTimestamp()
  });
  // Push to student/parent/teacher via FCM (omitted wiring)
});