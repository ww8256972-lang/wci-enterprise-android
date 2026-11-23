package com.waqarinstitute.app.parent.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ParentDashboardScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Parent Dashboard") }) }) { padding ->
        Text("Multi-child overview (empty)", modifier = Modifier.padding(padding))
    }
}