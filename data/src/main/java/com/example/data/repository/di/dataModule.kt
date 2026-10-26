package com.example.data.repository.di

import com.example.data.repository.remote.ApiService
import com.example.data.repository.remote.RecipeRemoteDataSource
import com.example.data.repository.remote.RetrofitClient
import com.example.data.repository.remote.UserRemoteDataSource
import com.example.data.repository.repos.CategoryRepositoryImpl
import com.example.data.repository.repos.RecipeRepositoryImpl
import com.example.data.repository.repos.UserRepositoryImpl
import com.example.domain.repository.CategoryRepository
import com.example.domain.repository.RecipeRepository
import com.example.domain.repository.UserRepository
import org.koin.dsl.module
import org.koin.plugin.module.dsl.single

val dataModule = module {
    single<ApiService> { RetrofitClient().buildRetrofitService() }
    single<RecipeRemoteDataSource> { RecipeRemoteDataSource(get()) }
    single<RecipeRepository> { RecipeRepositoryImpl(get()) }
    single<CategoryRepository> { CategoryRepositoryImpl(get()) }
    single { UserRemoteDataSource(get()) }
    single<UserRepository> { UserRepositoryImpl(get()) }
}