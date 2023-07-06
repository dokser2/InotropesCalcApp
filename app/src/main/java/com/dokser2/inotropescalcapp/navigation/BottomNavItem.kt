package com.dokser2.inotropescalcapp.navigation

import com.dokser2.inotropescalcapp.R
import com.dokser2.inotropescalcapp.akmi.AkmiScreenNavigationId
import com.dokser2.inotropescalcapp.inotrop.InotropsCalculatorScreenNavigationId
import com.dokser2.inotropescalcapp.mkx.MkxScreenNavigationId

sealed class BottomNavItem(val title: String, val icon: Int, val route: String) {

    object InotropsCalculator : BottomNavItem("Title 1", R.drawable.ic_calculate, InotropsCalculatorScreenNavigationId)
    object Akmi : BottomNavItem(
        "AKMI", R.drawable.ic_akmi,
        AkmiScreenNavigationId
    )

    object Mkx : BottomNavItem(
        "MKX", R.drawable.ic_mkx,
        MkxScreenNavigationId
    )
}