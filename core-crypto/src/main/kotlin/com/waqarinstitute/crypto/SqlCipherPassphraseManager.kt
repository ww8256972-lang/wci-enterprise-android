package com.waqarinstitute.crypto

import android.content.Context
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.GCMParameterSpec
import java.security.SecureRandom
import android.util.Base64

class SqlCipherPassphraseManager(private val context: Context) {
    private val ks = KeyStore.getInstance("AndroidKeyStore").apply { load(null) }
    private val keyAlias = "wci_sqlcipher_key"
    private val ivSize = 12
    private val tagSize = 128

    private fun getOrCreateKey(): SecretKey {
        ks.getKey(keyAlias, null)?.let { return it as SecretKey }
        val gen = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore")
        gen.init(
            KeyGenParameterSpec.Builder(keyAlias, KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT)
                .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
                .setKeySize(256)
                .setIsStrongBoxBacked(true)
                .build()
        )
        return gen.generateKey()
    }

    fun sealPassphrase(passphrase: ByteArray): String {
        val key = getOrCreateKey()
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        cipher.init(Cipher.ENCRYPT_MODE, key)
        val iv = cipher.iv
        val ct = cipher.doFinal(passphrase)
        val combined = iv + ct
        return Base64.encodeToString(combined, Base64.NO_WRAP)
    }

    fun unsealPassphrase(sealed: String): ByteArray {
        val combined = Base64.decode(sealed, Base64.NO_WRAP)
        val iv = combined.copyOfRange(0, ivSize)
        val ct = combined.copyOfRange(ivSize, combined.size)
        val key = ks.getKey(keyAlias, null) as SecretKey
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        cipher.init(Cipher.DECRYPT_MODE, key, GCMParameterSpec(tagSize, iv))
        return cipher.doFinal(ct)
    }

    fun generatePassphrase(): ByteArray {
        val rnd = SecureRandom()
        val buf = ByteArray(32)
        rnd.nextBytes(buf)
        return buf
    }
}