package com.example.nowmobile.di

import com.example.nowmobile.features.login.data.repository.LoginRepository
import com.example.nowmobile.features.login.domain.repository.ILoginRepository
import com.example.nowmobile.features.login.domain.usecase.LoginUseCase
import com.example.nowmobile.features.login.application.LoginViewModel
import com.example.nowmobile.features.forgotPassword.data.repository.ForgotPasswordRepository
import com.example.nowmobile.features.forgotPassword.domain.repository.IForgotPasswordRepository
import com.example.nowmobile.features.forgotPassword.domain.usecase.ForgotPasswordUseCase
import com.example.nowmobile.features.forgotPassword.presentation.ForgotPasswordViewModel

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val modules = module{

    //repositorio
    single<LoginRepository>{ LoginRepository() }
    single<IForgotPasswordRepository>{ ForgotPasswordRepository() }

    //UseCase
    factory { LoginUseCase(get()) }
    factory { ForgotPasswordUseCase(get()) }

    //ViewModel
    viewModel { LoginViewModel(get())}
    viewModel { ForgotPasswordViewModel(get()) }
}