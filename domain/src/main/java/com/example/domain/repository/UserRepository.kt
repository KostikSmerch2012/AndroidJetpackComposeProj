package com.example.domain.repository

import com.example.domain.profile.User
import kotlinx.coroutines.flow.Flow


interface UserRepository {
    fun getUser(): Flow<User?>
    suspend fun insertUser(user: User)
}