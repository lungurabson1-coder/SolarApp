package com.example.solarapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CalculatorScreen() {

    var battery by remember {
        mutableStateOf("")
    }

    var power by remember {
        mutableStateOf("")
    }

    var result by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        OutlinedTextField(
            value = battery,
            onValueChange = { battery = it },
            label = {
                Text("Battery Capacity (mAh)")
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = power,
            onValueChange = { power = it },
            label = {
                Text("Solar Panel Power (W)")
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val batteryValue =
                    battery.toDoubleOrNull() ?: 0.0

                val powerValue =
                    power.toDoubleOrNull() ?: 1.0

                val hours =
                    batteryValue / powerValue

                result =
                    "%.2f Hours".format(hours)
            }
        ) {
            Text("Calculate")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Estimated Charging Time: $result"
        )
    }
}