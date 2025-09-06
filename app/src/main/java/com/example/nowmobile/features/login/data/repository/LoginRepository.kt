package com.example.nowmobile.features.login.data.repository

import com.example.nowmobile.features.login.domain.model.LoginRequest
import com.example.nowmobile.features.login.domain.model.LoginResponse
import com.example.nowmobile.features.login.domain.repository.ILoginRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoginRepository : ILoginRepository {
    override fun login(request: LoginRequest): Flow<Result<LoginResponse>> = flow {
        try {
            // Simulamos un delay de red
            delay(1000)

            // Validación simple
            if (request.mail.isEmpty() || request.password.isEmpty()) {
                emit(Result.failure(Exception("Usuario y contraseña obligatorios")))
                return@flow
            }

            if (request.mail == "isaac@mail.com" && request.password == "1234") {
                val response = LoginResponse(
                    token = "mock_token_${System.currentTimeMillis()}",
                    userId = "user_123"
                )
                emit(Result.success(response))
            } else {
                emit(Result.failure(Exception("Datos inválidos")))
            }
        } catch (e: Exception) {
            emit(Result.failure(Exception(e.message ?: "Error de conexión")))
        }
    }
}