package com.example.domain.entities.categories

data class CategoriesResponse(
	val metadata: Metadata? = null,
	val data: List<CategoryItemEntity>? = null,
	val results: Int? = null
)

data class CategoryItemEntity(
	val image: String? = null,
	val createdAt: String? = null,
	val name: String? = null,
	val id: String? = null,
	val slug: String? = null,
	val updatedAt: String? = null
)

data class Metadata(
	val numberOfPages: Int? = null,
	val limit: Int? = null,
	val currentPage: Int? = null
)

