package com.example.ecommerceappme.navigation

import androidx.compose.foundation.layout.padding
import com.example.ecommerceappme.composables.MyBottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ecommerceappme.screens.cart.CartScreen
import com.example.ecommerceappme.screens.categories.CategoriesScreen
import com.example.ecommerceappme.screens.login.LoginScreen
import com.example.ecommerceappme.screens.home.HomeScreen
import com.example.ecommerceappme.screens.profile.ProfileScreen
import com.example.ecommerceappme.screens.signup.SignupScreen
import com.example.ecommerceappme.screens.splash.SplashScreen
import com.example.ecommerceappme.screens.wishlist.WishListScreen
import java.util.Timer
import kotlin.concurrent.fixedRateTimer


@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val appNavigator = remember(navController) { AppNavigator(navController) }
    val currentDestination = rememberSaveable(stateSaver = AppDestinationSaver) {
        mutableStateOf(appNavigator.getCurrentDestination())
    }
    val timer: Timer = fixedRateTimer(initialDelay = 0, period = 1000) {
        println("Triggered at: $currentDestination")
    }

    val bottomBarState = rememberSaveable { mutableStateOf(true) }
    val topBarState = rememberSaveable { mutableStateOf(true) }

    when (currentDestination.value) {
        AppDestination.Home,
        AppDestination.Categories,
        AppDestination.Cart,
        AppDestination.Profile -> {
            bottomBarState.value = true
            topBarState.value = true
        }
        else -> {
            bottomBarState.value = false
            topBarState.value = false
        }
    }
    Scaffold(
        bottomBar = {if (bottomBarState.value){
            MyBottomAppBar(
                navigateToHome = { currentDestination.value = appNavigator.navigateTo(AppDestination.Home) },
                navigateToCategories = { currentDestination.value = appNavigator.navigateTo(AppDestination.Categories) },
                navigateToProfile = { currentDestination.value = appNavigator.navigateTo(AppDestination.Profile) },
                navigateToWishList = { currentDestination.value = appNavigator.navigateTo(AppDestination.WishList) },
                isVisible = bottomBarState.value,
                currentDestination = currentDestination.value
            )}
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppDestination.Splash, // 🔥 Splash is now the first screen
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<AppDestination.Splash> {
                SplashScreen(navigateToNextScreen = { destination ->
                    navController.navigate(destination) {
                        popUpTo(AppDestination.Splash) {
                            inclusive = true
                        } // 🔥 Remove Splash from back stack
                    }
                })
            }
            composable<AppDestination.Login> {
                LoginScreen(
                    navigateToSignUp = { currentDestination.value = appNavigator.navigateTo(AppDestination.SignUp) },
                    navigateToHome = { currentDestination.value = appNavigator.navigateAndClearBackStack(AppDestination.Home) }
                )
            }
            composable<AppDestination.SignUp> {
                SignupScreen(
                    navigateToLogin = { currentDestination.value = appNavigator.navigateAndClearBackStack(AppDestination.Login) },
                    navigateToHome = { currentDestination.value = appNavigator.navigateAndClearBackStack(AppDestination.Home) }
                )
            }
            composable<AppDestination.Home> {
                HomeScreen(navigateToMyCart = { appNavigator.navigateTo(AppDestination.Cart) })
            }
            composable<AppDestination.Categories> { CategoriesScreen() }
            composable<AppDestination.WishList> { WishListScreen() }
            composable<AppDestination.Profile> { ProfileScreen() }
            composable<AppDestination.Cart> { CartScreen() }
        }
    }
}
