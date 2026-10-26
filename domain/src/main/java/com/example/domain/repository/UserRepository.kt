package com.example.domain.repository

import com.example.domain.profile.User

interface UserRepository {
    suspend fun getUser(): User?
//    suspend fun getUserName(): User?
}