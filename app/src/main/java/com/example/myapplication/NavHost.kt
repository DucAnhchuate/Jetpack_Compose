package com.example.myapplication

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyApp() {
    // Create a NavHostController
    val navController = rememberNavController()

    // Create a NavHost
    NavHost(
        navController = navController,
        startDestination = "LoginScreen"
    ) {
        composable("LoginScreen") {
            loginScreen(navController = navController)
        }
        composable("SignUpScreen") {
            signUpScreen(navController = navController)
        }

        composable("HomeScreen") {
            homeScreen(navController = navController)
        }
    }
}