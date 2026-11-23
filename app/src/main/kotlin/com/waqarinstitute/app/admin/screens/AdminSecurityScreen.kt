package com.waqarinstitute.app.admin.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun AdminSecurityScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("SOC + Merkle Verifier") }) }) { padding ->
        Text("Security controls (empty)", modifier = Modifier.padding(padding))
    }
}