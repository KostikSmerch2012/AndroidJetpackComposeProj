package com.example.feature.screens.all_categories_screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.feature.screens.all_categories_widgets.CategoriesCardMenue
import com.example.feature.screens.all_categories_widgets.OnMainButton
import com.example.feature.screens.main_widgets.CategoriesCard

@Composable
fun CategoriesScreen(id : String, onBackClick: () -> Unit){

    val vm  = viewModel<CategoriesViewModel>()

    LaunchedEffect(Unit) {
        id.let { vm.fetchCategories(it) }
    }

    val category by vm.category.collectAsState()

//    if (category == null) return

    LazyColumn {
        item {
            OnMainButton(onBackClick)
            CategoriesCardMenue(category)
        }
    }
}