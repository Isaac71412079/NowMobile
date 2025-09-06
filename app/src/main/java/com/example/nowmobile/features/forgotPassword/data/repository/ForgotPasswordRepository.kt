package com.example.nowmobile.features.forgotPassword.data.repository

import com.example.nowmobile.features.forgotPassword.domain.model.ForgotPasswordModel
import com.example.nowmobile.features.forgotPassword.domain.repository.IForgotPasswordRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ForgotPasswordRepository : IForgotPasswordRepository {
    override fun getForgotPassword(email: String): Flow<Result<ForgotPasswordModel>> = flow {
        if (email.isBlank()) {
            emit(Result.failure(Exception("Correo vacío")))
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emit(Result.failure(Exception("Correo inválido")))
        } else {
            emit(Result.success(ForgotPasswordModel(email, "Enlace de recuperación enviado")))
        }
    }
}