package com.example.data.repository.repos

import android.util.Log
import com.example.data.repository.remote.RecipeRemoteDataSource
import com.example.data.repository.repos.mappers.mapToRecipe
import com.example.data.repository.remote.models.Item
import com.example.domain.model.recipie.Recipe
import com.example.domain.repository.RecipeRepository

class RecipeRepositoryImpl(
    val recipeRemoteDataSource: RecipeRemoteDataSource
    ) : RecipeRepository {

    override suspend fun getDailyRecipes(): List<Recipe>  {
        val recipes : List<Recipe> = (recipeRemoteDataSource.getRecipes().response?.items ?: emptyList<Item>()).mapToRecipe()
        Log.i(this::class.java.name, "Recipies " + recipes)
        try {
            return listOf(recipes.filter { it.isDailyPick }.first(), recipes.filter { it.isRedactionPick }.first())
        } catch (_: Exception) {
            return emptyList()
        }
    }

    override suspend fun getRecipe(id: Int): Recipe? {
        return try {
            recipeRemoteDataSource.getRecipe(id).response?.mapToRecipe()
        } catch (_: Exception) {
            null
        }
    }

    override suspend fun getRecipes(
        query : String?,
        page : Int,
        limit : Int
    ): List<Recipe> {
        val recipes : List<Recipe> = (recipeRemoteDataSource.getRecipes(
            query,
            page=page,
            limit=limit
        ).response?.items ?: emptyList<Item>()).mapToRecipe()
        return recipes
    }

    override suspend fun getRecipesTasteToday(
        query : String?
    ): List<Recipe> {
        return this.getRecipes(
            query
        ).filter {
           !it.tags.contains("выбор дня") &&  !it.tags.contains("выбор редакции")

        }
    }
}