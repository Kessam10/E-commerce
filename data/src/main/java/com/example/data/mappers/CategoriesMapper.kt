package com.example.data.mappers

import com.example.data.model.categories.CategoriesResponseModel
import com.example.data.model.categories.CategoryDataModel
import com.example.domain.entities.categories.CategoriesResponse
import com.example.domain.entities.categories.CategoryItemEntity
import com.example.domain.entities.categories.Metadata

fun CategoriesResponseModel.toEntity(): CategoriesResponse {
    return CategoriesResponse(
        metadata?.toEntity(),
        data?.map {
            it?.toEntity()
        }, results = results
    )
}

fun CategoryDataModel.toEntity(): CategoryItemEntity {
    return CategoryItemEntity(image, createdAt, name, id, slug, updatedAt)

}

fun com.example.data.model.categories.Metadata.toEntity(): Metadata {
    return Metadata(numberOfPages, limit, currentPage)
}