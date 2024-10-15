package com.example.parcial_tp3_grupo_1.screens.signin

import androidx.lifecycle.ViewModel
import com.example.parcial_tp3_grupo_1.helpers.FakeStoreHelper
import com.example.parcial_tp3_grupo_1.shared.FakeStoreService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SignInViewModel : ViewModel() {
    suspend fun checkLogin(email: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val service = FakeStoreService(FakeStoreHelper())
            val users = service.getUsers()
            users?.any { user -> user.email == email && user.password == password } ?: false
        }
    }
}