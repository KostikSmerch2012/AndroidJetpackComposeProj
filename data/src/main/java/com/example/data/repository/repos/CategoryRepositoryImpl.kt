package com.example.data.repository.repos

import android.util.Log
import com.example.data.repository.remote.RecipeRemoteDataSource
import com.example.data.repository.repos.mappers.mapToRecipe
import com.example.domain.model.Item
import com.example.domain.model.recipie.Recipe
import com.example.domain.model.recipie.RecipeCategory
import com.example.domain.repository.CategoryRepository

class CategoryRepositoryImpl (
    val RecipeRemoteDataSource : RecipeRemoteDataSource
    ) : CategoryRepository{

    override suspend fun getCategory() : RecipeCategory? {
        val result = RecipeRemoteDataSource.getRecipeCategory()
        val category = result.response
        return category
    }
}