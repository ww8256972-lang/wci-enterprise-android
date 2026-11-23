package com.waqarinstitute.crypto

import okhttp3.Request
import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.Signature
import java.util.Base64
import org.json.JSONObject

class DpopTokenManager {
    private val keyPair: KeyPair = KeyPairGenerator.getInstance("EC").apply {
        initialize(256)
    }.generateKeyPair()

    fun createDpopProof(method: String, url: String, accessToken: String? = null): String {
        val header = JSONObject().apply {
            put("typ", "dpop+jwt")
            put("alg", "ES256")
            put("jwk", JSONObject().apply {
                put("kty", "EC")
                put("crv", "P-256")
                put("x", Base64.getUrlEncoder().withoutPadding().encodeToString(keyPair.public.encoded.copyOfRange(27, 59)))
                put("y", Base64.getUrlEncoder().withoutPadding().encodeToString(keyPair.public.encoded.copyOfRange(59, 91)))
            })
        }
        val payload = JSONObject().apply {
            put("htm", method)
            put("htu", url)
            put("iat", System.currentTimeMillis() / 1000)
            accessToken?.let { put("ath", sha256(it)) }
        }
        val signingInput = "${b64(header.toString())}.${b64(payload.toString())}"
        val sig = Signature.getInstance("SHA256withECDSA").apply {
            initSign(keyPair.private)
            update(signingInput.toByteArray())
        }.sign()
        return "$signingInput.${Base64.getUrlEncoder().withoutPadding().encodeToString(sig)}"
    }

    private fun b64(s: String) = Base64.getUrlEncoder().withoutPadding().encodeToString(s.toByteArray())
    private fun sha256(s: String): String {
        val md = java.security.MessageDigest.getInstance("SHA-256")
        return Base64.getUrlEncoder().withoutPadding().encodeToString(md.digest(s.toByteArray()))
    }
}