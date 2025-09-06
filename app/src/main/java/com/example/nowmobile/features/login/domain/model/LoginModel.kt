package com.example.nowmobile.features.login.domain.model

data class LoginRequest(
    val mail: String,
    val password: String
)

data class LoginResponse(
    val token: String,
    val userId: String,
    val message: String = "Login Correcto"
)