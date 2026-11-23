package com.waqarinstitute.app.admin.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun AdminLibraryScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Library & Digital Vault") }) }) { padding ->
        Text("Library (empty)", modifier = Modifier.padding(padding))
    }
}