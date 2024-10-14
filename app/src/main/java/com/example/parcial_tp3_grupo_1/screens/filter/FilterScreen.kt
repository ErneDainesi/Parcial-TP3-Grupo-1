package com.example.parcial_tp3_grupo_1.screens.filter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial_tp3_grupo_1.R
import java.util.logging.Filter

@Preview
@Composable

fun FilterScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .width(413.dp)
                .height(657.dp)
                .paint(painterResource(id = R.drawable.pop_up_background))
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .width(407.dp)
                    .height(48.dp)
                    .align(Alignment.Start)
                    .padding(top = 16.dp, bottom = 10.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cross),
                    contentDescription = "cerrar pop up",
                    modifier = Modifier
                        .size(30.dp)
                        .padding(start = 9.dp, top = 9.dp)
                        .align(Alignment.CenterStart)
                )
                Text(
                    text = "Filters",
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = androidx.compose.ui.graphics.Color.Black,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            Text(
                text = "Categories",
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                color = androidx.compose.ui.graphics.Color.Black,
                modifier = Modifier
                    .padding(start = 15.dp, top = 20.dp)
                    .align(Alignment.Start)
            )
            CheckboxWithText("Eggs", 15.dp)
            CheckboxWithText("Noodles & Pasta", 15.dp)
            CheckboxWithText("Chips & Crisps", 15.dp)
            CheckboxWithText("Fast Food", 15.dp)
            Text(
                text = "Brand",
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                color = androidx.compose.ui.graphics.Color.Black,
                modifier = Modifier
                    .padding(start = 15.dp, top = 20.dp)
                    .align(Alignment.Start)
            )
            CheckboxWithText("Individual Collection", 15.dp)
            CheckboxWithText("Cocola", 15.dp)
            CheckboxWithText("Ifad", 15.dp)
            CheckboxWithText("Kazi Farmas", 15.dp)
            Button(
                onClick = { /* Acción del botón */ },
                modifier = Modifier
                    .width(345.dp)
                    .padding(top = 70.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = "Apply Filter",
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = androidx.compose.ui.graphics.Color.White
                )
            }
        }
    }
}


@Composable
fun CheckboxWithText(text: String, startPadding: Dp) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = startPadding, top = 8.dp, bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = false,
            onCheckedChange = { /* Acción del checkbox */ }
        )
        Text(
            text = text,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}