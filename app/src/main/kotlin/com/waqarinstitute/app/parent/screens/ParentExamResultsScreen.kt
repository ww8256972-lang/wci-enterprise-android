package com.waqarinstitute.app.parent.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ParentExamResultsScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Exam Results") }) }) { padding ->
        Text("T+30 results (empty)", modifier = Modifier.padding(padding))
    }
}