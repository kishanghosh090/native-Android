package com.example.taskmanager.ui.addtask

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun AddTaskDialog(
    onDismiss: () -> Unit,
    onTaskAdded: (String) -> Unit
) {
    val context = LocalContext.current
    var taskText by remember { mutableStateOf("") }

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = MaterialTheme.shapes.medium,
            tonalElevation = 8.dp
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Add New Task",
                    style = MaterialTheme.typography.headlineSmall
                )

                Spacer(modifier = Modifier.height(12.dp))

                TextField(
                    value = taskText,
                    onValueChange = {
                        if (it.length <= 50) {
                            taskText = it
                        }else{
                            Toast.makeText(context, "Task name cannot exceed 50 characters", Toast.LENGTH_SHORT).show()
                        }
                    },
                    placeholder = { Text("Enter task name") },
                    textStyle = MaterialTheme.typography.bodyLarge,
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    supportingText = {
                        if (taskText.length > 50) {
                            Text("Task name cannot exceed 50 characters")
                        }
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("Cancel")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {
                            if (taskText.isNotBlank()) {
//                                onTaskAdded(taskText.trim())
                                onDismiss()
                            }
                        }
                    ) {
                        Text("Add")
                    }
                }
            }
        }
    }
}
