package com.waqarinstitute.app.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

enum class Portal { ADMIN, TEACHER, STUDENT, PARENT }

@Composable
fun PortalLoginScreen(onPortalSelected: (Portal) -> Unit) {
    var selected by remember { mutableStateOf(Portal.STUDENT) }
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Waqar Computer Institute", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(24.dp))
        Portal.entries.forEach { p ->
            OutlinedButton(
                onClick = { selected = p },
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
            ) { Text(p.name) }
        }
        Spacer(Modifier.height(16.dp))
        Button(onClick = { onPortalSelected(selected) }) { Text("Continue") }
    }
}