package com.example.ecommerceappme.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerceappme.ui.theme.errorLight
import com.example.ecommerceappme.ui.theme.onSurfaceLight
import com.example.ecommerceappme.ui.theme.outlineLight
import com.example.ecommerceappme.ui.theme.outlineVariantLight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff


@Composable
fun AuthTextField(
    value: String,
    label: String,
    error: String,
    isPasswordField: Boolean = false,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
) {
    var passwordVisible by remember { mutableStateOf(false) }

    Column {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(text = label, color = onSurfaceLight) },
            textStyle = LocalTextStyle.current.copy(color = onSurfaceLight),
            singleLine = true,
            visualTransformation = if (isPasswordField && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
            trailingIcon = if (isPasswordField) {
                {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                        contentDescription = if (passwordVisible) "Hide password" else "Show password",
                        tint = onSurfaceLight,
                        modifier = Modifier.clickable { passwordVisible = !passwordVisible }
                    )
                }
            } else null,
            modifier = Modifier
                .fillMaxWidth(),
            isError = error.isNotEmpty(),
            shape = RoundedCornerShape(15.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                focusedBorderColor = outlineVariantLight,
                unfocusedBorderColor = outlineLight,
                focusedTextColor = onSurfaceLight,
                unfocusedTextColor = onSurfaceLight,
                cursorColor = outlineLight,
                errorCursorColor = errorLight,
                errorBorderColor = errorLight
            ),
            keyboardOptions = keyboardOptions
        )
        if (error.isNotEmpty()) {
            Text(text = error, color = Color.Red, fontSize = 12.sp)
        }
    }
}

@PreviewLightDark
@Composable
fun CustomTextFieldPreview() {
    AuthTextField(
        value = "",
        label = "Password",
        error = "",
        isPasswordField = true,
        onValueChange = {},
        keyboardOptions = KeyboardOptions()
    )
}
