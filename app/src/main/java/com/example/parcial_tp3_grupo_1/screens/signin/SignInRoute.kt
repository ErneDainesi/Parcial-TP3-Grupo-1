package com.example.parcial_tp3_grupo_1.screens.signin

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.example.parcial_tp3_grupo_1.navigation.MainNavActions

@Composable
fun SignInRoute(
    navigationActions: MainNavActions,
    snackbarHostState: SnackbarHostState = remember {
        SnackbarHostState()
    }
) {
    SignInScreen(navigationActions)
}