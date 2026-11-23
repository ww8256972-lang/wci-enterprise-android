package com.waqarinstitute.app.admin.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun AdminAttendanceScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Biometric/QR Attendance") }) }) { padding ->
        Text("Attendance records (empty)", modifier = Modifier.padding(padding))
    }
}