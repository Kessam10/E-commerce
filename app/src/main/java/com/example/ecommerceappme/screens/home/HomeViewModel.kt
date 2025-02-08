package com.example.ecommerceappme.screens.home

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.data.utils.handleError
import com.example.domain.entities.categories.CategoryItemEntity
import com.example.domain.useCases.categories.GetCategoriesUseCase
import com.example.ecommerceappme.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase
):BaseViewModel() {

    val errorState = mutableStateOf("")
    val categoriesState = mutableStateListOf<CategoryItemEntity>()
    fun getCategories(){
        viewModelScope.launch {
            try{
                val response = getCategoriesUseCase()
                if (categoriesState.isNotEmpty())
                    categoriesState.clear()
                categoriesState.addAll(response)
            }catch (e:Exception){
                errorState.value = "${e.message}"
            }
        }
    }
}