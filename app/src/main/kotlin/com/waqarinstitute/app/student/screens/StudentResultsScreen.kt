package com.waqarinstitute.app.student.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun StudentResultsScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("T+30 Results") }) }) { padding ->
        Text("Results (empty)", modifier = Modifier.padding(padding))
    }
}