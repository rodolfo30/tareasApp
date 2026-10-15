package com.iessanalberto.dam2.tareasapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.iessanalberto.dam2.tareasapp.components.MiPropiaCard
import com.iessanalberto.dam2.tareasapp.data.listaTareas
import com.iessanalberto.dam2.tareasapp.navigation.AppScreens

@Composable
fun TareasScreen(navController: NavController) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {navController.navigate(AppScreens.NewTarea.route)}) {
                Icon(imageVector = Icons.Filled.AddCircle,contentDescription = "Add tarea")
            }
        }
    ) { paddingValues ->
        TareasScreenBodyContent(modifier = Modifier.padding(paddingValues = paddingValues))
    }
}

@Composable
fun TareasScreenBodyContent(modifier: Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(listaTareas) { tarea ->
           MiPropiaCard(tarea = tarea)
        }
    }
}
