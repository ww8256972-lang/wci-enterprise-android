package com.waqarinstitute.app.parent.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ParentConsentsScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Consents & Security") }) }) { padding ->
        Text("Consents (empty)", modifier = Modifier.padding(padding))
    }
}