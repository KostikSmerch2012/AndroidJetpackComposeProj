package com.example.data.repository.repos.mappers

import com.example.data.repository.remote.models.Item
import com.example.domain.model.recipie.Recipe

fun List<Item>.mapToRecipe() : List<Recipe> {
    return this.map {
        it.mapToRecipe()
    }
}

fun Item.mapToRecipe() : Recipe {
    return Recipe(
        id = this.id.toString(),
        title = this.title,
        cookingTimeMinutes = this.cookingTimeMinutes,
        difficulty = this.difficulty,
        isDailyPick = this.tags.contains("выбор дня"),
        isRedactionPick = this.tags.contains("выбор редакции"),
        tags = this.tags,
        imageUrl = this.imageUrl,
        rating = this.rating,
        authorName = this.authorName
    )
}