package com.example.ecommerceappme.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ecommerceappme.composables.ErrorDialog
import com.example.ecommerceappme.composables.LoadingDialog


@Composable
inline fun<reified VM: BaseViewModel> BaseScreen(
    content: @Composable (viewModel: VM) -> Unit,
) {
    val viewModel: VM = hiltViewModel()
    val baseState = viewModel.baseState.collectAsState()

    content(viewModel)
    LoadingDialog(
        isLoading = baseState.value.isLoading
    )
    ErrorDialog(
        errorMessage = baseState.value.errorMessage,
        dismissAction = viewModel::hideErrorMessage
    )
}