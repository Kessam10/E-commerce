package com.example.domain.useCases.auth

import com.example.domain.entities.AuthResponseEntity
import com.example.domain.entities.request.LoginRequestEntity
import com.example.domain.repository.auth.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private var repository: AuthRepository
) {

    suspend operator fun invoke(loginRequestEntity: LoginRequestEntity):AuthResponseEntity{
        return repository.login(loginRequestEntity)
    }
}

