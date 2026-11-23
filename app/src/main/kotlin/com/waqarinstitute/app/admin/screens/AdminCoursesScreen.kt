package com.waqarinstitute.app.admin.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun AdminCoursesScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Courses & Batches") }) }) { padding ->
        Text("Course/batch management (empty)", modifier = Modifier.padding(padding))
    }
}