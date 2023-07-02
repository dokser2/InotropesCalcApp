package com.dokser2.inotropescalcapp.navigation

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dokser2.inotropescalcapp.ui.theme.DarkBlackishGray
import com.dokser2.inotropescalcapp.ui.theme.Whitish
import com.exyte.animatednavbar.AnimatedNavigationBar
import com.exyte.animatednavbar.animation.balltrajectory.Parabolic
import com.exyte.animatednavbar.animation.indendshape.Height
import com.exyte.animatednavbar.animation.indendshape.shapeCornerRadius
import com.exyte.animatednavbar.items.dropletbutton.DropletButton

private const val Duration = 500
private const val DoubleDuration = 1000

private val barColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) {
        Whitish
    } else {
        DarkBlackishGray
    }

private val routes = listOf(
    BottomNavItem.InotropsCalculator,
    BottomNavItem.Akmi,
    BottomNavItem.Mkx
)

@Composable
internal fun BottomNavigationBar(navController: NavController) {
    var selectedItem by remember { mutableStateOf(0) }
    AnimatedNavigationBar(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 10.dp)
            .height(64.dp),
        selectedIndex = selectedItem,
        ballColor = MaterialTheme.colorScheme.primary,
        barColor = barColor,
        cornerRadius = shapeCornerRadius(25.dp),
        ballAnimation = Parabolic(tween(Duration, easing = LinearOutSlowInEasing)),
        indentAnimation = Height(
            indentWidth = 56.dp,
            indentHeight = 12.dp,
            animationSpec = tween(
                DoubleDuration,
                easing = { OvershootInterpolator().getInterpolation(it) })
        )
    ) {
        routes.forEachIndexed { index, item ->
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(bottom = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom
            ) {
                DropletButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(24.dp),
                    isSelected = selectedItem == index,
                    onClick = {
                        selectedItem = index
                        navController.navigate(item.route) {
                            navController.graph.startDestinationRoute?.let { screen_route ->
                                popUpTo(0) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }

                    },
                    icon = item.icon,
                    contentDescription = item.title,
                    dropletColor = MaterialTheme.colorScheme.primary,
                    animationSpec = tween(durationMillis = Duration, easing = LinearEasing)
                )

                Text(
                    text = item.title,
                    fontSize = 9.sp,
                    color = if (selectedItem == index) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        Whitish
                    }
                )
            }
        }
    }
}
