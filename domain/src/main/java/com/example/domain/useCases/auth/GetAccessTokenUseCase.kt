package com.example.domain.useCases.auth

import com.example.domain.repository.auth.TokenRepository
import javax.inject.Inject

class GetAccessTokenUseCase @Inject constructor(
    private val repository: TokenRepository
) {
    suspend operator fun invoke() : String{
        return repository.getToken()
    }
}