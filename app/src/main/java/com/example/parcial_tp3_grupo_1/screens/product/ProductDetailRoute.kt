package com.example.parcial_tp3_grupo_1.screens.product

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.parcial_tp3_grupo_1.helpers.FakeStoreHelper
import com.example.parcial_tp3_grupo_1.model.Product
import com.example.parcial_tp3_grupo_1.model.Rating
import com.example.parcial_tp3_grupo_1.navigation.MainNavActions
import com.example.parcial_tp3_grupo_1.shared.FakeStoreService

@Composable
fun ProductDetailRoute(
    productId: Int,
    navigationActions: MainNavActions,
//    viewModel: ProductDetailViewModel,
    snackbarHostState: SnackbarHostState = remember {
        SnackbarHostState()
    }
) {
    val viewModel = remember { ProductDetailViewModel(FakeStoreService(FakeStoreHelper())) }

    val productP = remember { mutableStateOf<Product?>(null) }

    LaunchedEffect(Unit) {
        productP.value = viewModel.getProd(productId)
    }

    ProductDetailScreen(
        product = productP.value ?: Product(
            id = 0,
            title = "Loading...",
            price = 0.0,
            description = "Loading...",
            category = "Loading...",
            image = "https://media.istockphoto.com/id/1335247217/vector/loading-icon-vector-illustration.jpg?s=612x612&w=0&k=20&c=jARr4Alv-d5U3bCa8eixuX2593e1rDiiWnvJLgHCkQM=",
            rating = Rating(0.0, 0)
        ), navigationActions = navigationActions
    )
}