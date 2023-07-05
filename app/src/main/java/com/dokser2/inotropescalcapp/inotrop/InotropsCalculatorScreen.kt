package com.dokser2.inotropescalcapp.inotrop

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dokser2.inotropescalcapp.inotrop.components.InputField
import com.dokser2.inotropescalcapp.inotrop.components.SeringeVolume
import com.dokser2.inotropescalcapp.ui.theme.Whitish

const val InotropsCalculatorScreenNavigationId = "intorops_screen"

@Composable
fun InotropsCalculatorScreen() {
    val viewModel: FormulaViewModel = viewModel()
    Body(viewModel = viewModel)
}


@Composable
fun Body(viewModel: FormulaViewModel) {

    var newbornWeight by remember { mutableStateOf("") }
    var doseOfInotrope by remember { mutableStateOf("") }
    var inotropeConcentration by remember { mutableStateOf("") }
    var infussionSpeed by remember { mutableStateOf("") }
    var syringeVolume by remember { mutableStateOf("") }
    var result_string: String by remember { mutableStateOf("") }

    val boxSize = with(LocalDensity.current) { 300.dp.toPx() }

    val isButtonActive by remember {
        derivedStateOf {
            newbornWeight.isNotEmpty() &&
                    doseOfInotrope.isNotEmpty() &&
                    inotropeConcentration.isNotEmpty() &&
                    syringeVolume.isNotEmpty() &&
                    infussionSpeed.isNotEmpty()
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(Color.Blue.copy(alpha = 0.5f), Whitish),
                    start = Offset(0f, 0f), // top left corner
                    end = Offset(boxSize, boxSize) // bottom right corner
                )
            )
            .verticalScroll(ScrollState(0)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top

    ) {
        Text(
            text = "Розрахунок об'єму інотропу",

            modifier = Modifier.padding(5.dp),
            style = TextStyle(
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        )
        Text(
            text = "(для інфузомату)",
            modifier = Modifier.padding(5.dp),
            style = TextStyle(
                color = Color.Red,
                fontSize = 12.sp
            )
        )

        InputField(
            value = newbornWeight,
            onValueChange = { newbornWeight = it },
            label = "вага дитини (кг)"
        )

        InputField(
            value = doseOfInotrope,
            onValueChange = { doseOfInotrope = it },
            label = "доза інотропа (мкг*кг)"
        )


        InputField(
            value = inotropeConcentration,
            onValueChange = { inotropeConcentration = it },
            label = "концентрація інотропа (%)"
        )

        InputField(
            value = infussionSpeed,
            onValueChange = { infussionSpeed = it },
            label = "швидкість інфузії (мл*кг*хв)"
        )

        SeringeVolume(
            currentSeringeStatus = syringeVolume,
            onVolumeSelected = { syringeVolume = it })


        CalculateButton(
            isEnabled = isButtonActive,
            onClick = {
                val weight = newbornWeight.replace(',', '.').toFloat()
                val dose = doseOfInotrope.replace(',', '.').toFloat()
                val concentration = inotropeConcentration.replace(',', '.').toFloat()
                val speed = infussionSpeed.replace(',', '.').toFloat()
                val syringe = syringeVolume.substringBefore(',').substringBefore('.').toInt()

                result_string = viewModel.calculateDose(
                    weight,
                    dose,
                    concentration,
                    speed,
                    syringe
                )
            }
        )

        if (result_string != "") {
            Text(
                text = result_string, modifier = Modifier
                    .fillMaxWidth()
                    .alpha(0.5f)
                    .background(Color.Yellow)
                    .padding(5.dp),
                style = TextStyle(Color.Blue),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }

        ClearButton(
            isEnabled = isButtonActive,
            onClick = {
                newbornWeight = ""
                doseOfInotrope = ""
                inotropeConcentration = ""
                infussionSpeed = ""
                syringeVolume = ""
                result_string = ""
            })
    }
}

@Composable
fun CalculateButton(isEnabled: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        enabled = isEnabled,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Text(text = "РОЗРАХУВАТИ")
    }
}


@Composable
fun ClearButton(isEnabled: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        enabled = isEnabled,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    )
    {
        Text(text = "ОЧИСТИТИ")
    }
}


@Composable
@Preview(showBackground = true)
fun BodyPreview() {
    MaterialTheme {
        Body(viewModel = FormulaViewModel())
    }
}
