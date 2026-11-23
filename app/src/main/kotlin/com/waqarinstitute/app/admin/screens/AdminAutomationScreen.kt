package com.waqarinstitute.app.admin.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun AdminAutomationScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Automation / OTA / Terms") }) }) { padding ->
        Text("Automation (empty)", modifier = Modifier.padding(padding))
    }
}