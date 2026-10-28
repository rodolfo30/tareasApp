package com.iessanalberto.dam2.tareasapp.models

data class Tarea(
    var nombre: String,
    var responsable: String,
    var descripcion: String,
    var estado: Estado = Estado.PENDIENTE
) {
    companion object {
        var contador = 0
        fun siguienteID(): Int = ++contador

        /* Se puede hacer de las dos maneras, pero la primera es mas corta y eficiente
        fun siguienteID() : Int {
            return contador++
        }
         */
    }
    // Se puede poner en el constructor si quieres tener el id ahi o puedes hacerlo fuera y asi no lo tienes en el constructor, pero sigues teniendo el ID
    val id: Int = siguienteID()


    enum class Estado(val etiqueta: String){
        PENDIENTE("Pendiente"),
        EN_PROGRESO("En progreso"),
        COMPLETADO("Completada")
    }
}