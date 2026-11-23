package com.waqarinstitute.app.admin.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun AdminCertificatesScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Ed25519 Certificates") }) }) { padding ->
        Text("Certificate issuance (empty)", modifier = Modifier.padding(padding))
    }
}