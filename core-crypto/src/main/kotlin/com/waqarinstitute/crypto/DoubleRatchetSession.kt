package com.waqarinstitute.crypto

class DoubleRatchetSession {
    // Skeleton of Signal Double Ratchet; real impl requires X3DH + HKDF + AES-256-GCM
    private var sendingChainKey: ByteArray? = null
    private var receivingChainKey: ByteArray? = null
    private var messageNumber: Int = 0

    fun initFromSharedSecret(sharedSecret: ByteArray) {
        sendingChainKey = sharedSecret.copyOf()
        receivingChainKey = sharedSecret.copyOf()
        messageNumber = 0
    }

    fun encrypt(plaintext: ByteArray): ByteArray {
        val key = sendingChainKey ?: throw IllegalStateException("not initialized")
        // Derive message key via HMAC-SHA256(chainKey, 0x01)
        val mac = javax.crypto.Mac.getInstance("HmacSHA256")
        mac.init(javax.crypto.spec.SecretKeySpec(key, "HmacSHA256"))
        val msgKey = mac.doFinal(byteArrayOf(0x01))
        // Advance chain key
        mac.reset()
        mac.init(javax.crypto.spec.SecretKeySpec(key, "HmacSHA256"))
        sendingChainKey = mac.doFinal(byteArrayOf(0x02))
        messageNumber++
        // AES-GCM encrypt
        val cipher = javax.crypto.Cipher.getInstance("AES/GCM/NoPadding")
        cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, javax.crypto.spec.SecretKeySpec(msgKey, "AES"))
        return cipher.doFinal(plaintext)
    }

    fun decrypt(ciphertext: ByteArray): ByteArray {
        val key = receivingChainKey ?: throw IllegalStateException("not initialized")
        val mac = javax.crypto.Mac.getInstance("HmacSHA256")
        mac.init(javax.crypto.spec.SecretKeySpec(key, "HmacSHA256"))
        val msgKey = mac.doFinal(byteArrayOf(0x01))
        mac.reset()
        mac.init(javax.crypto.spec.SecretKeySpec(key, "HmacSHA256"))
        receivingChainKey = mac.doFinal(byteArrayOf(0x02))
        val cipher = javax.crypto.Cipher.getInstance("AES/GCM/NoPadding")
        cipher.init(javax.crypto.Cipher.DECRYPT_MODE, javax.crypto.spec.SecretKeySpec(msgKey, "AES"))
        return cipher.doFinal(ciphertext)
    }
}