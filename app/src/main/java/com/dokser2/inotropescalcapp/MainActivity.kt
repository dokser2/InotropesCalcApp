package com.dokser2.inotropescalcapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dokser2.inotropescalcapp.ui.theme.Pink40
import com.dokser2.inotropescalcapp.ui.theme.Pink80
import com.dokser2.inotropescalcapp.ui.theme.Purple80
import com.dokser2.inotropescalcapp.ui.theme.PurpleGrey80
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Image(
                painter = painterResource(id = R.drawable.baby),
                contentDescription = "img",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
            test()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun test() {

    var newborn_weight by remember { mutableStateOf("") }
    var dose_of_inotrope by remember { mutableStateOf("") }
    var inotrope_concentration by remember { mutableStateOf("") }
    var infussion_speed by remember { mutableStateOf("") }
    var syringe_volume by remember { mutableStateOf("") }
    var result_string: String by remember { mutableStateOf("") }
    var is_20_selected: Boolean by remember { mutableStateOf(true) }
    var is_50_selected: Boolean by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
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

        TextField(
            value = newborn_weight,
            onValueChange = { newborn_weight = it },
            label = {
                Text(
                    "вага дитини (кг)",
                    style = TextStyle(color = Color.Blue, fontSize = 12.sp),
                    textAlign = TextAlign.Center, maxLines = 1, fontWeight = FontWeight.Bold
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
                .alpha(0.8f)
                .border(width = 1.dp, Color.Blue, shape = RectangleShape)
        )

        TextField(
            value = dose_of_inotrope,
            onValueChange = { dose_of_inotrope = it },
            label = {
                Text(
                    "доза інотропа (мкг*кг)",
                    style = TextStyle(color = Color.Blue, fontSize = 12.sp),
                    textAlign = TextAlign.Center, maxLines = 1, fontWeight = FontWeight.Bold
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
                .alpha(0.8f)
                .border(width = 1.dp, Color.Blue, shape = RectangleShape)
        )


        TextField(
            value = inotrope_concentration,
            onValueChange = { inotrope_concentration = it },
            label = {
                Text(
                    "концентрація інотропа (%)",
                    style = TextStyle(color = Color.Blue, fontSize = 12.sp),
                    textAlign = TextAlign.Center, maxLines = 1, fontWeight = FontWeight.Bold
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
                .alpha(0.8f)
                .border(width = 1.dp, Color.Blue, shape = RectangleShape)
        )



        TextField(
            value = infussion_speed,
            onValueChange = { infussion_speed = it },
            label = {
                Text(
                    "швидкість інфузії (мл*кг*хв)",
                    style = TextStyle(color = Color.Blue, fontSize = 12.sp),
                    textAlign = TextAlign.Center, maxLines = 1, fontWeight = FontWeight.Bold
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
                .alpha(0.8f)
                .border(width = 1.dp, Color.Blue, shape = RectangleShape)
        )


//        TextField(
//            value = syringe_volume,
//            onValueChange = { syringe_volume = it },
//            label = {
//                Text(
//                    "об'єм шприця в (мл)",
//                    style = TextStyle(color = Color.Blue, fontSize = 12.sp),
//                    textAlign = TextAlign.Center, maxLines = 1, fontWeight = FontWeight.Bold
//                )
//            },
//            keyboardOptions = KeyboardOptions(
//                keyboardType = KeyboardType.Number
//            ),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 5.dp)
//                .alpha(0.8f)
//                .border(width = 1.dp, Color.Blue, shape = RectangleShape)
//        )
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
                Text(text = "20 мл",
                    style = TextStyle(color = Color.Black, fontSize = 18.sp),
                    textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)

                RadioButton(selected = is_20_selected, onClick = {
                    is_50_selected = false
                    is_20_selected = true
                    syringe_volume = "20"
                })

            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.Blue, shape = RectangleShape),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "50 мл",
                    style = TextStyle(color = Color.Black, fontSize = 18.sp),
                    textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
                RadioButton(selected = is_50_selected, onClick = {
                    is_20_selected = false
                    is_50_selected = true
                    syringe_volume = "50"
                })

            }
        }



        Button(
            onClick = {
                if (newborn_weight.isEmpty() ||
                    dose_of_inotrope.isEmpty() ||
                    inotrope_concentration.isEmpty() ||
                    syringe_volume.isEmpty() ||
                    infussion_speed.isEmpty()
                ) {
                    result_string = "ЗАПОВНІТЬ ВСІ ПОЛЯ!!!"
                } else {
                    val weight = newborn_weight.replace(',', '.').toFloat()
                    val dose = dose_of_inotrope.replace(',', '.').toFloat()
                    val concentration = inotrope_concentration.replace(',', '.').toFloat()
                    val speed = infussion_speed.replace(',', '.').toFloat()

                    val syringe = syringe_volume
                        .substringBefore(',')
                        .substringBefore('.').toInt()

                    val resultFloat =
                        (weight * dose * 6 * syringe) / (speed * concentration * 1000)

                    val result = (resultFloat * 100).roundToInt() / 100.0
                    result_string =
                        "Вам потрібно набрати в $syringe мл шприц: ${result.toString()} мл \n " +
                                "$concentration %  розчину"
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Text(text = "РОЗРАХУВАТИ")
        }
        if (result_string!="") {
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

        Button(
            onClick = {
                newborn_weight = ""
                dose_of_inotrope = ""
                inotrope_concentration = ""
                infussion_speed = ""
                syringe_volume = ""
                result_string = ""
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )
        {
            Text(text = "ОЧИСТИТИ")
        }


    }
}

