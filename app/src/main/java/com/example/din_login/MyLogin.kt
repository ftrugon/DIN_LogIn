package com.example.din_login

import android.widget.EditText
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em

//@Preview
@Composable
fun MyLogin(
    modifier:Modifier
    //viewModel
){

    val colorGrisOscuro by remember { mutableStateOf(Color(0xFF18181C)) }
    val colorNarangita by remember { mutableStateOf(Color(0xFFE88700)) }
    var user by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }

    Column(modifier = modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorGrisOscuro)
                .weight(1f),
            contentAlignment = Alignment.Center) {

            Image(
                painter = painterResource(R.drawable.crunchy_icon),
                contentDescription = "foto de perfil",
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
                    .size(200.dp)
            )

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .weight(10f)
        ) {
            Box(
                modifier = Modifier
                .fillMaxWidth(),
                contentAlignment = Alignment.TopCenter
            ){
                Text(
                    color = Color.White,
                    text = "Acceder",
                    fontSize = 5.em)
            }

            Column(
                modifier = Modifier
                    //.fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 50.dp)
                    .background(Color(0xFF18181C)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                CampoUsuario(colorNarangita,user){
                    user = it
                }
                CampoContrasena(colorNarangita,pass){
                    pass = it
                }

            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CampoUsuario(
    colorDeLinea:Color,
    text:String,
    onValueChange: (String)->Unit
){
    TextField(
        value = text,
        onValueChange = {onValueChange(it)},
        label = { Text("Usuario") },
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White,
            focusedBorderColor = colorDeLinea,
            unfocusedBorderColor = Color.White,
            cursorColor = Color.White,
            focusedLabelColor = Color.White,
            unfocusedLabelColor = Color.White
        ),
        modifier = Modifier.fillMaxWidth().padding(16.dp)
    )
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CampoContrasena(
    colorDeLinea:Color,
    text:String,
    onValueChange: (String)->Unit
){

    var isPasswordVisible by remember { mutableStateOf(false) }
    val trailingIcon = @Composable {
        IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
            Icon(
                if (isPasswordVisible) Icons.Default.AccountCircle else Icons.Default.Call,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }

    TextField(
        value = text,
        onValueChange = {onValueChange(it)},
        label = { Text("Contraseña") },
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White,
            focusedBorderColor = colorDeLinea,
            unfocusedBorderColor = Color.White,
            cursorColor = Color.White,
            focusedLabelColor = Color.White,
            unfocusedLabelColor = Color.White
        ),
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        trailingIcon = trailingIcon,
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()

    )
}

