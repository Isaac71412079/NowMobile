package com.example.nowmobile.features.login.domain.usecase

import com.example.nowmobile.features.login.domain.model.LoginRequest
import com.example.nowmobile.features.login.domain.model.LoginResponse
import com.example.nowmobile.features.login.domain.repository.ILoginRepository
import kotlinx.coroutines.flow.Flow

class LoginUseCase(
    private val IloginRepository: ILoginRepository
) {
    operator fun invoke(username: String, password: String): Flow<Result<LoginResponse>> {
        val request = LoginRequest(username, password)
        return IloginRepository.login(request)
    }
}