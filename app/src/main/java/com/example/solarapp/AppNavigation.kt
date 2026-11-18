package com.example.solarapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.solarapp.utils.HomeScreen
import com.example.solarapp.utils.StationsScreen
import com.example.solarapp.utils.CalculatorScreen
import com.example.solarapp.utils.LoginScreen
import com.example.solarapp.utils.RegisterScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate("home") {
                        popUpTo("login") {
                            inclusive = true
                        }
                    }
                },
                onRegisterClick = {
                    navController.navigate("register")
                }
            )
        }
        composable("register") {
            RegisterScreen(
                onRegisterSuccess = {
                    navController.navigate("home") {
                        popUpTo("login") {
                            inclusive = true
                        }
                    }
                },
                onBackToLogin = {
                    navController.popBackStack()
                }
            )
        }
        composable("home") {
            HomeScreen(
                onNavigateToStations = { navController.navigate("stations") },
                onNavigateToCalculator = { navController.navigate("calculator") },
                onLogout = {
                    navController.navigate("login") {
                        popUpTo("home") {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable("stations") {
            StationsScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
        composable("calculator") {
            CalculatorScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
