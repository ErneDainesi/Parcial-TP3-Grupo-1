package com.example.parcial_tp3_grupo_1.screens.favorite

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.parcial_tp3_grupo_1.helpers.FakeStoreHelper
import com.example.parcial_tp3_grupo_1.model.Product
import com.example.parcial_tp3_grupo_1.navigation.MainNavActions
import com.example.parcial_tp3_grupo_1.shared.FakeStoreService

@Composable
fun FavoriteRoute(navigationActions: MainNavActions) {

    val viewModel = remember {
        FavoriteViewModel(FakeStoreService(FakeStoreHelper()))
    }

    val favorites = remember { mutableStateOf<List<Product>?>(null)}

    LaunchedEffect(Unit) {
        favorites.value = viewModel.getFavorites()
    }


    FavoriteScreen(
        products = favorites.value ?: emptyList(),
        navigationActions = navigationActions
    )
}