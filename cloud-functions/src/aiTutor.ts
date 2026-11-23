import * as functions from "firebase-functions";
import * as admin from "firebase-admin";
import { onCall, HttpsError } from "firebase-functions/v2/https";

// Zero-Bill 4-Tier AI Tutor Cascade. Tier 4 (Gemini free) last resort.
export const aiTutor = onCall(async (request) => {
  if (!request.auth) throw new HttpsError("unauthenticated", "Login required");
  const { question, examActive } = request.data as { question: string; examActive: boolean };
  if (examActive) throw new HttpsError("failed-precondition", "AI Tutor locked during exam");
  // Tier 1: local cache lookup (Firestore cached answers)
  const db = admin.firestore();
  const cache = await db.collection("ai_cache").doc(hash(question)).get();
  if (cache.exists) return { answer: cache.get("answer"), tier: 1 };
  // Tier 2/3/4 would call external providers with free tiers; omitted wiring.
  const answer = "Tutor response placeholder";
  await db.collection("ai_cache").doc(hash(question)).set({ question, answer, createdAt: admin.firestore.FieldValue.serverTimestamp() });
  return { answer, tier: 4 };
});

function hash(s: string): string {
  const crypto = require("crypto");
  return crypto.createHash("sha256").update(s).digest("hex");
}