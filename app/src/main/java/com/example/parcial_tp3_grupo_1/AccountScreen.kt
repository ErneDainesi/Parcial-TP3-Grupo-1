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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AccountScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = CircleShape,
                modifier = Modifier
                    .size(100.dp)
                    .padding(16.dp),
                color = Color(0xFFEFEFEF)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tp3profile),
                    contentDescription = "Random profile",
                )
            }

            Column {
                Text(text = "Afsar Hossen", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black)
                Text(text = "lmshuvo97@gmail.com", fontSize = 14.sp, color = Color.Gray)
            }
        }
        AccountButton("Orders", R.drawable.orders_icon)
        AccountButton("My Details", R.drawable.my_details_icon)
        AccountButton("Delivery Address", R.drawable.delivery_address_icon)
        AccountButton("Promo Card", R.drawable.promo_card_icon)
        AccountButton("Notification", R.drawable.bell_icon)
        AccountButton("Help", R.drawable.help_icon)

        Row(
            modifier = modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Dark Mode", fontSize = 16.sp, color = Color.Black)
            Switch(
                checked = false,
                onCheckedChange = { /*TODO*/ }
            )
        }
        LogOutButton()
    }
}

@Composable
private fun AccountButton(text: String, image: Int, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = text,
            modifier = modifier.size(24.dp)
        )
        Spacer(modifier = modifier.width(16.dp))
        Text(text = text, fontSize = 16.sp, color = Color.Black)
    }
}

@Composable
private fun LogOutButton(modifier: Modifier = Modifier) {
    val lightGrayColor = 0xFFEFEFEF
    val greenColor = 0xFF68A47B

    Button(
        onClick = { /*TODO*/ },
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        colors = ButtonColors(
            containerColor = Color(lightGrayColor),
            contentColor = Color(greenColor),
            disabledContainerColor = Color(0xFFB0B0B0),
            disabledContentColor = Color(0xFF808080)
        ),
        shape = ButtonDefaults.outlinedShape
    ) {
        Image(
            painter = painterResource(id = R.drawable.logout_icon),
            contentDescription = "Log out",
            contentScale = ContentScale.Crop,
            modifier = modifier.size(19.dp)
        )
        Spacer(modifier = modifier.width(16.dp))
        Text(
            text = "Log Out",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(greenColor)
        )
    }
}