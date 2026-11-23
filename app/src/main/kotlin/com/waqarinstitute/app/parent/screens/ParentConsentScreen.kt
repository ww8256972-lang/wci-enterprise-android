package com.waqarinstitute.app.parent.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ParentConsentScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Consent & Security") }) }) { padding ->
        Text("Consent controls (empty)", modifier = Modifier.padding(padding))
    }
}