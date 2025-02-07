package com.example.ecommerceappme.composables.search

import androidx.compose.runtime.mutableStateOf
import com.example.ecommerceappme.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(): BaseViewModel() {

    private val _searchQuery = mutableStateOf("")
    val searchQuery :String get() = _searchQuery.value

    private val _isFocused = mutableStateOf(false)
    val isFocused :Boolean get() = _isFocused.value


    fun setSearchQuery(query:String){
        _searchQuery.value = query
    }
}