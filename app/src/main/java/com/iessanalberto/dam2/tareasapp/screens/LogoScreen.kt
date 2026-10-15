package com.iessanalberto.dam2.tareasapp.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.iessanalberto.dam2.tareasapp.R
import com.iessanalberto.dam2.tareasapp.navigation.AppScreens


@Composable
fun LogoScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        // Logo de la app las imagenes deber ir a la carpeta drawable
        Image(
            painter = painterResource(R.drawable.logo_app),
            contentDescription = "logo"
        )
        // Boton para ir a la pantalla de tareas
        Button(onClick = { navController.navigate(route = AppScreens.Tareas.route) }) {
            Text(text = "Tareas")
        }
    }

}