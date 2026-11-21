package com.example.feature.screens.all_categories_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Category
import com.example.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.get

class CategoriesViewModel : ViewModel() {

    val categoryRepository: CategoryRepository = get(CategoryRepository::class.java)

    private val _category : MutableStateFlow<List<Category>> = MutableStateFlow(emptyList())

    val category: StateFlow<List<Category>>
        get() = _category

    fun fetchCategories(id : String) = viewModelScope.launch {
        _category.value = categoryRepository.getCategories()
    }

//    init {
//        viewModelScope.launch {
//            val categoryResponse: List<Category> = categoryRepository.getCategories()
//            _category.emit(categoryResponse)
//        }
//    }
}