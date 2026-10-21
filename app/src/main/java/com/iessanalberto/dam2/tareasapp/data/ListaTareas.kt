package com.iessanalberto.dam2.tareasapp.data

import com.iessanalberto.dam2.tareasapp.models.Tarea

/*
// List son una lista de cosas que no van a cambiar, por ejemplo los dias de la semana, que no se agregan ni se borran
val diasSemana : List<String> = listOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")

// MutableList son aquellas listas que sus datos pueden ser modificados, añadidos, eliminar etc.
val nombresLista : MutableList<String> = mutableListOf("Luis", "Ana", "Pedro", "Maria", "Juan")

/*
 Ejemplos de que podemos hacer con las MutableList
 nombresLista.add("Rodolfo")
 nombresLista.remove("Luis")
 * */
 */

val listaTareas: MutableList<Tarea> = mutableListOf(
    Tarea(
        nombre = "Lavar el coche",
        responsable = "Javi",
        descripcion = "Lavar el coche en el lavadero nuevo del Bon Area"
        // Puedo cambiar el estado de la tarea, pero no es necesario porque es "Pendiente" por defecto
    ),
    Tarea(
        nombre = "Lavar bici",
        responsable = "Daniel",
        descripcion = "Lavar bici con agua y jabon"
    ),
    Tarea(
        nombre = "Comprar fruta y verdura",
        responsable = "Elena",
        descripcion = "Comprar manzanas, plátanos y espinacas en la frutería del barrio"
    ),
    Tarea(
        nombre = "Sacar a la perra",
        responsable = "Carlos",
        descripcion = "Paseo de la tarde por el parque grande"
    ),
    Tarea(
        nombre = "Limpiar los cristales",
        responsable = "Marta",
        descripcion = "Limpiar los cristales del salón y del balcón"
    ),
    Tarea(
        nombre = "Hacer la revisión del gas",
        responsable = "Javi",
        descripcion = "Estar en casa de 10:00 a 12:00 para la visita del técnico"
    ),
    Tarea(
        nombre = "Organizar el trastero",
        responsable = "Daniel",
        descripcion = "Mover las cajas de invierno y tirar lo que no sirva"
    ),
    Tarea(
        nombre = "Regar las plantas",
        responsable = "Elena",
        descripcion = "Regar las macetas de la terraza y poner abono a los orquídeas"
    ),
    Tarea(
        nombre = "Cambiar bombilla del pasillo",
        responsable = "Carlos",
        descripcion = "Comprar bombilla LED de luz cálida y cambiar la fundida"
    ),
    Tarea(
        nombre = "Planchar la ropa",
        responsable = "Marta",
        descripcion = "Planchar las camisas del trabajo para la semana"
    ),
    Tarea(
        nombre = "Llevar ropa al contenedor",
        responsable = "Javi",
        descripcion = "Bajar las bolsas con ropa usada al punto limpio"
    ),
    Tarea(
        nombre = "Hacer la compra semanal",
        responsable = "Daniel",
        descripcion = "Ir al supermercado con la lista compartida"
    )
)
fun buscarTarea(id: Int) : Tarea?{
    var task : Tarea? = null
    for (tarea in listaTareas){
        if (tarea.id == id){
            task = tarea
        }
    }
    return task
}