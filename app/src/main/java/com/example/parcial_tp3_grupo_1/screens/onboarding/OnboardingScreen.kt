package com.example.parcial_tp3_grupo_1.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial_tp3_grupo_1.R
import com.example.parcial_tp3_grupo_1.navigation.MainNavActions

@Composable
fun OnboardingScreen(
    navActions: MainNavActions
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(painterResource(id = R.drawable.onbording), contentScale = ContentScale.FillBounds)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = 32.dp,
                    vertical = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_blanco),
                contentDescription = "Logo Blanco",
                modifier = Modifier
                    .size(38.21.dp, 43.53.dp)
                    .padding(top = 412.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Welcome to our store",
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                fontSize = 48.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                lineHeight = 45.sp,
                modifier = Modifier
                    .width(287.dp)
                    .padding(vertical = 16.dp)
            )
            Text(
                text = "Get your groceries in as fast as one hour",
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(342.dp)
                    .padding(vertical = 8.dp)
            )
            Button(
                onClick = navActions.navigateToSignIn,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF53B175)
                ),
                modifier = Modifier
                    .width(353.dp)
                    .height(67.dp)
                    .padding(vertical = 16.dp)
            ) {
                Text(
                    text = "Get Started",
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
        }
    }
}
