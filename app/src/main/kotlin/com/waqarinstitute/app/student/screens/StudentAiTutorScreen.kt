package com.waqarinstitute.app.student.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun StudentAiTutorScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Zero-Bill AI Tutor") }) }) { padding ->
        Text("AI Tutor (empty)", modifier = Modifier.padding(padding))
    }
}