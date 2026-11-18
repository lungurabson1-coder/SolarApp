package com.example.solarapp.utils

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class ChargingStation(
    val name: String,
    val location: String,
    val status: String
)

@Composable
fun StationsScreen(
    onBackClick: () -> Unit
) {

    val stations = listOf(
        ChargingStation(
            "Mpika Solar Station",
            "Mpika",
            "Open"
        ),
        ChargingStation(
            "Kasama Solar Hub",
            "Kasama",
            "Open"
        ),
        ChargingStation(
            "Chinsali Charging Point",
            "Chinsali",
            "Busy"
        ),
        ChargingStation(
            "Nakonde Solar Centre",
            "Nakonde",
            "Open"
        )
    )

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
            text = "Charging Stations",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {

            items(stations) { station ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = station.name,
                            style = MaterialTheme.typography.titleMedium
                        )

                        Spacer(
                            modifier = Modifier.height(4.dp)
                        )

                        Text(
                            text = "Location: ${station.location}"
                        )

                        Text(
                            text = "Status: ${station.status}"
                        )
                    }
                }
            }
        }
    }
}