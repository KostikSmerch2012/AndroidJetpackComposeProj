package com.example.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.navArgument
import com.example.feature.navigation.AppDestination
import com.example.feature.screens.main_widgets.CategoriesCard
import com.example.feature.screens.main_widgets.CategoryCardText
import com.example.feature.screens.main_widgets.CategoryText
import com.example.feature.screens.main_widgets.RecepieSearchBar
import com.example.feature.screens.main_widgets.GreetingField
import com.example.feature.screens.main_widgets.lazyRecipeCard

@Composable
fun MainScreen(navController: NavController, modifier: Modifier = Modifier){
    val vm  = viewModel<HomeViewModel>()

    val recipes by vm.recipes.collectAsState()

    val categories by vm.categories.collectAsState()

    val dailyRecipes by vm.dailyRecipes.collectAsState()

    val user by vm.user.collectAsState()

    Column(modifier = modifier
        .fillMaxSize()
    ) {
        if (user == null) {
            Box(Modifier.height(44.dp))
        } else {
            GreetingField(user!!)
        }
        Spacer(modifier = Modifier.height(16.dp))
        RecepieSearchBar()

        if (recipes.isNullOrEmpty()) {
            Box(Modifier.height(244.dp)) { }
        } else {
            dailyRecipes?.let {
                HorizontalCorousel(it) {
                    navController.navigate(AppDestination.DETAIL_CARD.createRoute(it.id))
                }
            }
        }

        CategoryText()

        if (categories.isNullOrEmpty()) {
            Box(modifier = Modifier.height(48.dp))
        } else {
            categories?.let { CategoriesCard(it) }
        }
        CategoryCardText()

        if (recipes.isNullOrEmpty()){
            Box(modifier = Modifier.height(88.dp))
        } else {
            LazyRow() {
                items(recipes) { recipe ->
                    lazyRecipeCard(recipe) {
                        navController.navigate(AppDestination.DETAIL_CARD.createRoute(recipe.id))
                    }
                }
            }
        }
    }
}
