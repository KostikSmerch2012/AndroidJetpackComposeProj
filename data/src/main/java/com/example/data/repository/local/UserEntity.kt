package com.example.data.repository.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.profile.User

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey()
    val id: String,

    @ColumnInfo(name = "avatar_url")
    val avatarUrl: String,

    val bio: String,
    val city: String,

    @ColumnInfo(name = "draft_count")
    val draftsCount: Int,

    @ColumnInfo(name = "followers_count")
    val followersCount: Int,

    val handle: String,
    val name: String,

    @ColumnInfo(name = "recipes_count")
    val recipesCount: Int,

    @ColumnInfo(name = "saves_count")
    val savesCount: Int
)

fun UserEntity.toDomain(): User {
    return User(
        id = this.id,
        name = this.name,
        handle = this.handle,
        avatarUrl = this.avatarUrl,
        bio = this.bio,
        city = this.city,
        draftsCount = this.draftsCount,
        followersCount = this.followersCount,
        recipesCount = this.recipesCount,
        savesCount = this.savesCount
    )
}

fun User.toEntity(): UserEntity {
    return UserEntity(
        id = this.id,
        name = this.name,
        handle = this.handle,
        avatarUrl = this.avatarUrl,
        bio = this.bio,
        city = this.city,
        draftsCount = this.draftsCount,
        followersCount = this.followersCount,
        recipesCount = this.recipesCount,
        savesCount = this.savesCount
    )
}