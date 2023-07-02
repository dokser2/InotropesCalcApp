package com.dokser2.inotropescalcapp.akmi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


const val AkmiScreenNavigationId = "akmi_screen"

@Composable
fun AkmiScreen() {
    Box(Modifier.fillMaxSize().background(Color.Red)) {
        Text("AKMI")
    }
}