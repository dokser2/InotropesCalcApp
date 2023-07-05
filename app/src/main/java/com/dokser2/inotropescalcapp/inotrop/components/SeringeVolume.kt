package com.dokser2.inotropescalcapp.inotrop.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dokser2.inotropescalcapp.ui.theme.Pink80

@Composable
fun SeringeVolume(currentSeringeStatus: String, onVolumeSelected: (String) -> Unit) {
    var is20Selected: Boolean by remember { mutableStateOf(false) }
    var is50Selected: Boolean by remember { mutableStateOf(false) }

    if(currentSeringeStatus.isBlank()) {
        is20Selected = false
        is50Selected = false
    }

    Text(
        "об'єм шприця в (мл)",
        style = TextStyle(color = Color.Blue, fontSize = 12.sp),
        textAlign = TextAlign.Center, maxLines = 1, fontWeight = FontWeight.Bold
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .background(Pink80)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .border(1.dp, Color.Blue, shape = RectangleShape),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "20 мл",
                style = TextStyle(color = Color.Blue, fontSize = 18.sp),
                textAlign = TextAlign.Center, fontWeight = FontWeight.Bold
            )

            RadioButton(selected = is20Selected, onClick = {
                is50Selected = false
                is20Selected = true
                onVolumeSelected("20")
            })

        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.Blue, shape = RectangleShape),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "50 мл",
                style = TextStyle(color = Color.Blue, fontSize = 18.sp),
                textAlign = TextAlign.Center, fontWeight = FontWeight.Bold
            )
            RadioButton(selected = is50Selected, onClick = {
                is20Selected = false
                is50Selected = true
                onVolumeSelected("50")
            })

        }
    }
}