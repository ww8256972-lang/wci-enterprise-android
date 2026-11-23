package com.waqarinstitute.app.student.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun StudentProfileScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Profile") }) }) { padding ->
        Text("Profile (empty)", modifier = Modifier.padding(padding))
    }
}