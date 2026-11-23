package com.waqarinstitute.app.parent.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ParentChatScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Teacher Chat") }) }) { padding ->
        Text("Double-ratchet chat (empty)", modifier = Modifier.padding(padding))
    }
}