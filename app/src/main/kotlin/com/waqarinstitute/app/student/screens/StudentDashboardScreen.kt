package com.waqarinstitute.app.student.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun StudentDashboardScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Student Dashboard") }) }) { padding ->
        Text("Student overview (empty)", modifier = Modifier.padding(padding))
    }
}