package com.example.domain.repository.categories

import com.example.domain.entities.categories.CategoryItemEntity

interface CategoriesRepository {
    suspend fun getCategories():List<CategoryItemEntity>
}

interface CategoriesOnlineDataSource{
    suspend fun fetchCategories():List<CategoryItemEntity>
}