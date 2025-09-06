package com.example.nowmobile.features.forgotPassword.domain.usecase

import com.example.nowmobile.features.forgotPassword.domain.model.ForgotPasswordModel
import com.example.nowmobile.features.forgotPassword.domain.repository.IForgotPasswordRepository
import com.example.nowmobile.navigation.Screen
import kotlinx.coroutines.flow.Flow

class ForgotPasswordUseCase(private val repository: IForgotPasswordRepository) {
    fun sendRecovery(email: String): Flow<Result<ForgotPasswordModel>> {
        return repository.getForgotPassword(email)
    }
}