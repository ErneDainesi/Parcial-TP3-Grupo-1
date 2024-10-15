package com.example.parcial_tp3_grupo_1.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial_tp3_grupo_1.R

@Composable
fun QuantityButtons() {

    var quantityCounter by rememberSaveable {
        mutableStateOf(1)
    }
    Column {
        Row {
            IconButton(
                onClick = {
                    if (quantityCounter > 1) {
                        quantityCounter--
                    }
                }
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Decrease quantity",
                    tint = colorResource(
                        id = R.color.border_item_card_color
                    )
                )
            }
            Box(
                modifier = Modifier
                    .size(45.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)
                    .border(2.dp, Color(0xFFE2E2E2), RoundedCornerShape(16.dp))
            ) {
                Text(
                    text = quantityCounter.toString(),
                    fontSize = 20.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            IconButton(onClick = { quantityCounter++ }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = "Increase quantity",
                    tint = colorResource(
                        id = R.color.principal_button_color
                    )
                )
            }
        }
    }
}