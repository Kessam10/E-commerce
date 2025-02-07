package com.example.ecommerceappme.screens.splash



sealed interface SplashDestination {

    data object Idle : SplashDestination
    data object Home : SplashDestination
    data object Login : SplashDestination
}