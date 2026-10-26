package com.example.data.repository.remote

import android.util.Log
import com.example.data.repository.remote.models.CategoriesResponse
import com.example.data.repository.remote.models.UserResponse
import com.example.data.repository.remote.models.RecipiesResponse
import com.example.domain.model.recipie.SortType

class RecipeRemoteDataSource(private val apiService : ApiService) {

    suspend fun getRecipes(
        query: String? = null,
        maxTime: Int? = null,
        meal: String? = null,
        meatFree: Boolean? = null,
        cuisine: String? = null,
        category: String? = null,
        sort: SortType? = null,
        page: Int? = null,
        limit: Int? = null
    ) : ResponseModel<RecipiesResponse> {
        try {
            val response = apiService.getRecipes(
                query,
                maxTime,
                meal,
                meatFree,
                cuisine,
                category,
                sort?.nameStr,
                page,
                limit
            )
//            if (response.code() >= 400) {
//                return ResponseModel(error = response.
//            }
            Log.i(this::class.java.name, "Recipies " + response.body().toString())
            val responseBody = response.body() ?: return ResponseModel(error = "Неизвестная ошибка")
            return ResponseModel(responseBody)
        } catch (e : Exception) {
            Log.i(this::class.java.name, "error " + e.toString())
            return ResponseModel(error = e.toString())
        }
    }


    suspend fun getRecipeCategories() : ResponseModel<CategoriesResponse> {
        try {
            val response = apiService.getCategories()

            val responseBody = response.body() ?: return ResponseModel(error = "Неизвестная ошибка")
            return ResponseModel(responseBody)
        } catch (e : Exception) {
            return ResponseModel(error = e.toString())
        }
    }
}