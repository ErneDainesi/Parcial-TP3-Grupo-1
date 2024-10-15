package com.example.parcial_tp3_grupo_1.screens.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.parcial_tp3_grupo_1.helpers.FakeStoreHelper
import com.example.parcial_tp3_grupo_1.model.Product
import com.example.parcial_tp3_grupo_1.navigation.MainNavActions
import com.example.parcial_tp3_grupo_1.shared.FakeStoreService

@Composable
fun HomeRoute(navActions: MainNavActions) {
    val viewModel = remember { HomeViewModel(FakeStoreService(FakeStoreHelper())) }

    val exclusiveList = remember { mutableStateOf<List<Product>?>(null) }
    val bestSellingList = remember { mutableStateOf<List<Product>?>(null) }

    LaunchedEffect(Unit) {
        exclusiveList.value = viewModel.getExclusiveOffers()
        bestSellingList.value = viewModel.getBestSelling()
    }

    HomeScreen(
        navActions = navActions,
        exclusiveOffers = exclusiveList.value ?: emptyList(),
        bestSelling = bestSellingList.value ?: emptyList()
    )
}