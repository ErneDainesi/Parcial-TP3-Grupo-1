package com.example.parcial_tp3_grupo_1.screens.onboarding

import androidx.compose.runtime.Composable
import com.example.parcial_tp3_grupo_1.navigation.MainNavActions
import com.example.parcial_tp3_grupo_1.screens.splash.OnboardingScreen

@Composable
fun OnboardingRoute(
    navigationActions: MainNavActions
) {
    OnboardingScreen(navigationActions)
}

