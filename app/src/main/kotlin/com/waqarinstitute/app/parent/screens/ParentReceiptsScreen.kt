package com.waqarinstitute.app.parent.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ParentReceiptsScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Receipt QR Verifier") }) }) { padding ->
        Text("Offline receipts (empty)", modifier = Modifier.padding(padding))
    }
}