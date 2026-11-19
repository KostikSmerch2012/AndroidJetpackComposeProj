package com.example.domain.model.recipie

data class Recipe(
    val id: String,
    val title: String,
    val cookingTimeMinutes: Int,
    val difficulty: String,
    val isDailyPick: Boolean = false,
    val isRedactionPick: Boolean = false,
    val tags : List<String>,
    val imageUrl : String,
    val rating : Double,
    val authorName : String,
    val description: String,
    val servings: Int,
    val calories: Int,
    val ingredients: List<Ingredients>?,
    val steps: List<Steps>?
)
