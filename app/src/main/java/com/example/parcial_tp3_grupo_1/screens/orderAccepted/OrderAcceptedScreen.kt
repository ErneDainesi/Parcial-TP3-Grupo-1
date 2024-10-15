package com.example.parcial_tp3_grupo_1.screens.orderAccepted

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial_tp3_grupo_1.R
import com.example.parcial_tp3_grupo_1.navigation.MainNavActions

@Composable
fun OrderAcceptedScreen(
    navigationActions: MainNavActions
) {
    Box(
        modifier = Modifier.background(Color.White),
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(
                    start = 30.dp,
                    end = 30.dp
                )
                .fillMaxSize()
                .fillMaxWidth()
                .background(Color.White)
        ) {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 100.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.order_accepted),
                        contentDescription = "Order Accepted",
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            Spacer(modifier = Modifier.height(100.dp))
            Column {
                Text(
                    text = "Your order has been accepted",
                    style = TextStyle(
                        fontSize = 28.sp,
                        fontWeight = FontWeight(600),
                        textAlign = TextAlign.Center
                    )
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Your items has been placed and is on it’s way to being processed",
                    style = TextStyle(
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    ),
                    color = Color(0xFF7C7C7C)
                )
            }
            Spacer(modifier = Modifier.height(200.dp))
            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF53B175)
                        ),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Track order")
                    }
                    TextButton(onClick = navigationActions.navigateToShop) {
                        Text(text = "Back to Home", color = Color.Black)
                    }
                }
            }
        }
    }
}