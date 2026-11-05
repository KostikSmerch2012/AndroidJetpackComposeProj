package com.example.feature.screens.recipe_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.feature.home.HomeViewModel
import com.example.feature.screens.recipe_screen_widgets.RecipeCard
import com.example.feature.screens.recipe_screen_widgets.RecipeImageCard

@Composable
fun RecipeScreen(id : String){

    val vm  = viewModel<RecipeViewModel>()

    LaunchedEffect(Unit) {
        id.toIntOrNull()?.let { vm.fetchRecipe(it) }
    }

    val recipe by vm.recipe.collectAsState()

    if (recipe == null) return

    LazyColumn {
        item {
            RecipeCard(recipe!!)
        }
    }
}