package com.waqarinstitute.app.teacher.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun TeacherMessagesScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Encrypted Parent Messaging") }) }) { padding ->
        Text("Messages (empty)", modifier = Modifier.padding(padding))
    }
}