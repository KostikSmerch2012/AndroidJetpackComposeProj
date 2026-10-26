package com.example.data.repository.remote

import com.example.data.repository.remote.models.UserResponse

class UserRemoteDataSource (private val apiService: ApiService) {
    suspend fun getUser() : ResponseModel<UserResponse> {
        try {
            val response = apiService.getUser()

            val responseBody = response.body() ?: return ResponseModel(error = "Неизвестная ошибка")
            return ResponseModel(responseBody)
        } catch (e : Exception) {
            return ResponseModel(error = e.toString())
        }
    }
}