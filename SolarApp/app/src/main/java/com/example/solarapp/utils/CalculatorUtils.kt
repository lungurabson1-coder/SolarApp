package com.example.solarapp.utils

object CalculatorUtils {

    fun calculateChargingTime(
        batteryCapacity: Double,
        chargerPower: Double
    ): Double {

        val batteryWh = batteryCapacity * 3.7 / 1000

        return batteryWh / chargerPower
    }
}