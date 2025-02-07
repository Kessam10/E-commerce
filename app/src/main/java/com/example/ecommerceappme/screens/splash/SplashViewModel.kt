package com.example.ecommerceappme.screens.splash

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.domain.useCases.auth.GetAccessTokenUseCase
import com.example.ecommerceappme.base.BaseViewModel
import com.example.ecommerceappme.navigation.AppDestination
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val getAccessTokenUseCase: GetAccessTokenUseCase,
) :BaseViewModel(){
    val navigationState = mutableStateOf<AppDestination>(AppDestination.Splash)


    fun checkAccessToken() {
        viewModelScope.launch {
            val token = getAccessTokenUseCase().trim() // Trim spaces to avoid issues
            navigationState.value = if (token.isNotEmpty()) AppDestination.Home else AppDestination.Login
        }
    }

//    fun checkAccessToken(){
//        viewModelScope.launch {
//            val token = getAccessTokenUseCase()
//            if (token.isEmpty()){
//                //navigate to login
//                navigationState.value = AppDestination.Login
//            }else{
//                //navigate To home
//                navigationState.value = AppDestination.Home
//
//            }
//        }
//    }
}