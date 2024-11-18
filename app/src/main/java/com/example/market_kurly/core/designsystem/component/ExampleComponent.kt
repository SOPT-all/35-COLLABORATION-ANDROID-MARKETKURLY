package com.example.market_kurly.core.designsystem.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.market_kurly.R
import com.example.market_kurly.ui.theme.Gray4
import com.example.market_kurly.ui.theme.Gray6
import com.example.market_kurly.ui.theme.PrimaryColor200
import com.example.market_kurly.ui.theme.PrimaryColor400
import com.example.market_kurly.ui.theme.PrimaryColor600

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExampleTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String,
    modifier: Modifier = Modifier,
    isPasswordField: Boolean = false
) {
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(hint) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp),
        visualTransformation = if (isPasswordField && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon =
        if (isPasswordField) {
            {
                Text(
                    text = if (passwordVisible) stringResource(R.string.hide) else stringResource(R.string.show),
                    color = Color.White,
                    modifier = Modifier
                        .clickable { passwordVisible = !passwordVisible }
                        .padding(8.dp)
                )
            }
        } else null,
        colors = TextFieldDefaults.textFieldColors(
            containerColor = PrimaryColor200,
            focusedTextColor = PrimaryColor600,
            unfocusedTextColor = PrimaryColor400,
            focusedPlaceholderColor = Gray6,
            unfocusedPlaceholderColor = Gray4
        )
    )
}