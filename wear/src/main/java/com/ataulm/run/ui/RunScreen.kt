package com.ataulm.run.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.wear.compose.material.Text

@Composable
fun RunScreen() {
    Text(
        modifier = Modifier.fillMaxSize(),
        text = "run",
        textAlign = TextAlign.Center
    )
}
