package com.example.nowmobile.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object ForgotPassword : Screen("forgotPasword")



}