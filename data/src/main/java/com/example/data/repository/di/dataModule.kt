package com.example.data.repository.di

import com.example.data.repository.remote.ApiService
import com.example.data.repository.remote.RecipeRemoteDataSource
import com.example.data.repository.remote.RetrofitClient
import com.example.data.repository.repos.CategoryRepositoryImpl
import com.example.data.repository.repos.RecipeRepositoryImpl
import com.example.domain.repository.CategoryRepository
import com.example.domain.repository.RecipeRepository
import org.koin.dsl.module

val dataModule = module {
    single<ApiService> { RetrofitClient().buildRetrofitService() }
    single<RecipeRemoteDataSource> { RecipeRemoteDataSource(get()) }
    single<RecipeRepository> { RecipeRepositoryImpl(get()) }
    single<CategoryRepository> { CategoryRepositoryImpl(get()) }
}