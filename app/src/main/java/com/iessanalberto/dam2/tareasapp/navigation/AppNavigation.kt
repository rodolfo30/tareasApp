package com.iessanalberto.dam2.tareasapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.iessanalberto.dam2.tareasapp.screens.EditDeleteTaskScreen
import com.iessanalberto.dam2.tareasapp.screens.LogoScreen
import com.iessanalberto.dam2.tareasapp.screens.NewTareasScreen
import com.iessanalberto.dam2.tareasapp.screens.TareasScreen

@Composable
fun AppNavigation() {
    // Creamos el controlador de navegacion
    val navController = rememberNavController()
    // Creamos el NavHost con el controlador de navegacion y la pantalla inicial
    NavHost(navController = navController, startDestination = AppScreens.Logo.route) {
        // Definimos las pantallas de la app
        composable(route = AppScreens.Logo.route) { LogoScreen(navController = navController) }
        composable(route = AppScreens.Tareas.route) { TareasScreen(navController = navController) }
        composable(route = AppScreens.NewTarea.route) { NewTareasScreen(navController = navController) }
        // Para pasar los argumentos e informacion de una ventana a otra, se hace de la siguiente manera
        composable(
            route = AppScreens.EditDeleteTaskScreens.route + "/{id}",
            arguments = listOf(navArgument(name = "id") { type = NavType.IntType })
        ) {
            backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id")?: -1
            EditDeleteTaskScreen(
                navController = navController,
                id = id)
        }
    }
}