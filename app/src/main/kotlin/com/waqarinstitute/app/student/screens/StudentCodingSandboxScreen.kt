package com.waqarinstitute.app.student.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun StudentCodingSandboxScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Coding Sandbox") }) }) { padding ->
        Text("Python/JS sandbox (empty)", modifier = Modifier.padding(padding))
    }
}