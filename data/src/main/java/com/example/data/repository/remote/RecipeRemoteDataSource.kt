package com.example.data.repository.remote

import android.util.Log
import com.example.data.repository.remote.models.UserResponse
import com.example.domain.model.recipie.RecipeCategory
import com.example.domain.model.recipie.RecipiesResponse
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

    suspend fun getUser() : ResponseModel<UserResponse> {

        try {
            val response = apiService.getUser()

            val responseBody = response.body() ?: return ResponseModel(error = "Неизвестная ошибка")
            return ResponseModel(responseBody)
        } catch (e : Exception) {
            return ResponseModel(error = e.toString())
        }

    }

    suspend fun getRecipeCategory() : ResponseModel<RecipeCategory> {
        try {
            val response = apiService.getCategory()

            val responseBody = response.body() ?: return ResponseModel(error = "Неизвестная ошибка")
            return ResponseModel(responseBody)
        } catch (e : Exception) {
            return ResponseModel(error = e.toString())
        }
    }
}