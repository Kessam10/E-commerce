package com.example.ecommerceappme.screens.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ecommerceappme.R
import com.example.ecommerceappme.composables.AuthCustomButton
import com.example.ecommerceappme.composables.AuthTextField
import com.example.ecommerceappme.ui.theme.greyAuth
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel


@Composable
fun SignupScreen(
    modifier: Modifier = Modifier,
    navigateToLogin: () -> Unit,
    navigateToHome: () -> Unit,
    viewModel: SignupViewModel = hiltViewModel()
) {


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = stringResource(R.string.logo_image),
                modifier = Modifier.size(200.dp)
            )
        }

        item {
            Text(
                text = stringResource(R.string.get_started_now),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        }

        item {
            Text(
                text = stringResource(R.string.create_an_account_or_log_in_to_explore),
                fontSize = 12.sp
            )
        }

        item {
            Text(text = stringResource(R.string.our_app), fontSize = 12.sp)
        }

        item {
            Spacer(modifier = Modifier.height(10.dp))
        }

        item {
            Row(
                modifier = Modifier
                    .padding(25.dp)
                    .background(color = greyAuth)
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                // Login Section
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .background(if (viewModel.selectedTab == "login") Color.White else greyAuth)
                        .clickable {
                            viewModel.selectedTab = "login"
                            navigateToLogin()
                        }
                        .padding(5.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(R.string.log_in),
                        color = if (viewModel.selectedTab == "login") Color.Black else Color.Gray,
                        fontSize = 16.sp
                    )
                }

                // Sign Up Section
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .background(if (viewModel.selectedTab == "sign_up") Color.White else greyAuth)
                        .clickable {
                            viewModel.selectedTab = "sign_up"
                        }
                        .padding(5.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(R.string.sign_up),
                        color = if (viewModel.selectedTab == "sign_up") Color.Black else Color.Gray,
                        fontSize = 16.sp
                    )
                }
            }
        }
        item {
            Text(
                text = "Full Name",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp)
            )
        }

        item {
            AuthTextField(
                value = viewModel.fullName,
                onValueChange = { viewModel.fullName = it },
                label = stringResource(R.string.enter_your_full_name),
                error = viewModel.fullNameError,
                isPasswordField = false,
            )
        }

        item { Spacer(modifier = Modifier.height(20.dp)) }

        item {
            Text(
                text = stringResource(R.string.email),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp)
            )
        }

        item {
            AuthTextField(
                value = viewModel.email,
                onValueChange = { viewModel.email = it },
                label = stringResource(R.string.enter_your_email),
                error = viewModel.emailError,
                isPasswordField = false,
            )
        }

        item { Spacer(modifier = Modifier.height(20.dp)) }

        item {
            Text(
                stringResource(R.string.phone_number),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp)
            )
        }

        item {
            AuthTextField(
                value = viewModel.phoneNumber,
                onValueChange = { viewModel.phoneNumber = it },
                label = stringResource(R.string.enter_your_phone_number),
                error = viewModel.phoneNumberError,
                isPasswordField = false,
            )
        }

        item { Spacer(modifier = Modifier.height(20.dp)) }

        item {
            Text(
                stringResource(R.string.password),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp)
            )
        }

        item {
            AuthTextField(
                value = viewModel.password,
                onValueChange = { viewModel.password = it },
                label = stringResource(R.string.enter_your_password),
                error = viewModel.passwordError,
                isPasswordField = true,
            )
        }

        item { Spacer(modifier = Modifier.height(30.dp)) }

        item {
            AuthCustomButton(text = "Login", onClick = {viewModel.register()})
        }
    }
    if (viewModel.isSuccess){
        navigateToHome()
    }

}

@Preview(showSystemUi = true)
@Composable
fun SignupScreenPreview() {
    SignupScreen(navigateToLogin = {}, navigateToHome = {})
}
