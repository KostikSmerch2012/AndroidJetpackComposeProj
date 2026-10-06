package com.example.data.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.repository.dao.UserDao
import com.example.data.repository.local.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class Db : RoomDatabase() {
    abstract fun userDao(): UserDao
}