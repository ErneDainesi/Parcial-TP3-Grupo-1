package com.example.parcial_tp3_grupo_1.screens.product

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.example.parcial_tp3_grupo_1.helpers.FakeStoreHelper
import com.example.parcial_tp3_grupo_1.navigation.MainNavActions
import com.example.parcial_tp3_grupo_1.shared.FakeStoreService

@Composable
fun ProductDetailRoute(
    productId: Int,
    navigationActions: MainNavActions,
    snackbarHostState: SnackbarHostState = remember {
        SnackbarHostState()
    }
) {
    val service = FakeStoreService(FakeStoreHelper())
    ProductDetailScreen(
        productId = productId,
        navigationActions = navigationActions,
        viewModel = ProductDetailViewModel(service)
    )
}