import * as functions from "firebase-functions";
import * as admin from "firebase-admin";
admin.initializeApp();

export const gradeExamAfter30Min = functions
  .region("asia-east1")
  .runWith({ timeoutSeconds: 300 })
  .https.onCall(async (data, context) => {
    if (!context.auth) throw new functions.https.HttpsError("unauthenticated", "auth required");
    const { examId, studentId } = data;
    // Placeholder: real impl decrypts answer vault, grades, writes results
    const result = { examId, studentId, score: 0, gradedAt: admin.firestore.FieldValue.serverTimestamp() };
    await admin.firestore().collection("exam_results").doc(`${examId}_${studentId}`).set(result);
    return result;
  });

export const parentGateAlert = functions
  .region("asia-east1")
  .firestore.document("gate_events/{id}")
  .onCreate(async (snap) => {
    const ev = snap.data();
    // Push FCM to parent
    if (ev.parentToken) {
      await admin.messaging().send({ token: ev.parentToken, notification: { title: "Gate Alert", body: "Student movement detected" } });
    }
  });

export const aiTutor = functions
  .region("asia-east1")
  .https.onCall(async (data, context) => {
    if (!context.auth) throw new functions.https.HttpsError("unauthenticated", "auth required");
    // Zero-bill cascade placeholder
    return { answer: "AI tutor response placeholder", model: "cascade" };
  });