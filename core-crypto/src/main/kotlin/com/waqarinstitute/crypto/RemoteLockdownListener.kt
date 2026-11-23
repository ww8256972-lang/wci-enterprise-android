package com.waqarinstitute.crypto

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class RemoteLockdownListener(private val db: FirebaseFirestore) {
    fun lockdownFlow(): Flow<Boolean> = callbackFlow {
        val reg: ListenerRegistration = db.collection("system").document("lockdown")
            .addSnapshotListener { snap, err ->
                if (err != null) { trySend(false); return@addSnapshotListener }
                val locked = snap?.getBoolean("locked") ?: false
                trySend(locked)
            }
        awaitClose { reg.remove() }
    }
}