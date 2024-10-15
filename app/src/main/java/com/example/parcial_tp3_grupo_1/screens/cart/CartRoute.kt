package com.example.parcial_tp3_grupo_1.screens.cart

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.parcial_tp3_grupo_1.helpers.FakeStoreHelper
import com.example.parcial_tp3_grupo_1.model.Cart
import com.example.parcial_tp3_grupo_1.navigation.MainNavActions
import com.example.parcial_tp3_grupo_1.shared.FakeStoreService

@Composable
fun CartRoute(navigationActions: MainNavActions) {
    val viewModel = remember { CartViewModel(FakeStoreService(FakeStoreHelper())) }

    val cart = remember { mutableStateOf<Cart?>(null) }

    LaunchedEffect(Unit) {
        cart.value = viewModel.getCart()
    }

    CartScreen(
        navActions = navigationActions,
        cart = cart.value,
        viewModel
    )
}