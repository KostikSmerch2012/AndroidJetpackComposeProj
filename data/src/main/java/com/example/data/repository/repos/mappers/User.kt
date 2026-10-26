package com.example.data.repository.repos.mappers


import com.example.data.repository.remote.models.UserResponse
import com.example.domain.profile.User

fun UserResponse.mapToUser() : User {
    return User(
        id = this.id.toString(),
        name = this.name,
        handle = this.handle,
        city = this.city,
        avatarUrl = this.avatarUrl,
        bio = this.bio,
        recipesCount = this.recipesCount,
        savesCount = this.savesCount,
        followersCount = this.followersCount,
        draftsCount = this.draftsCount
    )
}