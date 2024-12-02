package com.example.din_login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


// las cosas de abajo, todos los permisos y esas cosas
@Composable
fun Footer(modifier: Modifier) {

    val estiloTexto = TextStyle(
        color = Color.White,
        fontSize = 14.sp,
        textAlign = TextAlign.Center
    )

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Términos de Uso",
            style = estiloTexto
        )
        Text(
            text = "Política de Privacidad",
            style = estiloTexto
        )
        Text(
            text = "Consentimiento de cookies",
            style = estiloTexto
        )

        HorizontalDivider(modifier = Modifier.padding(20.dp))

        Text(
            text = "SONY PICTURES",
            style = estiloTexto,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "© Crunchyroll, LLC",
            style = estiloTexto
        )

        Text(
            text = "▼ ESPAÑOL",
            style = estiloTexto,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}