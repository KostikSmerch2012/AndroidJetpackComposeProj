package com.example.data.repository.repos.mappers

import com.example.domain.model.Category
import com.example.domain.model.recipie.RecipeCategory

fun List<Category>.mapToCategory() : List<RecipeCategory> {
    return this.map {
        it.mapToCategory()
    }
}

fun Category.mapToCategory() : RecipeCategory {
    return RecipeCategory(
        id = this.id.toString(),
        name = this.name.toString(),
        iconKey = this.iconKey.toString()
    )
}