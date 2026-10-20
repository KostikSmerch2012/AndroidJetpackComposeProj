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
import com.example.feature.screens.main_vidgets.RecepieCard
import com.example.feature.screens.main_vidgets.RecepieSearchBar
import com.example.feature.screens.main_vidgets.GreetingField
import com.example.feature.screens.main_vidgets.ScrollableTopStartCard
import com.example.feature.screens.main_vidgets.lazyRecipeCard

@Preview
@Composable
fun MainScreen(){
    val vm  = viewModel<HomeViewModel>()

    val recipes by vm.recipes.collectAsState()

    val category by vm.category.collectAsState()

    val dailyRecipe by vm.dailyRecipe.collectAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(R.color.creamy))
    ) {
        GreetingField()
        RecepieSearchBar()
        dailyRecipe?.let { RecepieCard(it) }

        LazyRow () {
           items(recipes) { recipe ->
               lazyRecipeCard(recipe)
           }
        }
    }
}
