package com.example.parcial_tp3_grupo_1.screens.product

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcial_tp3_grupo_1.model.Product
import com.example.parcial_tp3_grupo_1.shared.FakeStoreService
import kotlinx.coroutines.launch

class ProductDetailViewModel(
    private val fakeStoreService: FakeStoreService
) : ViewModel() {

    private val _product = mutableStateOf<Product?>(null)
    val product: State<Product?> = _product

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _errorMsg = mutableStateOf<String?>(null)
    val errorMsg: State<String?> = _errorMsg



    fun getProdById(id: Int) {
        _isLoading.value = true
        _errorMsg.value = null
        viewModelScope.launch {
            try {
                val response = fakeStoreService.getProductById(id)
                if (response != null) {
                    _product.value = response
                    Log.wtf("PDV", "product.value: $product")
                } else {
                    _errorMsg.value = "No se encontró el producto"
                }

            } catch (e: Exception) {
                _errorMsg.value = e.message
            } finally {
                _isLoading.value = false
            }


        }

    }


}