package com.example.data.repository.remote.models

data class CategoriesResponse(
    val items: List<CategoryRemote>,
    val limit: Int,
    val page: Int,
    val total: Int
)