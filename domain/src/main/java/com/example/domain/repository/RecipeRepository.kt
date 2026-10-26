package com.example.domain.repository

import com.example.domain.model.recipie.Recipe

interface RecipeRepository {
    suspend fun getDailyRecipe(): Recipe?
    suspend fun getRecipes(query: String?, page: Int = 0, limit: Int = 0): List<Recipe>
    suspend fun getRecipesTasteToday(query: String?): List<Recipe>
}
