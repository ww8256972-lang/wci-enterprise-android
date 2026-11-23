package com.waqarinstitute.app.student.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun StudentExamArenaScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Biometric Exam Arena") }) }) { padding ->
        Text("4-option exam (no answer key bytes)", modifier = Modifier.padding(padding))
    }
}