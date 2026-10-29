package com.iessanalberto.dam2.tareasapp.screens

import android.R.attr.text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.iessanalberto.dam2.tareasapp.components.MiPropiaCard
import com.iessanalberto.dam2.tareasapp.data.listaTareas
import com.iessanalberto.dam2.tareasapp.models.Tarea.Estado
import com.iessanalberto.dam2.tareasapp.navigation.AppScreens

@Composable
fun TareasScreen(navController: NavController) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(AppScreens.NewTarea.route) }) {
                Icon(imageVector = Icons.Filled.AddCircle, contentDescription = "Add tarea")
            }
        }
    ) { paddingValues ->
        // Forma para hacer un navegador con argumentos
        TareasScreenBodyContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            navController = navController
        )
    }
}

@Composable
fun TareasScreenBodyContent(modifier: Modifier, navController: NavController) {
    var isPendienteChecked by remember { mutableStateOf(true) }
    var isEnProgesoChecked by remember { mutableStateOf(true) }
    var isCompletadaChecked by remember { mutableStateOf(true) }
    var listaFiltrada = listaTareas.filter {
        it.estado == Estado.PENDIENTE && isPendienteChecked ||
                it.estado == Estado.EN_PROGRESO && isEnProgesoChecked ||
                it.estado == Estado.COMPLETADO && isCompletadaChecked
    }
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isPendienteChecked,
                onCheckedChange = { isPendienteChecked = it }
            )
            Text(text = Estado.PENDIENTE.etiqueta)
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isEnProgesoChecked,
                onCheckedChange = { isEnProgesoChecked = it }
            )
            Text(text = Estado.EN_PROGRESO.etiqueta)
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isCompletadaChecked,
                onCheckedChange = { isCompletadaChecked = it }
            )
            Text(text = Estado.COMPLETADO.etiqueta)
        }
        if (listaFiltrada.isEmpty()){
            Spacer(modifier = Modifier.height(40.dp))
            Text(text = "No hay nada que filtrar",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp)
        }else{
            LazyColumn(
                modifier = modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(listaTareas) { tarea ->
                    MiPropiaCard(tarea = tarea, onClick = {
                        // Asi se hace para que navegue con argumentos
                        navController.navigate(route = AppScreens.EditDeleteTaskScreens.route + "/${tarea.id}")
                    })
                }
            }
        }


    }

}
