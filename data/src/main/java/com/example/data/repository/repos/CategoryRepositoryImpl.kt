package com.example.data.repository.repos

import com.example.data.repository.remote.RecipeRemoteDataSource
import com.example.data.repository.repos.mappers.mapToCategory
import com.example.domain.model.Category
import com.example.domain.repository.CategoryRepository

class CategoryRepositoryImpl (
    val RecipeRemoteDataSource : RecipeRemoteDataSource
    ) : CategoryRepository{

    override suspend fun getCategories() : List<Category> {
        val result = RecipeRemoteDataSource.getRecipeCategories()
        val categories = result.response
        if (categories!=null) {
            return categories.items.mapToCategory()
        } else {
            return  emptyList()
        }
    }
}