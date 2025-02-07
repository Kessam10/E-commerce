package com.example.ecommerceappme.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.request.LoginRequestEntity
import com.example.domain.useCases.auth.LoginUseCase
import com.example.ecommerceappme.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
):BaseViewModel() {

    var selectedTab by   mutableStateOf("login")
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var isSuccess by mutableStateOf(false)
    var emailError by mutableStateOf("")
    var passwordError by mutableStateOf("")

    fun login() {
        var isFormValid = true
        emailError =
            if (email.isEmpty()) {
                isFormValid = false
                "Required !"
            } else ""
        passwordError =
            if (password.isEmpty()) {
                isFormValid = false
                "Required !"
            } else ""

        if (isFormValid)
            viewModelScope.launch {
                    val request = LoginRequestEntity(
                        password = password,
                        email = email
                    )
                    val response = loginUseCase(request)
                    isSuccess = true

            }
    }
}