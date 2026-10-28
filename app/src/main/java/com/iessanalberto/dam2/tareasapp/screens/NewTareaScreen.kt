package com.iessanalberto.dam2.tareasapp.screens


import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import com.iessanalberto.dam2.tareasapp.data.listaTareas
import com.iessanalberto.dam2.tareasapp.models.Tarea
import com.iessanalberto.dam2.tareasapp.models.Tarea.Estado
import com.iessanalberto.dam2.tareasapp.navigation.AppScreens
import kotlinx.coroutines.selects.select

@Composable
fun NewTareasScreen(navController: NavController) {
    Scaffold() { innerPadding ->
        NewTareaBodyContent(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun NewTareaBodyContent(navController: NavController, modifier: Modifier) {
    // Declaramos las variables que vamos a usar
    var context =
        LocalContext.current // Cuando en un ToastMake lo cree, debo declarar esto para que funcione y llamar a la variable
    var nombre by remember { mutableStateOf("") }
    var responsable by remember { mutableStateOf("Pendiente de asignacion") }
    var descripcion by remember { mutableStateOf("") }
    var estadoSeleccionado by remember { mutableStateOf(Estado.PENDIENTE) }
    Column(
        // Poner bonita la ventana
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Campos para introducir los datos de la tarea
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text(text = ("Nombre de la tarea")) })
        OutlinedTextField(
            value = responsable,
            onValueChange = { responsable = it },
            label = { Text(text = ("Responsable")) })
        OutlinedTextField(
            value = descripcion,
            onValueChange = { descripcion = it },
            label = { Text(text = ("Descripcion")) })
        /*OutlinedTextField(value = estado,
            onValueChange = { estado = it },
            label = { Text(text = ("Estado")) })

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

        // Boton para guardar la tarea
        Button(onClick = {
            if (nombre.isBlank() || responsable.isBlank() || descripcion.isBlank()) {
                Toast.makeText(context, "Todos los campos son obligatorios", Toast.LENGTH_SHORT)
                    .show()
            } else {
                listaTareas.add(
                    Tarea(
                        nombre = nombre,
                        responsable = responsable,
                        descripcion = descripcion,
                        estado = Estado.PENDIENTE
                    )
                )
            }
            Toast.makeText(context, "Tarea guardada", Toast.LENGTH_SHORT).show()
            navController.navigate(AppScreens.Tareas.route)
        }) {
            Text(text = "Guardar")
        }
    }
}