package com.waqarinstitute.crypto

import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters
import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters
import org.bouncycastle.crypto.signers.Ed25519Signer
import java.security.SecureRandom

class Ed25519Signer {
    private val priv = Ed25519PrivateKeyParameters(SecureRandom())
    private val pub = priv.generatePublicKey()

    fun publicKeyBytes(): ByteArray = pub.encoded
    fun sign(message: ByteArray): ByteArray {
        val signer = Ed25519Signer()
        signer.init(true, priv)
        signer.update(message, 0, message.size)
        return signer.generateSignature()
    }
    fun verify(message: ByteArray, signature: ByteArray, pubBytes: ByteArray): Boolean {
        val pk = Ed25519PublicKeyParameters(pubBytes, 0)
        val v = Ed25519Signer()
        v.init(false, pk)
        v.update(message, 0, message.size)
        return v.verifySignature(signature)
    }
}