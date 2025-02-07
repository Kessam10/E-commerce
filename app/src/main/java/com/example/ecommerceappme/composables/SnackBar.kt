package com.example.ecommerceappme.composables

import android.annotation.SuppressLint
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MySnackbarExample() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        Button(
            onClick = {
                scope.launch {
                    snackbarHostState.showSnackbar("Hello, this is a Snackbar!")
                }
            }
        ) {
            Text("Show Snackbar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSnackbar() {
    MySnackbarExample()
}
