package com.example.ecommerceappme.navigation.mappers

import androidx.navigation.NavBackStackEntry
import com.example.ecommerceappme.navigation.AppDestination

fun NavBackStackEntry?.fromRoute():AppDestination{
    this?.destination?.route?.substringBefore("?")?.substringBefore("/")
        ?.substringAfterLast(".")?.let {
            return when(it) {
                AppDestination.Splash::class.simpleName -> AppDestination.Splash
                AppDestination.Login::class.simpleName -> AppDestination.Login
                AppDestination.SignUp::class.simpleName -> AppDestination.SignUp
                AppDestination.Home::class.simpleName -> AppDestination.Home
                AppDestination.Categories::class.simpleName -> AppDestination.Categories
                AppDestination.WishList::class.simpleName -> AppDestination.WishList
                AppDestination.Profile::class.simpleName -> AppDestination.Profile
                AppDestination.Cart::class.simpleName ->AppDestination.Cart

                else -> AppDestination.Splash
            }
        }
    return AppDestination.Splash
}