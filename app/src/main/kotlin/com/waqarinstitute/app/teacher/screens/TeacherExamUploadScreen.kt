package com.waqarinstitute.app.teacher.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun TeacherExamUploadScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("100-Q PDF Upload") }) }) { padding ->
        Text("Exam upload (empty)", modifier = Modifier.padding(padding))
    }
}