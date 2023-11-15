package com.example.myapplication

sealed class Screen(val route: String) {
    //list of screen for
    object ScreenLogin: Screen("LoginScreen")
    object ScreenSignUp: Screen("SignUpScreen")
    object ScreenHome: Screen("HomeScreen")
}