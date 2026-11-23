package com.waqarinstitute.app.student.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun StudentTallySimulatorScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Offline Tally Simulator") }) }) { padding ->
        Text("Tally practice (empty)", modifier = Modifier.padding(padding))
    }
}