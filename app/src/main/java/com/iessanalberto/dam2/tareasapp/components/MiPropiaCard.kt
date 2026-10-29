package com.iessanalberto.dam2.tareasapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iessanalberto.dam2.tareasapp.R
import com.iessanalberto.dam2.tareasapp.models.Tarea

@Composable
fun MiPropiaCard(
    tarea: Tarea,
    modifier: Modifier = Modifier,
    // Lo de abajo es para cuando pinchen en las tarjetas, que haga algo
    onClick: () -> Unit
) {
    ElevatedCard(
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.cardContainer)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        // Esto hay que ponerlo para cuando pinchen en las tarjetas
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Fila superior: Título + Badge de estado
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = tarea.nombre,
                    color = colorResource(R.color.card_title),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )

                EstadoBadge(estado = tarea.estado)
            }

            // Descripción de la tarea
            if (tarea.descripcion.isNotBlank()) {
                Text(
                    text = tarea.descripcion,
                    color = colorResource(R.color.card_description),
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(modifier = Modifier.height(2.dp))

            // Pie de la tarjeta: Icono + Responsable
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Rounded.Person,
                    contentDescription = "Responsable",
                    tint = colorResource(R.color.card_accent),
                    modifier = Modifier.padding(end = 6.dp)
                )
                Text(
                    text = tarea.responsable,
                    color = colorResource(R.color.card_accent),
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
private fun EstadoBadge(estado: Tarea.Estado) {
    val (bgColor, textColor) = when (estado) {
        Tarea.Estado.PENDIENTE -> Pair(Color(0xFFD32F2F), Color.White)   // Rojo
        Tarea.Estado.EN_PROGRESO -> Pair(Color(0xFFFBC02D), Color(0xFF1A1A1A)) // Amarillo
        Tarea.Estado.COMPLETADO -> Pair(Color(0xFF388E3C), Color.White)  // Verde
    }

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(bgColor)
            .padding(horizontal = 10.dp, vertical = 4.dp)
    ) {
        Text(
            text = estado.etiqueta,
            color = textColor,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Bold
        )
    }
}
