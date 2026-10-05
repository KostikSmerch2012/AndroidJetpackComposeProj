package com.example.domain.usecase

import com.example.domain.model.Recipe
import com.example.domain.repository.RecipeRepository

class GetDailyRecipeUseCase(
    private val recipeRepository: RecipeRepository,
) {
    operator fun invoke(): Recipe? = recipeRepository.getDailyRecipe()
}
