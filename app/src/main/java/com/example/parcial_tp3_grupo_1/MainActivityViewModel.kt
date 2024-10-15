package com.example.parcial_tp3_grupo_1

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivityViewModel () : ViewModel(){

    private val _showFAB = mutableStateOf(false)
    val showFAB: State<Boolean> = _showFAB

    fun showFloatingActionButton() {
        _showFAB.value = true

        viewModelScope.launch {
            delay(3000L)
            _showFAB.value = false
        }
    }

}