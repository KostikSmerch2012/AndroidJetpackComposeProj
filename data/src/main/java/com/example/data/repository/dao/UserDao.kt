package com.example.data.repository.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import com.example.data.repository.local.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Upsert
    suspend fun insertUsers(users: UserEntity)

    @Query("SELECT * FROM users")
    fun getUser(): Flow<UserEntity?>
}