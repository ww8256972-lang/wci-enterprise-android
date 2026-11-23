package com.waqarinstitute.crypto

import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import java.security.KeyStore
import android.util.Base64

class StrongBoxAttestation {
    fun generateAttestationChallenge(): ByteArray {
        val rnd = java.security.SecureRandom()
        val challenge = ByteArray(32)
        rnd.nextBytes(challenge)
        return challenge
    }

    fun verifyStrongBoxKey(alias: String): Boolean {
        val ks = KeyStore.getInstance("AndroidKeyStore").apply { load(null) }
        val certChain = ks.getCertificateChain(alias) ?: return false
        // In production, verify attestation extension against Google root
        return certChain.isNotEmpty()
    }
}