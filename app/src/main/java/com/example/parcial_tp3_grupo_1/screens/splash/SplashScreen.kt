package com.example.parcial_tp3_grupo_1.screens.splash
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial_tp3_grupo_1.R

@Preview
@Composable
fun SplashScreen() {
    // Fondo verde
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF53B175)) // Color verde de fondo
    ) {
        // Contenido centrado en la pantalla
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){Image(
            painter = painterResource(id = R.drawable.logo_nectar), // Reemplazar con el recurso correcto
            contentDescription = "Nectar Logo",
            modifier = Modifier
                .width(150.dp) // Ajusta el ancho según sea necesario
                .padding(bottom = 16.dp)
        )}
    }
}

