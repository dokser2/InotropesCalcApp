package com.dokser2.inotropescalcapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dokser2.inotropescalcapp.akmi.AkmiScreen
import com.dokser2.inotropescalcapp.inotrop.InotropsCalculatorScreen
import com.dokser2.inotropescalcapp.mkx.MkxScreen

@Composable
internal fun BottomNavigationGraph(
    modifier: Modifier,
    bottomNavHostController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = bottomNavHostController,
        startDestination = BottomNavItem.InotropsCalculator.route
    ) {
        composable(BottomNavItem.InotropsCalculator.route) {
            InotropsCalculatorScreen()
        }
        composable(BottomNavItem.Akmi.route) {
            AkmiScreen()
        }
        composable(BottomNavItem.Mkx.route) {
            MkxScreen()
        }
    }
}