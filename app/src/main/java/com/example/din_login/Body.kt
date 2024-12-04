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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.din_login.ui.theme.colorGrisOscuro
import com.example.din_login.ui.theme.colorNarangita

// cuerpo del programa
@Composable
fun Body(
    modifier: Modifier,
    canLogIn:Boolean,
    userText:String,
    onChangeUser:(String) -> Unit,
    passText:String,
    onPassChange:(String) -> Unit,
    onPressButton:()-> Unit
){


    var checkedChecbox by remember { mutableStateOf(false) }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        // texto de la parte de arriba que pone acceder
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

        // campos del login y los textos que hay abajo
        Column(
            modifier = Modifier
                .padding(top = 25.dp, start = 16.dp, end = 16.dp, bottom = 10.dp)
                .background(colorGrisOscuro),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            CampoUsuario(userText){
                onChangeUser(it)
            }
            CampoContrasena(passText){
                onPassChange(it)
            }


            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            ){


                Checkbox(checkedChecbox, onCheckedChange = {checkedChecbox = !checkedChecbox}, modifier = Modifier
                    .scale(0.5f)
                    .size(22.dp))


                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        //      .padding(top = 3.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
                        .weight(1f),
                    text = "RECORDARME",
                    color = Color.Gray,
                    fontSize = 2.em,
                    textAlign = TextAlign.Start
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        //.padding(top = 3.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
                        .clickable { }
                        .weight(1.5f),
                    text = "¿OLVIDASTE TU CONTRASEÑA?",
                    color = Color.Gray,
                    fontWeight = FontWeight.Bold,
                    fontSize = 2.em,
                    textAlign = TextAlign.End
                )
            }


        }

        // se explica solo
        LogInButton(canLogIn) { onPressButton() }


        // boton de iniciar sesion con google
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = {  },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                modifier = Modifier
                    .padding(16.dp)
                    .height(48.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.google_logo),
                    contentDescription = "Google logo",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Iniciar sesión con Google", color = Color.Black)
            }
        }


        // los textos de no tienes cuenta
        Row {
            Text(
                text = "¿No tienes cuenta?",
                fontSize = 16.sp,
                color = Color.White
            )
            Text(
                text = " CREAR UNA",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = colorNarangita,
                modifier = Modifier.clickable { }
            )
        }
    }
}


// funcion del boton del login
@Composable
fun LogInButton(canLogIn:Boolean,onPressButton:()->Unit){
    val colorBoton = if (canLogIn) colorNarangita else Color.Black
    val colorBordeBoton = if (canLogIn) colorNarangita else Color(0xFF3D3D3D)
    val colorTextBoton = if (canLogIn) Color.White else Color(0xFF3D3D3D)

    Button(
        onClick = { onPressButton() },
        shape = RoundedCornerShape(0.dp),
        enabled = canLogIn,
        colors = ButtonDefaults.buttonColors(
            containerColor = colorBoton,
            disabledContainerColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 16.dp, end = 16.dp, bottom = 25.dp)
            .border(BorderStroke(3.dp, colorBordeBoton))

    ) {
        Text(
            modifier = Modifier.padding(10.dp),
            text = "ACCEDER",
            color = colorTextBoton
        )
    }
}