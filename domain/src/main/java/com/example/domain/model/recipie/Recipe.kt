package com.example.domain.model.recipie

data class Recipe(
    val id: String,
    val title: String,
    val cookingTimeMinutes: Int,
    val difficulty: String,
    val isDailyPick: Boolean = false,
    val tags : List<String>,
    val imageUrl : String,
    val rating : Double,
)
