package com.example.ecommerceappme.navigation.mappers

import com.example.ecommerceappme.navigation.AppDestination

fun AppDestination.toRoute(): String {
    return when (this) {
        AppDestination.Splash -> "splash"
        AppDestination.Home -> "home"
        AppDestination.Login -> "login"
        AppDestination.SignUp -> "signup"
        AppDestination.Splash -> "splash"
        AppDestination.Categories -> "categories"
        AppDestination.Profile -> "profile"
        AppDestination.WishList -> "wishlist"
        AppDestination.Cart -> "cart"
    }
}