package com.example.domain.useCases.categories

import com.example.domain.entities.categories.CategoryItemEntity
import com.example.domain.repository.categories.CategoriesRepository
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: CategoriesRepository,
) {
    suspend operator fun invoke():List<CategoryItemEntity>{
        return repository.getCategories()
    }
}