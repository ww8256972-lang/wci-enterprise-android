package com.waqarinstitute.app.teacher.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun TeacherAttendanceScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Classroom Attendance") }) }) { padding ->
        Text("Attendance (empty)", modifier = Modifier.padding(padding))
    }
}