package com.waqarinstitute.app.admin.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun AdminFacultyScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Faculty HR") }) }) { padding ->
        Text("Faculty management (empty)", modifier = Modifier.padding(padding))
    }
}