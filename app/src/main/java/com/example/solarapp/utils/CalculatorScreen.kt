package com.example.solarapp.utils

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CalculatorScreen(
    onBackClick: () -> Unit
) {

    var batteryCapacity by remember {
        mutableStateOf("")
    }

    var panelPower by remember {
        mutableStateOf("")
    }

    var batteryEnergy by remember {
        mutableStateOf("")
    }

    var chargingTime by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Button(
            onClick = onBackClick
        ) {
            Text("← Back")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Energy Calculator",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = batteryCapacity,
            onValueChange = {
                batteryCapacity = it
            },
            label = {
                Text("Battery Capacity (mAh)")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = panelPower,
            onValueChange = {
                panelPower = it
            },
            label = {
                Text("Solar Panel Power (W)")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                val battery =
                    batteryCapacity.toDoubleOrNull()

                val solar =
                    panelPower.toDoubleOrNull()

                if (battery == null || solar == null) {

                    batteryEnergy =
                        "Please enter valid numbers"

                    chargingTime = ""

                } else if (battery <= 0 || solar <= 0) {

                    batteryEnergy =
                        "Values must be greater than zero"

                    chargingTime = ""

                } else {

                    // Convert battery capacity to Watt-hours
                    val energy =
                        (battery * 3.7) / 1000

                    // Charging time formula
                    val hours =
                        energy / solar

                    batteryEnergy =
                        String.format(
                            "Battery Energy: %.2f Wh",
                            energy
                        )

                    chargingTime =
                        String.format(
                            "Charging Time: %.2f Hours",
                            hours
                        )
                }
            }
        ) {
            Text("Calculate")
        }

        Spacer(modifier = Modifier.height(24.dp))

        if (batteryEnergy.isNotEmpty()) {

            Text(
                text = batteryEnergy,
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = chargingTime,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}