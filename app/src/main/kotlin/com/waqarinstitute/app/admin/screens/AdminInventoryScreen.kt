package com.waqarinstitute.app.admin.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun AdminInventoryScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Lab Hardware Inventory") }) }) { padding ->
        Text("Inventory (empty)", modifier = Modifier.padding(padding))
    }
}