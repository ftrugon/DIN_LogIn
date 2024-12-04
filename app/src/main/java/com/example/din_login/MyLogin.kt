package com.example.din_login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.din_login.ui.theme.colorGrisOscuro


// funcion principal
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
            },
            {
                viewModel.resetUserAndPass()
            }
        )

        Footer(modifier = Modifier.fillMaxWidth()
            .background(color = Color.Black).weight(4f))
    }
}

