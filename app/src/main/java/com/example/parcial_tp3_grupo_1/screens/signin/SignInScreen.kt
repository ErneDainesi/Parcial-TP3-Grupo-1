package com.example.parcial_tp3_grupo_1.screens.signin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import com.example.parcial_tp3_grupo_1.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial_tp3_grupo_1.navigation.MainNavActions
import com.example.parcial_tp3_grupo_1.ui.components.BasicButton

@Composable
fun SignInScreen(
    navigationActions: MainNavActions,
) {
    var showPassword by remember {
        mutableStateOf(value = false)
    }
    var password by remember {
        mutableStateOf(value = "")
    }
    var email by remember {
        mutableStateOf(value = "")
    }
    Column (
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(R.drawable.carrot), contentDescription = "Carrot icon")
        }
        Spacer(modifier = Modifier.height(50.dp))
        Row {
            Column {
                Text(
                    text = "Sign In",
                    style = TextStyle(
                        fontWeight = FontWeight(600),
                        fontSize = 26.sp
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Enter your email and password",
                    color = Color(0xFF7C7C7C),
                    style = TextStyle(
                        fontSize = 16.sp
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Row {
            Column {
                Text(
                    color = Color(0xFF7C7C7C),
                    text = "Email",
                    style = TextStyle(
                        fontWeight = FontWeight(600)
                    )
                )
                TextField(
                    value = email,
                    onValueChange = { newEmail ->
                        email = newEmail
                    },
                    textStyle = TextStyle(
                        fontSize = 18.sp
                    ),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    color = Color(0xFF7C7C7C),
                    text = "Password",
                    style = TextStyle(
                        fontWeight = FontWeight(600)
                    )
                )
                TextField(
                    value = password,
                    onValueChange = { newPassword ->
                        password = newPassword
                    },
                    visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    textStyle = TextStyle(
                        fontSize = 18.sp
                    ),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent
                    ),
                    modifier = Modifier.fillMaxWidth(),
                    trailingIcon = {
                        IconButton(onClick = { showPassword = !showPassword }) {
                            Icon(
                                painter = painterResource(R.drawable.hidepassword),
                                contentDescription = "Hide password icon",
                            )
                        }
                    }
                )
                TextButton(
                    onClick = {},
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Text(
                        text = "Forgot Password?",
                        color = Color.Black
                    )
                }
            }
        }
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BasicButton(text = "Sign In", onClick = {})
                Row {
                    TextButton(onClick = {}) {
                        Text(
                            text = "Don't have an account?",
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(
                            text = "Signup",
                            color = Color(0xFF53B175)
                        )
                    }
                }
            }
        }
    }
}