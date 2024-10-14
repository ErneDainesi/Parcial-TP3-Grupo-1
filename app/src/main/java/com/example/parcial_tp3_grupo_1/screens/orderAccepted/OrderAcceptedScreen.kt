package com.example.parcial_tp3_grupo_1.screens.orderAccepted

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
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial_tp3_grupo_1.R

@Preview
@Composable
fun OrderAcceptedScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = 32.dp,
                    vertical = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.order_accepted),
                contentDescription = "Order Accepted",
                modifier = Modifier
                    .width(269.08.dp)
                    .height(240.31.dp)
                    .padding(top = 100.dp, bottom = 435.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Your Order has been accepted",
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(vertical = 16.dp)
            )
            Text(
                text = "Your items has been placed and is on it’s way to being processed",
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = Color(0xFF7C7C7C),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(283.dp)
                    .padding(vertical = 8.dp)
            )
            Button(
                onClick = { /* Acción del botón */ },
                modifier = Modifier
                    .width(345.dp)
                    .padding(vertical = 16.dp)
            ) {
                Text(
                    text = "Track Order",
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
            Text(
                text = "Back to home",
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .width(182.dp)
                    .padding(vertical = 5.dp)
            )
        }
    }
}