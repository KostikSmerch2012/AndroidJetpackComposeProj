package com.example.data.repository.repos

import android.util.Log
import androidx.room.util.query
import com.example.data.repository.dao.UserDao
import com.example.data.repository.local.toEntity
import com.example.data.repository.remote.ApiService
import com.example.data.repository.remote.RecipeRemoteDataSource
import com.example.data.repository.remote.UserRemoteDataSource
import com.example.data.repository.repos.mappers.mapToCategory
import com.example.data.repository.repos.mappers.mapToUser
import com.example.domain.model.Category
import com.example.domain.profile.User
import com.example.domain.repository.CategoryRepository
import com.example.domain.repository.UserRepository

//class UserRepositoryImpl(
//    private val userDao: UserDao,
//    private val apiService: ApiService
//): UserRepository {
//
//    override suspend fun getUser(): User {
//        val result = UserRemoteDataSource.getUser()
//        val user = result.res
//        return result
//    }
//
//    override suspend fun insertUser(user: User) {
//        val entity = user.toEntity()
//        userDao.insertUsers(entity)
//    }
//}
class UserRepositoryImpl (
    val UserRemoteDataSource : UserRemoteDataSource
) : UserRepository{

    override suspend fun getUser(
    ) : User? {
        val result = UserRemoteDataSource.getUser()
        val users = result.response
        Log.i(this.toString(), "UserName" + users)
        return users?.mapToUser()
    }

//    override suspend fun getUserName(
//        query : String?
//    ) : User? {
//        val user = this.getUser()
//        return user.ma
//    }
}