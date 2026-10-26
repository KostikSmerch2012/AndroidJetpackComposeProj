package com.example.feature.home

import android.util.Log
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.unit.dp
import com.example.domain.model.recipie.Recipe
import com.example.feature.screens.main_vidgets.RecepieCard
import com.example.feature.screens.main_vidgets.lazyRecipeCard
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun HorizontalCorousel(recipes : List<Recipe>) {

    var directionForward by remember { mutableStateOf(true) }

    val state = rememberPagerState(0) {
        recipes.size
    }

    val isDragged by state.interactionSource.collectIsDraggedAsState()

    if (!isDragged) {
        LaunchedEffect(state) {
            snapshotFlow { state.currentPage }.collect { page ->
                delay(4000)

                state.animateScrollToPage(state.currentPage + (1 * if (directionForward) 1 else -1))
                if (state.currentPage == recipes.size - 1 && directionForward) {
                    directionForward = false
                }
                if (!directionForward && state.currentPage == 0) {
                    directionForward = true
                }
            }

        }
    }

    HorizontalPager(
        state = state
    ) {
        RecepieCard(recipes.get(it))
    }
}