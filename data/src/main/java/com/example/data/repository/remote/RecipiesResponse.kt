package com.example.data.repository.remote

import com.example.data.repository.local.Item

data class RecipiesResponse(
    val items: List<Item>,
    val limit: Int,
    val page: Int,
    val total: Int
)

