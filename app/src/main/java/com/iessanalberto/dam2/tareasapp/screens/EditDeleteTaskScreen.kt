package com.iessanalberto.dam2.tareasapp.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon


import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.iessanalberto.dam2.tareasapp.data.buscarTarea
import com.iessanalberto.dam2.tareasapp.data.listaTareas
import com.iessanalberto.dam2.tareasapp.models.Tarea
import com.iessanalberto.dam2.tareasapp.models.Tarea.Estado


@Composable
fun EditDeleteTaskScreen(navController: NavController, id: Int) {
    val context = LocalContext.current
    val tarea = buscarTarea(id = id)
    if (tarea == null) {
        Toast.makeText(context, "Tarea no encontrada", Toast.LENGTH_LONG).show()
        navController.popBackStack()
    }
    var showDialog by remember { mutableStateOf(false) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
                actions = {},
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = {
                            showDialog = true
                        },
                        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                    ) {
                        Icon(Icons.Filled.Delete, contentDescription = "Borrar tarea")
                    }
                }
            )
        }
    ) { innerPadding ->
        EditDeleteBodyContent(
            modifier = Modifier.padding(innerPadding),
            navController = navController, tarea = tarea!!,
            context = context
        )
    }
    if (showDialog){
        AlertDialog(
            icon = {Icon(imageVector = Icons.Filled.Delete, contentDescription = "Confirmar borrado")},
            title = { Text(text = "Confirmar borrado") },
            text = { Text(text = "Estas seguro que quieres borrar la tarea ${tarea!!.nombre}?") },
            onDismissRequest = {
                showDialog = false
            },
            confirmButton = {
                TextButton(onClick = {
                    listaTareas.remove(tarea)
                    Toast.makeText(context, "Tarea eliminada", Toast.LENGTH_LONG).show()
                    navController.popBackStack()
                }) {
                    Text(text = "Borrar")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    showDialog = false
                }) {
                    Text(text = "Cancelar")
                }
            }
        )
    }
}

@Composable
fun EditDeleteBodyContent(
    navController: NavController,
    tarea: Tarea,
    modifier: Modifier,
    context: Context
) {

    // utilizo el !! para decir que no es nulo asegurandesolo
    var nombre by remember { mutableStateOf(tarea.nombre) }
    var responsable by remember { mutableStateOf(tarea.responsable) }
    var descripcion by remember { mutableStateOf(tarea.descripcion) }
    var estado by remember { mutableStateOf(tarea.estado) }
    var estadoSeleccionado by remember { mutableStateOf(tarea.estado) }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") }
        )
        OutlinedTextField(
            value = responsable,
            onValueChange = { responsable = it },
            label = { Text("Responsable") }
        )
        OutlinedTextField(
            value = descripcion,
            onValueChange = { descripcion = it },
            label = { Text("Descripción") }
        )
        /*(
            value = estado,
            onValueChange = { estado = it },
            label = { Text("Estado") }
        )
         */
        Estado.entries.forEach { estado ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .selectable
                        (
                        selected = (estado == estadoSeleccionado),
                        onClick = { estadoSeleccionado = estado },
                        role = Role.RadioButton
                    )
                    .padding(vertical = 8.dp), verticalAlignment = CenterVertically

            ) {
                RadioButton(
                    selected = (estado == estadoSeleccionado),
                    onClick = null
                )
                Text(text = estado.etiqueta, modifier = Modifier.padding(start = 16.dp))
            }
        }
        Button(onClick = {
            tarea.nombre = nombre
            tarea.responsable = responsable
            tarea.descripcion = descripcion
            tarea.estado = estadoSeleccionado
            Toast.makeText(context, "Tarea guardada", Toast.LENGTH_SHORT).show()
            navController.popBackStack()
        }) {
            Text(text = "Guardar")
        }
    }

}
