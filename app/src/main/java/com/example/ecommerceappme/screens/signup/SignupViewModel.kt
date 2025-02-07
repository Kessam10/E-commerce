package com.example.ecommerceappme.screens.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.request.RegisterRequestEntity
import com.example.domain.useCases.auth.RegisterUseCase
import com.example.domain.useCases.auth.SetAccessTokenUseCase
import com.example.ecommerceappme.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase,
    private val setAccessToken: SetAccessTokenUseCase
) : BaseViewModel() {
    var selectedTab by mutableStateOf("sign_up")
    var fullName by mutableStateOf("")
    var fullNameError by mutableStateOf("")

    var email by mutableStateOf("")
    var emailError by mutableStateOf("")

    var phoneNumber by mutableStateOf("")
    var phoneNumberError by mutableStateOf("")

    var password by mutableStateOf("")
    var passwordError by mutableStateOf("")
    var isSuccess by mutableStateOf(false)

    fun register() {
        var isFormValid = true
        fullNameError =
            if (fullName.isEmpty()) {
                isFormValid = false
                "Required !"
            } else ""
        phoneNumberError =
            if (phoneNumber.isEmpty()) {
                isFormValid = false
                "Required !"
            } else ""
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
                val request = RegisterRequestEntity(
                    password = password,
                    rePassword = password,
                    phone = phoneNumber,
                    name = fullName,
                    email = email
                )
                val response = registerUseCase(request)
                setAccessToken(response.token ?: "")
                isSuccess = true
            }
    }
}