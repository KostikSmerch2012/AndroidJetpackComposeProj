package com.example.data.repository.repos

import com.example.data.repository.dao.UserDao
import com.example.data.repository.local.toDomain
import com.example.data.repository.local.toEntity
import com.example.domain.profile.User
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepositoryImpl(
    private val userDao: UserDao
): UserRepository {
    override fun getUser(): Flow<User?> {
        return userDao.getUser().map { entity -> entity?.toDomain() }
    }

    override suspend fun insertUser(user: User) {
        val entity = user.toEntity()
        userDao.insertUsers(entity)
    }
}