package com.example.taskmanager.ui.tasklist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
//@Preview(showBackground = true, showSystemUi = true)
fun TaskHeader(onClickListener: () -> Unit, innerPadding: PaddingValues) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = innerPadding.calculateTopPadding(), start = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Task Manager",
            style = MaterialTheme.typography.headlineSmall.copy(
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = MaterialTheme.typography.headlineLarge.fontFamily
            )
        )

        FloatingActionButton(
            onClick = onClickListener,
            shape = CircleShape, // Optional shape
            containerColor = MaterialTheme.colorScheme.primary
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add",
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}