package com.example.parcial_tp3_grupo_1.screens.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.parcial_tp3_grupo_1.helpers.FakeStoreHelper
import com.example.parcial_tp3_grupo_1.model.Product
import com.example.parcial_tp3_grupo_1.navigation.MainNavActions
import com.example.parcial_tp3_grupo_1.shared.FakeStoreService

@Preview(showBackground = true)
@Composable
fun ProductDetailScreen(
    productId: Int
    = 1
    ,
//    navigationActions: MainNavActions,
    viewModel: ProductDetailViewModel
    = ProductDetailViewModel(FakeStoreService(FakeStoreHelper()))
) {

    val product by viewModel.product
    val isLoading by viewModel.isLoading
    val errorMsg by viewModel.errorMsg

    LaunchedEffect(Unit) {
        viewModel.getProdById(productId)
    }

    when{
        isLoading ->{
            CircularProgressIndicator()
        }

        errorMsg != null ->{
            Text(text = errorMsg!!)
        }

        product != null ->{
            ProductDetailView(product = product!!)
        }

        else -> {
            Text(text = "No se encontró el producto")
        }


    }



}

@Composable
fun ProductDetailView(product: Product) {

    Text(text = product.title)
    Text(text = product.description)
    Text(text = product.price.toString())
    Text(text = product.category)
}
