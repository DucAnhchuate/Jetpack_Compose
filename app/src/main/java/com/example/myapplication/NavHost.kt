package com.example.myapplication

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun MyApp(
    navController: NavHostController
) {
    // Create a NavHostController
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