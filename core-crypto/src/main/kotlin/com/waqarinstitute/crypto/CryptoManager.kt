package com.waqarinstitute.crypto

import com.google.crypto.tink.Aead
import com.google.crypto.tink.KeyTemplates
import com.google.crypto.tink.KeysetHandle
import com.google.crypto.tink.aead.AeadConfig
import com.google.crypto.tink.integration.android.AndroidKeysetManager
import android.content.Context
import java.security.KeyStore

class CryptoManager(private val context: Context) {
    private val keysetName = "wci_aead_keyset"
    private val prefFileName = "wci_crypto_prefs"
    private val masterKeyUri = "android-keystore://wci_master_key"

    init { AeadConfig.register() }

    private fun keysetHandle(): KeysetHandle =
        AndroidKeysetManager.Builder()
            .withSharedPref(context, keysetName, prefFileName)
            .withKeyTemplate(KeyTemplates.get("AES256_GCM"))
            .withMasterKeyUri(masterKeyUri)
            .build()
            .keysetHandle

    fun aead(): Aead = keysetHandle().getPrimitive(Aead::class.java)

    fun encrypt(plaintext: ByteArray, aad: ByteArray = byteArrayOf()): ByteArray =
        aead().encrypt(plaintext, aad)

    fun decrypt(ciphertext: ByteArray, aad: ByteArray = byteArrayOf()): ByteArray =
        aead().decrypt(ciphertext, aad)
}