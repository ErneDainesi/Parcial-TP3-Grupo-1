package com.example.parcial_tp3_grupo_1.screens.product

import android.util.Log
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.example.parcial_tp3_grupo_1.helpers.FakeStoreHelper
import com.example.parcial_tp3_grupo_1.model.Product
import com.example.parcial_tp3_grupo_1.navigation.MainNavActions
import com.example.parcial_tp3_grupo_1.shared.FakeStoreService

@Composable
fun ProductDetailRoute(
    productId: Int,
    navigationActions: MainNavActions,
    viewModel: ProductDetailViewModel,
    snackbarHostState: SnackbarHostState = remember {
        SnackbarHostState()
    }
) {
    val isLoading by viewModel.isLoading
    val errorMsg by viewModel.errorMsg
    val product by viewModel.product

    LaunchedEffect(productId) {
        viewModel.getProdById(productId)
        Log.wtf("ProductDetailRoute", "productId: $productId, product: $product")
    }

    when {
        isLoading -> {
            // Loading
            Text(text = "Loading product")
//            CircularProgressIndicator()
        }
        errorMsg != null -> {
            // Error
            Text(text = "Error retrieving product")
            Log.e("error retrieving product", errorMsg!!)
        }
        product != null -> {
            val p = product!!
            Log.wtf("ppp", "p: $p")
            ProductDetailScreen(
                product = p,
                navigationActions = navigationActions,
            )
        }

        else ->{
            Log.wtf("Else", "Product is null")
        }

    }
}