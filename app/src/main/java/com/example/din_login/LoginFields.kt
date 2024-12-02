package com.example.din_login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.din_login.ui.theme.colorNarangita

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CampoUsuario(
    text:String,
    onValueChange: (String)->Unit
){
    TextField(
        value = text,
        onValueChange = {onValueChange(it)},
        label = { Text("Direccion de email") },
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White,
            focusedBorderColor = colorNarangita,
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
    text:String,
    onValueChange: (String)->Unit
){

    var isPasswordVisible by remember { mutableStateOf(false) }


//    var painter = if(isPasswordVisible) painterResource(R.drawable.can_see) else painterResource(R.drawable.cant_see)
//    var canSeeImage = @Composable{ Image(
//            painter = painterResource(R.drawable.cant_see),
//            contentDescription = "foto de perfil",
//            modifier = Modifier
//                .padding(start = 10.dp, end = 10.dp)
//                .size(50.dp)
//                .clip(CircleShape)
//                .clickable { isPasswordVisible = !isPasswordVisible },
//            contentScale = ContentScale.Crop
//        )
//    }

    val canSeeIcon = @Composable {
        IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
            Icon(
                if (isPasswordVisible) Icons.Default.KeyboardArrowLeft else Icons.Default.KeyboardArrowRight,
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
            focusedBorderColor = colorNarangita,
            unfocusedBorderColor = Color.White,
            cursorColor = Color.White,
            focusedLabelColor = Color.White,
            unfocusedLabelColor = Color.White
        ),
        modifier = Modifier.fillMaxWidth().padding(top = 16.dp, start = 16.dp, end = 16.dp),
        trailingIcon = canSeeIcon,
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()

    )
}
