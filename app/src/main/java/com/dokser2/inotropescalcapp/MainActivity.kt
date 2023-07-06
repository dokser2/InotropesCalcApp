package com.dokser2.inotropescalcapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.dokser2.inotropescalcapp.navigation.BottomNavigationBar
import com.dokser2.inotropescalcapp.navigation.BottomNavigationGraph
import com.dokser2.inotropescalcapp.ui.theme.InotropesCalcAppTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InotropesCalcAppTheme {
                val host = rememberNavController()

                Scaffold(bottomBar = {
                    BottomNavigationBar(navController = host)
                }) {
                    BottomNavigationGraph(
                        modifier = Modifier.padding(it),
                        bottomNavHostController = host
                    )
                }
            }
        }
    }
}

