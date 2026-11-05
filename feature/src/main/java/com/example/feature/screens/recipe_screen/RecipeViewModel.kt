package com.example.feature.screens.recipe_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.recipie.Recipe
import com.example.domain.repository.RecipeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.get

class RecipeViewModel : ViewModel() {
    val recipeRepository : RecipeRepository = get(RecipeRepository::class.java)

    private val _recipe : MutableStateFlow<Recipe?> = MutableStateFlow(null)
    val recipe : StateFlow<Recipe?>
        get() =  _recipe


    fun fetchRecipe(id : Int) = viewModelScope.launch {
       _recipe.value = recipeRepository.getRecipe(id)
    }
}