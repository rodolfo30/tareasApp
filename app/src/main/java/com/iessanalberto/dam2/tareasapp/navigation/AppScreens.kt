package com.iessanalberto.dam2.tareasapp.navigation

sealed class AppScreens(val route: String) {
    // Definimos las pantallas de la app
    object Logo : AppScreens(route = "first_screen")
    object Tareas : AppScreens(route = "tareas_screen")
    object NewTarea: AppScreens(route = "new_tarea_screen")
    object EditDeleteTaskScreens: AppScreens(route = "edit_delete_task_screen")
}