package com.waqarinstitute.app.parent.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun ParentPtmScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("PTM Booking") }) }) { padding ->
        Text("PTM slots (empty)", modifier = Modifier.padding(padding))
    }
}