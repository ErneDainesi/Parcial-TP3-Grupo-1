package com.example.parcial_tp3_grupo_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.parcial_tp3_grupo_1.ui.theme.ParcialTP3Grupo1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AccountsManager()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountsManager() {
    ParcialTP3Grupo1Theme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Accounts",
                            fontWeight = FontWeight.Bold
                        )
                    }
                )
            }
        ) { innerPadding ->
            AccountScreen(modifier = Modifier.padding(innerPadding))
        }
    }
}

@Composable
@Preview (showBackground = true)
fun AccountScreenPreview() {
    ParcialTP3Grupo1Theme {
        AccountsManager()
    }
}