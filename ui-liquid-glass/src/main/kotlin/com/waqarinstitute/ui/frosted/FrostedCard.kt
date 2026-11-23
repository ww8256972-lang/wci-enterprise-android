package com.waqarinstitute.ui.frosted

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.hazeChild

@Composable
fun FrostedCard(
    hazeState: HazeState,
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier.hazeChild(state = hazeState),
        colors = CardDefaults.cardColors(containerColor = androidx.compose.ui.graphics.Color(0x33FFFFFF))
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(title)
            content()
        }
    }
}