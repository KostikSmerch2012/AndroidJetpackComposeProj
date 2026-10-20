package com.example.domain.model.recipie

import com.example.domain.model.Item

data class RecipiesResponse(
    val items: List<Item>,
    val limit: Int,
    val page: Int,
    val total: Int
)