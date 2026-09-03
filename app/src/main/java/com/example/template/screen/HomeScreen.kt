package com.example.template.screen

import android.graphics.drawable.PaintDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.template.R
import com.example.template.ui.theme.AndroidTemplateTheme
import com.example.template.ui.theme.GryffindorRed
import com.example.template.ui.theme.HufflepuffYellow
import com.example.template.ui.theme.RavenclawBlue
import com.example.template.ui.theme.SlytherinGreen


enum class Casa(val casa: String) {
    GRIFINORIA("Grifinória"),
    SONSERINA("Sonserina"),
    LUFALUFA("Lufa Lufa"),
    CORVINAL("Corvinal");

    override fun toString(): String = casa
}


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = "Hogwartz Quiz"
                )
                Text(
                    text = "0/5"
                )
            }
            Spacer(modifier = Modifier.height(60.dp))
            Image(
                painter = painterResource(R.drawable.image),
                contentDescription = "imagem de personagem"
            )
            Spacer(modifier = Modifier.height(80.dp))
            Text(
                text = "Harry potter",
                fontSize = 32.sp

            )
            Text(
                text = "Escolha sua casa"
            )
            Spacer(modifier = Modifier.height(60.dp))
            for (value in Casa.entries) {
                CasaBotao(value)
            }
        }
    }
}

@Composable
fun CasaBotao(casa: Casa) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = when(casa) {
                Casa.GRIFINORIA -> GryffindorRed
                Casa.SONSERINA -> SlytherinGreen
                Casa.LUFALUFA -> HufflepuffYellow
                Casa.CORVINAL -> RavenclawBlue
            }
        ),
        onClick = {}
    ) {
        Text(casa.toString())
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    AndroidTemplateTheme {
        HomeScreen()
    }
}
