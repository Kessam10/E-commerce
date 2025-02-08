package com.example.data.online.api

import com.example.data.model.categories.CategoriesResponseModel
import retrofit2.http.GET

interface CategoriesService {
    @GET("categories")
    suspend fun fetchCategories():CategoriesResponseModel
}