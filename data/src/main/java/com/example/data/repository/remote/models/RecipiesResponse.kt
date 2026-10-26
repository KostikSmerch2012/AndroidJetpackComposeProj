package com.example.data.repository.remote.models

data class RecipiesResponse(
    val items: List<Item>,
    val limit: Int,
    val page: Int,
    val total: Int
)