package com.waqarinstitute.app.teacher.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun TeacherCheckInScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Geofence + Face Check-in") }) }) { padding ->
        Text("Check-in (empty)", modifier = Modifier.padding(padding))
    }
}