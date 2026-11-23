package com.waqarinstitute.app.admin.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun AdminFeesScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Offline Fee Receipts") }) }) { padding ->
        Text("Manual campus-counter receipts (empty)", modifier = Modifier.padding(padding))
    }
}