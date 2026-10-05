package com.example.domain.model

data class Recipe(
    val id: String,
    val title: String,
    val cookingTimeMinutes: Int,
    val difficulty: String,
    val isDailyPick: Boolean = false,
)
