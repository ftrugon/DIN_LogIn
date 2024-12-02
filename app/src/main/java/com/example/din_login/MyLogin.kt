package com.example.din_login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.din_login.ui.theme.PurpleGrey80
import com.example.din_login.ui.theme.colorGrisOscuro
import com.example.din_login.ui.theme.colorNarangita

//@Preview
@Composable
fun MyLogin(
    modifier:Modifier = Modifier,
    viewModel:ViewModel
){

    val canLogIn by viewModel.canLogIn
    val user by viewModel.user
    val pass by viewModel.pass

    Column(modifier = modifier.fillMaxSize()) {
        Header(
            Modifier
            .fillMaxWidth()
            .background(colorGrisOscuro)
            .weight(1.5f))

        Body(Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .weight(10f),
            canLogIn,
            user,
            {
                viewModel.changeUser(it)
                viewModel.comporbarLogin()
            },
            pass,
            {
                viewModel.changePass(it)
                viewModel.comporbarLogin()
            }
        )

        Footer(modifier = Modifier.fillMaxWidth()
            .background(color = Color.Black).weight(4f))
    }
}

