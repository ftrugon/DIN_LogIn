package com.example.din_login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


// imagen de arriba con el logo de crunchyroll
@Composable
fun Header(modifier: Modifier){
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center) {

        Image(
            painter = painterResource(R.drawable.crunchy_icon),
            contentDescription = "foto de perfil",
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
                .size(200.dp)
        )

    }
}