package com.dokser2.inotropescalcapp.inotrop

import androidx.lifecycle.ViewModel
import kotlin.math.roundToInt

class FormulaViewModel: ViewModel() {

    fun calculateDose(weight: Float, dose: Float, concentration: Float, speed: Float, syringe: Int): String {
        val resultFloat =
            (weight * dose * 6 * syringe) / (speed * concentration * 1000)

        val result = (resultFloat * 100).roundToInt() / 100.0
        return "Вам потрібно набрати в $syringe мл шприц: $result мл \n " +
                    "$concentration %  розчину"
    }
}