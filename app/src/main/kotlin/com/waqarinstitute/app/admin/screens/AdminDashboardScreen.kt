package com.waqarinstitute.app.admin.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun AdminDashboardScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Admin Dashboard") }) }) { padding ->
        Text("Admin KPIs (empty until data entered)", modifier = Modifier.padding(padding))
    }
}