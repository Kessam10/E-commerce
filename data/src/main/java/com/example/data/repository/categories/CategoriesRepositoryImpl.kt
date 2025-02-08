package com.example.data.repository.categories

import com.example.domain.entities.categories.CategoryItemEntity
import com.example.domain.repository.categories.CategoriesOnlineDataSource
import com.example.domain.repository.categories.CategoriesRepository

class CategoriesRepositoryImpl(
    private val onlineDataSource: CategoriesOnlineDataSource
):CategoriesRepository {
    override suspend fun getCategories(): List<CategoryItemEntity> {
        return onlineDataSource.fetchCategories()
    }
}