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
    // 5 Tareas Pendientes
    Tarea(
        nombre = "Lavar el coche",
        responsable = "Javi",
        descripcion = "Lavar el coche en el lavadero nuevo del Bon Area",
        estado = Tarea.Estado.PENDIENTE
    ),
    Tarea(
        nombre = "Lavar bici",
        responsable = "Daniel",
        descripcion = "Lavar bici con agua y jabon",
        estado = Tarea.Estado.PENDIENTE
    ),
    Tarea(
        nombre = "Comprar fruta y verdura",
        responsable = "Elena",
        descripcion = "Comprar manzanas, plátanos y espinacas en la frutería del barrio",
        estado = Tarea.Estado.PENDIENTE
    ),
    Tarea(
        nombre = "Sacar a la perra",
        responsable = "Carlos",
        descripcion = "Paseo de la tarde por el parque grande",
        estado = Tarea.Estado.PENDIENTE
    ),
    Tarea(
        nombre = "Limpiar los cristales",
        responsable = "Marta",
        descripcion = "Limpiar los cristales del salón y del balcón",
        estado = Tarea.Estado.PENDIENTE
    ),

    // 10 Tareas En Progreso
    Tarea(
        nombre = "Desarrollar módulo de login",
        responsable = "Ana",
        descripcion = "Implementar pantallas de autenticación con Firebase",
        estado = Tarea.Estado.EN_PROGRESO
    ),
    Tarea(
        nombre = "Diseñar interfaz de usuario",
        responsable = "Lucía",
        descripcion = "Crear prototipos en Figma para el nuevo flujo",
        estado = Tarea.Estado.EN_PROGRESO
    ),
    Tarea(
        nombre = "Optimizar base de datos",
        responsable = "Marcos",
        descripcion = "Revisar índices y consultas lentas en SQLite",
        estado = Tarea.Estado.EN_PROGRESO
    ),
    Tarea(
        nombre = "Configurar notificaciones push",
        responsable = "Sofía",
        descripcion = "Integrar Firebase Cloud Messaging en la app",
        estado = Tarea.Estado.EN_PROGRESO
    ),
    Tarea(
        nombre = "Implementar modo oscuro",
        responsable = "David",
        descripcion = "Adaptar colores y temas en Material 3",
        estado = Tarea.Estado.EN_PROGRESO
    ),
    Tarea(
        nombre = "Actualizar dependencias",
        responsable = "Elena",
        descripcion = "Migrar a las últimas versiones de Compose y AGP",
        estado = Tarea.Estado.EN_PROGRESO
    ),
    Tarea(
        nombre = "Escribir pruebas unitarias",
        responsable = "Carlos",
        descripcion = "Añadir tests para los ViewModels y casos de uso",
        estado = Tarea.Estado.EN_PROGRESO
    ),
    Tarea(
        nombre = "Revisar pull requests",
        responsable = "Javi",
        descripcion = "Validar código del equipo antes de fusionar a main",
        estado = Tarea.Estado.EN_PROGRESO
    ),
    Tarea(
        nombre = "Configurar CI/CD",
        responsable = "Daniel",
        descripcion = "Automatizar compilación y tests con GitHub Actions",
        estado = Tarea.Estado.EN_PROGRESO
    ),
    Tarea(
        nombre = "Preparar documentación técnica",
        responsable = "Marta",
        descripcion = "Redactar guía de instalación y arquitectura",
        estado = Tarea.Estado.EN_PROGRESO
    ),

    // 10 Tareas Completadas
    Tarea(
        nombre = "Configurar repositorio Git",
        responsable = "Javi",
        descripcion = "Crear repositorio inicial y ramas de trabajo",
        estado = Tarea.Estado.COMPLETADO
    ),
    Tarea(
        nombre = "Definir arquitectura MVVM",
        responsable = "Ana",
        descripcion = "Establecer estructura de paquetes y capas",
        estado = Tarea.Estado.COMPLETADO
    ),
    Tarea(
        nombre = "Crear diseño base Material 3",
        responsable = "Lucía",
        descripcion = "Definir paleta de colores y tipografía",
        estado = Tarea.Estado.COMPLETADO
    ),
    Tarea(
        nombre = "Implementar navegación básica",
        responsable = "Carlos",
        descripcion = "Configurar NavHost y rutas con Navigation Compose",
        estado = Tarea.Estado.COMPLETADO
    ),
    Tarea(
        nombre = "Crear modelo de datos Tarea",
        responsable = "Daniel",
        descripcion = "Definir data class Tarea con ID autoincremental",
        estado = Tarea.Estado.COMPLETADO
    ),
    Tarea(
        nombre = "Implementar pantalla principal",
        responsable = "Elena",
        descripcion = "Diseñar lista de tareas y tarjetas personalizadas",
        estado = Tarea.Estado.COMPLETADO
    ),
    Tarea(
        nombre = "Añadir soporte landscape",
        responsable = "David",
        descripcion = "Adaptar layouts para tablets y pantallas grandes",
        estado = Tarea.Estado.COMPLETADO
    ),
    Tarea(
        nombre = "Configurar icono de la app",
        responsable = "Marta",
        descripcion = "Generar iconos adaptativos para todas las densidades",
        estado = Tarea.Estado.COMPLETADO
    ),
    Tarea(
        nombre = "Realizar pruebas de humo",
        responsable = "Marcos",
        descripcion = "Verificar inicio correcto de la app en emulador",
        estado = Tarea.Estado.COMPLETADO
    ),
    Tarea(
        nombre = "Revisar accesibilidad",
        responsable = "Sofía",
        descripcion = "Asegurar descripciones de contenido en imágenes",
        estado = Tarea.Estado.COMPLETADO
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