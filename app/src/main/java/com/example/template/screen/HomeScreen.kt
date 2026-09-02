package com.example.template.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.template.R
import com.example.template.ui.theme.AndroidTemplateTheme

/**
 * Única tela do template. Comece a construir seu app a partir daqui.
 */
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
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.image),
                contentDescription = null,
                modifier = Modifier
                    .size(180.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Text("Tudo pronto 🎉", style = MaterialTheme.typography.headlineSmall)
            Text(
                "Edite screen/HomeScreen.kt para começar.",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    AndroidTemplateTheme {
        HomeScreen()
    }
}
