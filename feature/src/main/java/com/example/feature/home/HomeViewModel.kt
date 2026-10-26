package com.example.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Category
import com.example.domain.model.recipie.Recipe
import com.example.domain.profile.User
import com.example.domain.repository.CategoryRepository
import com.example.domain.repository.RecipeRepository
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.get

class HomeViewModel : ViewModel() {
    val recipeRepository : RecipeRepository = get(RecipeRepository::class.java)
    val categoryRepository : CategoryRepository = get(CategoryRepository::class.java)
    val userRepository : UserRepository = get(UserRepository::class.java)

    private val _dailyRecipe : MutableStateFlow<Recipe?> = MutableStateFlow(null)
    val dailyRecipe : StateFlow<Recipe?>
        get() = _dailyRecipe

    private val _recipes : MutableStateFlow<List<Recipe>> = MutableStateFlow(emptyList())
    val recipes : StateFlow<List<Recipe>>

        get() =  _recipes

    private val _categories : MutableStateFlow<List<Category>> = MutableStateFlow(emptyList())
    val categories : StateFlow<List<Category>>
        get() = _categories

    private val _user : MutableStateFlow<User?> = MutableStateFlow(null)
    val user : StateFlow<User?>
        get() = _user

    init {
        viewModelScope.launch {
            val recipesResponse = recipeRepository.getRecipesTasteToday(null)
            _recipes.emit(recipesResponse)
        }
        viewModelScope.launch {
            val dailyRecipeResponse = recipeRepository.getDailyRecipe()
            _dailyRecipe.emit(dailyRecipeResponse)
        }
        viewModelScope.launch {
            val categoriesRecipeResponce: List<Category> = categoryRepository.getCategories()
            _categories.emit(categoriesRecipeResponce)
        }
        viewModelScope.launch {
            val userResponse = userRepository.getUser()
            _user.emit(userResponse)
        }
    }
}