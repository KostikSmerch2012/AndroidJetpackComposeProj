package com.example.data.repository

import com.example.domain.model.Recipe
import com.example.domain.repository.RecipeRepository

class RecipeRepositoryImpl : RecipeRepository {

    private val recipes = listOf(
        Recipe(
            id = "shakshuka-feta",
            title = "Тёплая шакшука с фетой",
            cookingTimeMinutes = 25,
            difficulty = "легко",
            isDailyPick = true,
        ),
    )

    override fun getDailyRecipe(): Recipe? = recipes.firstOrNull { it.isDailyPick }
}
