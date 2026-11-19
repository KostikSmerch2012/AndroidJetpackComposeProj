package com.example.data.repository.remote.models

import com.example.domain.model.recipie.Ingredients
import com.example.domain.model.recipie.MealType
import com.example.domain.model.recipie.Steps

data class Item(
    val authorName: String,
    val calories: Int,
    val category: String,
    val cookingTimeMinutes: Int,
    val cuisine: String,
    val difficulty: String,
    val id: Int,
    val imageUrl: String,
    val isFeatured: Boolean,
    val isSaved: Boolean,
    val meal: MealType,
    val meatFree: Boolean,
    val rating: Double,
    val savesCount: Int,
    val spiciness: Any,
    val status: String,
    val tags: List<String>,
    val title: String,
    val description: String?,
    val servings: Int,
    val ingredients: List<Ingredients>,
    val steps: List<Steps>
)