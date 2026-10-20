package com.example.domain.repository

import com.example.domain.model.recipie.RecipeCategory

interface CategoryRepository {
    suspend fun getCategory(): RecipeCategory?
}