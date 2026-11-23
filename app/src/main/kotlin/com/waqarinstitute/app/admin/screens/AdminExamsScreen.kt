package com.waqarinstitute.app.admin.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun AdminExamsScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Exam Governance") }) }) { padding ->
        Text("Exam management (empty)", modifier = Modifier.padding(padding))
    }
}