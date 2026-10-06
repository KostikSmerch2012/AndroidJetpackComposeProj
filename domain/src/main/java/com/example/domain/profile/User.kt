package com.example.domain.profile

data class User(
    val avatarUrl: String,
    val bio: String,
    val city: String,
    val draftsCount: Int,
    val followersCount: Int,
    val handle: String,
    val id: String,
    val name: String,
    val recipesCount: Int,
    val savesCount: Int
)