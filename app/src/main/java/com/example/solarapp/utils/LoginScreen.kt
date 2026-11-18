package com.example.solarapp.utils

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onRegisterClick: () -> Unit
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "SolarApp",
            fontSize = 32.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                if (email.isBlank()) {
                    errorMessage = "Enter your email"
                    return@Button
                }

                if (!email.contains("@")) {
                    errorMessage = "Enter a valid email"
                    return@Button
                }

                if (password.length < 6) {
                    errorMessage = "Password must be at least 6 characters"
                    return@Button
                }

                errorMessage = ""

                onLoginSuccess()
            },

            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Login")
        }

        Spacer(modifier = Modifier.height(12.dp))

        TextButton(
            onClick = onRegisterClick
        ) {

            Text(
                "Don't have an account? Register"
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        if (errorMessage.isNotEmpty()) {

            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}