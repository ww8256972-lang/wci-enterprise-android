package com.waqarinstitute.app.teacher.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun TeacherDashboardScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Teacher Dashboard") }) }) { padding ->
        Text("Teacher overview (empty)", modifier = Modifier.padding(padding))
    }
}