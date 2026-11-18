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
fun RegisterScreen(
    onRegisterSuccess: () -> Unit,
    onBackToLogin: () -> Unit
) {

    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var errorMessage by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Create Account",
            fontSize = 28.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = fullName,
            onValueChange = {
                fullName = it
            },
            label = {
                Text("Full Name")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = {
                Text("Email")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text("Password")
            },
            visualTransformation =
                PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = {
                confirmPassword = it
            },
            label = {
                Text("Confirm Password")
            },
            visualTransformation =
                PasswordVisualTransformation(),

            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {

                if (fullName.isBlank()) {
                    errorMessage =
                        "Enter your full name"
                    return@Button
                }

                if (!email.contains("@")) {
                    errorMessage =
                        "Enter a valid email"
                    return@Button
                }

                if (password.length < 6) {
                    errorMessage =
                        "Password must be at least 6 characters"
                    return@Button
                }

                if (password != confirmPassword) {
                    errorMessage =
                        "Passwords do not match"
                    return@Button
                }

                errorMessage = ""

                onRegisterSuccess()

            },
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Register")
        }

        Spacer(modifier = Modifier.height(12.dp))

        TextButton(
            onClick = onBackToLogin
        ) {

            Text(
                "Already have an account? Login"
            )
        }

        if (errorMessage.isNotEmpty()) {

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}