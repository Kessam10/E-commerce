package com.example.data.dataSource.categories

import android.util.Log
import com.example.data.mappers.toEntity
import com.example.data.online.api.CategoriesService
import com.example.data.utils.handleError
import com.example.domain.entities.categories.CategoryItemEntity
import com.example.domain.repository.categories.CategoriesOnlineDataSource

class CategoriesOnlineDataSourceImpl(
    private val webService:CategoriesService
):CategoriesOnlineDataSource {
    override suspend fun fetchCategories(): List<CategoryItemEntity> {
        return try {
            webService.fetchCategories().toEntity().data ?: listOf()
        }catch (e:Exception){
            Log.e("TAG", "fetchCategories:$e " )
            throw handleError(e)
        }
    }
}