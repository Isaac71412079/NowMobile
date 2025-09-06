package com.example.nowmobile.features.forgotPassword.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nowmobile.features.forgotPassword.domain.usecase.ForgotPasswordUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ForgotPasswordViewModel(private val useCase: ForgotPasswordUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow("")  // aquí guardamos el mensaje
    val uiState: StateFlow<String> = _uiState

    fun sendRecovery(email: String) {
        viewModelScope.launch {
            useCase.sendRecovery(email)
                .collect { result ->
                    result.onSuccess { model ->
                        _uiState.value = model.message  // extraemos el mensaje de OlvidepassModel
                    }.onFailure { e ->
                        _uiState.value = e.message ?: "Error desconocido"
                    }
                }
        }
    }
}