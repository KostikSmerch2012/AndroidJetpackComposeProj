package com.example.data.repository.repos

import com.example.data.repository.dao.UserDao
import com.example.data.repository.local.toDomain
import com.example.data.repository.local.toEntity
import com.example.data.repository.remote.ApiService
import com.example.domain.profile.User
import com.example.domain.repository.UserRepository
import java.nio.file.attribute.UserPrincipal

class UserRepositoryImpl(
    private val userDao: UserDao,
    private val apiService: ApiService
//    private val
): UserRepository {
    override suspend fun getUser(): User? {
        return userDao.getUser()?.toDomain()
    }

    override suspend fun insertUser(user: User) {
        val entity = user.toEntity()
        userDao.insertUsers(entity)
    }
}