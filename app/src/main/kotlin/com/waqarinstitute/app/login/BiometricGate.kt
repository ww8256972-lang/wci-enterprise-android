package com.waqarinstitute.app.login

import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity

class BiometricGate(private val activity: FragmentActivity) {
    fun authenticate(onSuccess: () -> Unit, onError: (String) -> Unit) {
        val executor = ContextCompat.getMainExecutor(activity)
        val prompt = BiometricPrompt(activity, executor, object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) { onSuccess() }
            override fun onAuthenticationError(code: Int, err: CharSequence) { onError(err.toString()) }
            override fun onAuthenticationFailed() { onError("Biometric failed") }
        })
        val info = BiometricPrompt.PromptInfo.Builder()
            .setTitle("WCI Biometric Gate")
            .setSubtitle("Verify identity")
            .setNegativeButtonText("Cancel")
            .setAllowedAuthenticators(BiometricManager.Authenticators.BIOMETRIC_STRONG)
            .build()
        prompt.authenticate(info)
    }
}