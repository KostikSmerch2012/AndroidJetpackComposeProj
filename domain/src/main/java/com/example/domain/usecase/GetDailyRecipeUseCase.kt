package com.example.domain.usecase

import com.example.domain.model.recipie.Recipe
import com.example.domain.repository.RecipeRepository

class GetDailyRecipeUseCase(
    private val recipeRepository: RecipeRepository,
) {
    suspend operator fun invoke(): Recipe? = recipeRepository.getDailyRecipe()
}
