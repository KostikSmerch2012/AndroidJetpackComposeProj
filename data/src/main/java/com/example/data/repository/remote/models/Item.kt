package com.example.data.repository.remote.models

import com.example.domain.model.recipie.MealType

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
)