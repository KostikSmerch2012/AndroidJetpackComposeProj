package com.example.domain.model

data class RecipiesResponse(
    val items: List<Item>,
    val limit: Int,
    val page: Int,
    val total: Int
)