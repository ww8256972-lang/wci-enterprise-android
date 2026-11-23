package com.waqarinstitute.app.parent.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ParentGateAlertsScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Gate Alerts") }) }) { padding ->
        Text("Live campus IN/OUT (empty)", modifier = Modifier.padding(padding))
    }
}