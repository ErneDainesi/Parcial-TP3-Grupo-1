package com.example.parcial_tp3_grupo_1.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRowScopeInstance.weight
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parcial_tp3_grupo_1.R

@Preview
@Composable
fun OnboardingScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                // Replace with your image id
                painterResource(id = R.drawable.onbording),
                contentScale = ContentScale.FillBounds)
    ){
        Column(
            modifier = Modifier
                .padding(20.dp)

        ) {
            Row {
                Image(
                    painter = painterResource(R.drawable.logo_blanco),
                    contentDescription = "logo_blanco"
                    )
                Text(text = "Welcome \n" + "to our store")}

            }
            Spacer(modifier = Modifier.weight(1f))
            Button(
            onClick = { /* Acción del botón */ },
            modifier = Modifier
                .width(353.dp)
                .height(67.dp)

        ) {
                Text(text = "Get Started")}
        }

}
