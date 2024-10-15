package com.example.parcial_tp3_grupo_1.screens.cart

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.parcial_tp3_grupo_1.model.Cart
import com.example.parcial_tp3_grupo_1.model.Product
import com.example.parcial_tp3_grupo_1.navigation.MainNavActions
import com.example.parcial_tp3_grupo_1.ui.components.BasicButton
import com.example.parcial_tp3_grupo_1.ui.components.CartItem
import com.example.parcial_tp3_grupo_1.ui.components.ProductCard
import kotlinx.coroutines.launch

@Composable
fun CartScreen(
    navActions: MainNavActions,
    cart: Cart?,
    viewModel: CartViewModel
) {
    val scope = rememberCoroutineScope()
    Column {
        LazyColumn {
            if (cart != null) {
                items(cart.products) { cartItem ->
                    val product by produceState<Product?>(initialValue = null, cartItem.productId) {
                        value = viewModel.getProductById(cartItem.productId)
                    }
                    product?.let { CartItem(product = it) }
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Box (modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp)) {
            BasicButton(text = "Go to checkout", onClick = navActions.navigateToCart)
        }
    }
}