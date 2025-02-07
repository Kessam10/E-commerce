package com.example.domain.repository.auth

interface TokenRepository{
    suspend fun getToken():String
    suspend fun setToken(value: String)
}

interface TokenOfflineDataSource{
    suspend fun getToken():String
    suspend fun setToken(value: String)
}