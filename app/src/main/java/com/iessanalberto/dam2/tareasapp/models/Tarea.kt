package com.iessanalberto.dam2.tareasapp.models

data class Tarea(
    val nombre : String,
    val responsable : String,
    val descripcion : String,
    val estado : String = "Pendiente"
)
