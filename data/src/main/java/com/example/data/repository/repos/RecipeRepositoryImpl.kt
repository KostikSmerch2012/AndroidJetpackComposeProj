package com.example.data.repository.repos

import android.util.Log
import com.example.data.repository.remote.RecipeRemoteDataSource
import com.example.data.repository.repos.mappers.mapToRecipe
import com.example.domain.model.Item
import com.example.domain.model.recipie.Recipe
import com.example.domain.repository.RecipeRepository

class RecipeRepositoryImpl(
    val recipeRemoteDataSource: RecipeRemoteDataSource
    ) : RecipeRepository {

    override suspend fun getDailyRecipe(): Recipe?  {
        val recipes : List<Recipe> = (recipeRemoteDataSource.getRecipes().response?.items ?: emptyList<Item>()).mapToRecipe()
        Log.i(this::class.java.name, "Recipies " + recipes)
        return recipes.firstOrNull { it.isDailyPick }
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

}