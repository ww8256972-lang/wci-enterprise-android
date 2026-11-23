package com.waqarinstitute.app.admin.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun AdminStudentsScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Student Registry (100k)") }) }) { padding ->
        Text("Cursor-paginated student list (empty)", modifier = Modifier.padding(padding))
    }
}