package com.example.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.feature.R
import com.example.feature.screens.main_vidgets.CategoriesCard
import com.example.feature.screens.main_vidgets.CategoryText
import com.example.feature.screens.main_vidgets.RecepieCard
import com.example.feature.screens.main_vidgets.RecepieSearchBar
import com.example.feature.screens.main_vidgets.GreetingField
import com.example.feature.screens.main_vidgets.lazyRecipeCard

@Composable
fun MainScreen(){
    val vm  = viewModel<HomeViewModel>()

    val recipes by vm.recipes.collectAsState()

    val categories by vm.categories.collectAsState()

    val dailyRecipe by vm.dailyRecipe.collectAsState()

    val user by vm.user.collectAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(R.color.creamy))
    ) {
        user?.let { GreetingField(it) }
        RecepieSearchBar()
        dailyRecipe?.let {
            HorizontalCorousel(listOf(it, it))
        }
        CategoryText()
        categories?.let { CategoriesCard(it) }
        LazyRow () {
           items(recipes) { recipe ->
               lazyRecipeCard(recipe)
           }
        }
    }
}
