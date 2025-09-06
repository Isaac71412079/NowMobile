package com.example.nowmobile.features.login.domain.repository

import com.example.nowmobile.features.login.domain.model.LoginRequest
import com.example.nowmobile.features.login.domain.model.LoginResponse
import kotlinx.coroutines.flow.Flow

interface ILoginRepository {
    fun login(request: LoginRequest): Flow<Result<LoginResponse>>
}