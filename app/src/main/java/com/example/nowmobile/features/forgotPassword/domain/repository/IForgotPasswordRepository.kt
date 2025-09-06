package com.example.nowmobile.features.forgotPassword.domain.repository

import com.example.nowmobile.features.forgotPassword.domain.model.ForgotPasswordModel
import kotlinx.coroutines.flow.Flow


interface IForgotPasswordRepository {
    fun getForgotPassword(email: String): Flow<Result<ForgotPasswordModel>>
}
