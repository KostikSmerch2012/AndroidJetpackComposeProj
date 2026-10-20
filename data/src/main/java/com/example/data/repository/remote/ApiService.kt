package com.example.data.repository.remote

import com.example.data.repository.remote.models.UserResponse
import com.example.domain.model.recipie.RecipeCategory
import com.example.domain.model.recipie.RecipiesResponse
import com.example.domain.profile.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("recipes")
    suspend fun getRecipes(
        @Query("q")
        query : String?,
        @Query("maxTime")
        maxTime : Int?,
        @Query("meal")
        meal : String?,
        @Query("meatFree")
        meatFree : Boolean?,
        @Query("cuisine")
        cuisine : String?,
        @Query("category")
        category : String?,
        @Query("sort")
        sort : String?,
        @Query("page")
        page : Int?,
        @Query("limit")
        limit : Int?
        ) : Response<RecipiesResponse>

    @GET("profile")
    suspend fun getUser() : Response<UserResponse>

    @GET("category")
    suspend fun getCategory() : Response<RecipeCategory>
}