package com.example.feature.navigation

import androidx.annotation.DrawableRes
import com.example.feature.R

enum class DestinationNavBar(
    val appDestination: AppDestination,
    val label: String,
    @DrawableRes
    val icon: Int
) {
    HOME(AppDestination.HOME, "Главная", R.drawable.nav_bar_home),
    SEARCH(AppDestination.SEARCH, "Поиск", R.drawable.nav_bar_search),
    SAVED(AppDestination.SAVED, "Сохранено", R.drawable.nav_bar_heart),
    CREATE(AppDestination.CREATE,"Создать", R.drawable.nav_bar_add),
    PROFILE(AppDestination.PROFILE, "Профиль", R.drawable.nav_bar_user)
}

enum class AppDestination(
    val route: String,
) {
    HOME("home"),
    SEARCH("search"),
    SAVED("saved"),
    CREATE("create"),
    PROFILE("profile"),
    DETAIL_CARD("detail/{id}");

    fun createRoute(id: String): String {
        return route.replace("{id}", id)
    }
}


