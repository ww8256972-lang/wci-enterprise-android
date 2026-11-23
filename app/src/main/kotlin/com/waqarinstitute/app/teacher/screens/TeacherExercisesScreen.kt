package com.waqarinstitute.app.teacher.screens

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun TeacherExercisesScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("Coding/Tally Builder") }) }) { padding ->
        Text("Exercises (empty)", modifier = Modifier.padding(padding))
    }
}