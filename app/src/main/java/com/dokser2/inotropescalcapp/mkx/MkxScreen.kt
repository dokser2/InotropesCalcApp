package com.dokser2.inotropescalcapp.mkx

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

const val MkxScreenNavigationId = "mkx_screen"

@Composable
fun MkxScreen() {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Cyan)) {
        Text("MKX")
    }
}