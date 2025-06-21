package com.example.jetpackcomposecourse.AlartDilogBox


import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import  androidx.compose.ui.window.Dialog
import androidx.compose.ui.zIndex

@Composable
fun CustomBeautifulDialog() {
    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }
    Button(
        onClick = {
            showDialog = true
        },
        modifier = Modifier.padding(76.dp).zIndex(1f)
    ) {
        Text(text = "Show Dialog")
    }
    if (showDialog) {
        Dialog(onDismissRequest = {
            showDialog = false
        }) {

                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .wrapContentHeight()
                        .background(Color.White, shape = RoundedCornerShape(16.dp))
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Custom Dialog Title",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color(0xFF222222)
                    )

                    Text(
                        text = "This is a custom dialog created with the Dialog component.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFF555555),
                        textAlign = TextAlign.Center
                    )

                    Row(
                        horizontalArrangement = Arrangement.Center,

                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button (
                            onClick = {
                                showDialog = false
                            },
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.padding(8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Gray,
                                contentColor = Color.White
                            ),

                        ) {
                            Text("cancel")
                        }
                        Button (
                            onClick = {
                                showDialog = false
                                Toast.makeText(context, "Account Deleted Successfully", Toast.LENGTH_SHORT).show()
                            },
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.padding(8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Red,
                                contentColor = Color.White
                            ),

                        ) {
                            Text("confirm")
                        }
                    }
                }
            }

    }
}
