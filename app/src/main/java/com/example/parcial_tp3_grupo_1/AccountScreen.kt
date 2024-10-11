package com.example.parcial_tp3_grupo_1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import coil3.svg.SvgDecoder

@Composable
fun AccountScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = modifier.size(64.dp),
                shape = CircleShape,
                color = Color.Gray
            ) {
                Image(
                    painter = painterResource(id = R.drawable.randomprofile),
                    contentDescription = "Random profile",
                    modifier = modifier.size(64.dp)
                )
            }
            Spacer(modifier = modifier.width(16.dp))
            Column {
                Text(text = "Afsar Hossen", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text(text = "lmshuvo97@gmail.com", fontSize = 14.sp, color = Color.Gray)
            }
        }
        Spacer(modifier = modifier.size(24.dp))

        AccountButton("Orders")
        AccountButton("My Details")
        AccountButton("Delivery Address")
        AccountButton("Promo Card")
        AccountButton("Notification")
        AccountButton("Help")

        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Dark Mode", fontSize = 16.sp)
            Switch(
                checked = false,
                onCheckedChange = { /*TODO*/ }
            )
        }
        Spacer(modifier = modifier.height(24.dp))

        Button(
            onClick = { /*TODO*/ },
            modifier = modifier.fillMaxWidth()
        ) {
            Text(text = "Log Out")
        }
    }
}

@Composable
private fun AccountButton(text: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // TODO replace with bell icon
        // Image(
        //     painter = null,
        //     contentDescription = "Bell svg icon",
        //     modifier = modifier.size(24.dp)
        // )
        Spacer(modifier = modifier.width(16.dp))
        Text(text = text, fontSize = 16.sp)
    }
}