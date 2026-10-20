package com.example.feature.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.recipie.Recipe
import com.example.domain.model.recipie.RecipeCategory
import com.example.domain.repository.CategoryRepository
import com.example.domain.repository.RecipeRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.KoinApplication.Companion.init
import org.koin.java.KoinJavaComponent.get

class HomeViewModel : ViewModel() {
    val recipeRepository : RecipeRepository = get(RecipeRepository::class.java)
    val categoryRepository : CategoryRepository = get(CategoryRepository::class.java)

    private val _dailyRecipe : MutableStateFlow<Recipe?> = MutableStateFlow(null)
    val dailyRecipe : StateFlow<Recipe?>
        get() = _dailyRecipe

    private val _recipes : MutableStateFlow<List<Recipe>> = MutableStateFlow(emptyList())
    val recipes : StateFlow<List<Recipe>>

        get() =  _recipes

    private val _category : MutableStateFlow<RecipeCategory?> = MutableStateFlow(null)
    val category : StateFlow<RecipeCategory?>
        get() = _category

    init {
        viewModelScope.launch {
            val recipesResponse = recipeRepository.getRecipes(null)
            _recipes.emit(recipesResponse)
        }
        viewModelScope.launch {
            val dailyRecipeResponse = recipeRepository.getDailyRecipe()
            _dailyRecipe.emit(dailyRecipeResponse)
        }
        viewModelScope.launch {
            val categoryRecipeResponce = categoryRepository.getCategory()
            _category.emit(categoryRecipeResponce)
        }
    }
}