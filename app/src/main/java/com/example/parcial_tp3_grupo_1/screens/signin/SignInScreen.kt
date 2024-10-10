package com.example.parcial_tp3_grupo_1.screens.signin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial_tp3_grupo_1.navigation.MainNavActions
import com.example.parcial_tp3_grupo_1.ui.components.BasicButton

@Composable
fun SignInScreen(
    navigationActions: MainNavActions,
) {
    Column (modifier = Modifier.padding(10.dp)) {
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
                    value = "Hola",
                    onValueChange = {},
                    textStyle = TextStyle(
                        fontSize = 18.sp
                    ),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent
                    )
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
                    value = "hola",
                    onValueChange = {},
                    visualTransformation = PasswordVisualTransformation(),
                    textStyle = TextStyle(
                        fontSize = 18.sp
                    ),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent
                    )
                )
                TextButton(onClick = {}) {
                    Text(
                        text = "Forgot Password?",
                        color = Color.Black
                    )
                }
            }
        }
        Row {
            Column {
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