package com.waqarinstitute.ui.liquidglass

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.foundation.shape.RoundedCornerShape

@Composable
fun CurvedLiquidSidebar(
    items: List<String>,
    selected: String,
    onSelect: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .width(96.dp)
            .fillMaxHeight()
            .clip(RoundedCornerShape(topEnd = 32.dp, bottomEnd = 32.dp))
            .background(Color(0x66FFFFFF))
            .padding(12.dp)
    ) {
        items.forEach { item ->
            Text(
                text = item,
                color = if (item == selected) Color.White else Color(0xFF1A1A2E),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .graphicsLayer { shadowElevation = if (item == selected) 8f else 0f }
            )
        }
    }
}