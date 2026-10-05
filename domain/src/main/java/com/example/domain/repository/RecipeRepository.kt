package com.example.domain.repository

import com.example.domain.model.Recipe

interface RecipeRepository {
    fun getDailyRecipe(): Recipe?
}
