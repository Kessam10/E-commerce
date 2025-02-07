package com.example.data.repository

import com.example.domain.repository.auth.TokenOfflineDataSource
import com.example.domain.repository.auth.TokenRepository

class TokenRepositoryImpl(private val offlineDataSource: TokenOfflineDataSource):TokenRepository {
    override suspend fun getToken(): String {
        return offlineDataSource.getToken()
    }

    override suspend fun setToken(value: String) {
        return offlineDataSource.setToken(value)
    }
}