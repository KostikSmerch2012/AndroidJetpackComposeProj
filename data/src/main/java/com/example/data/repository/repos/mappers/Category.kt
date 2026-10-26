package com.example.data.repository.repos.mappers

import com.example.domain.model.Category
import com.example.data.repository.remote.models.CategoryRemote

fun List<CategoryRemote>.mapToCategory() : List<Category> {
    return this.map {
        it.mapToCategory()
    }
}

fun CategoryRemote.mapToCategory() : Category {
    return Category(
        id = this.id,
        name = this.name,
        iconKey = this.iconKey
    )
}