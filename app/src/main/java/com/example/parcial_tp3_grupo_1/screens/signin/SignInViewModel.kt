package com.example.parcial_tp3_grupo_1.screens.signin

import androidx.lifecycle.ViewModel
import com.example.parcial_tp3_grupo_1.helpers.FakestoreHelper
import com.example.parcial_tp3_grupo_1.shared.GetServiceUsers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SignInViewModel: ViewModel() {
    suspend fun checkLogin(email: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            val service = GetServiceUsers(FakestoreHelper())
            val users = service.execute()
            users?.any { user -> user.email == email && user.password == password } ?: false
        }
    }
}