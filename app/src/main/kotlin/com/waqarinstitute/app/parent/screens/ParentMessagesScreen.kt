package com.waqarinstitute.app.parent.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ParentMessagesScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Teacher Chat") }) }) { padding ->
        Text("Messages (empty)", modifier = Modifier.padding(padding))
    }
}