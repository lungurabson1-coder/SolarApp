package com.example.solarapp.utils

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    onNavigateToStations: () -> Unit,
    onNavigateToCalculator: () -> Unit,
    onLogout: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "SolarApp",
            fontSize = 32.sp,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = onNavigateToStations,
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Find Charging Stations")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onNavigateToCalculator,
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Energy Calculator")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onLogout,
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Logout")
        }
    }
}