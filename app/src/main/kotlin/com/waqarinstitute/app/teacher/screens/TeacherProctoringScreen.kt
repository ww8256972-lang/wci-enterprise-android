package com.waqarinstitute.app.teacher.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun TeacherProctoringScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Live Proctoring Grid") }) }) { padding ->
        Text("Proctoring (empty)", modifier = Modifier.padding(padding))
    }
}