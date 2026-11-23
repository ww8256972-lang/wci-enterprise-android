package com.waqarinstitute.app.student.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun StudentQrIdScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Digital QR ID") }) }) { padding ->
        Text("QR ID (empty)", modifier = Modifier.padding(padding))
    }
}