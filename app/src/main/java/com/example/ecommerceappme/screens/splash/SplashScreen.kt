package com.example.ecommerceappme.screens.splash

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ecommerceappme.R
import com.example.ecommerceappme.navigation.AppDestination


@Composable
fun SplashScreen(
    navigateToNextScreen: (AppDestination) -> Unit,
    splashViewModel: SplashViewModel = hiltViewModel()
) {
    LaunchedEffect(splashViewModel.navigationState.value) {
        splashViewModel.checkAccessToken()
        when (splashViewModel.navigationState.value) {
            AppDestination.Home -> navigateToNextScreen(AppDestination.Home)
            AppDestination.Login -> navigateToNextScreen(AppDestination.Login)
            else -> Unit
        }
    }



//    when (splashViewModel.navigationState.value) {
//            AppDestination.Home -> {
//
//                navigateToNextScreen(AppDestination.Home)
//            }
//            AppDestination.Login -> {
//
//                navigateToNextScreen(AppDestination.Login)
//            }
//            else -> Unit
//
//    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),  // 🔥 Add background color to remove transparency
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "App Logo",
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
        }
    }
}
