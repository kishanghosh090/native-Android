package com.vedabits.composemusicapp


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountDialog(dialogOpen: MutableState<Boolean>) {

    if(dialogOpen.value){


            AlertDialog(
                onDismissRequest = { dialogOpen.value = false },
                confirmButton = {
                    TextButton(onClick = { dialogOpen.value = false }) {
                        Text("Confirm")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { dialogOpen.value = false }) {
                        Text("Dismiss")
                    }
                },
                title = {
                    Text("Title")
                },
                text = {
                    Column(
                        modifier = Modifier.wrapContentHeight().padding(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        TextField(
                            value = "Email",
                            onValueChange = {},
                            label = { Text("Label") }
                        )
                        TextField(
                            value = "Password",
                            onValueChange = {},
                            label = { Text("Label") }
                        )
                        Spacer(
                            modifier = Modifier.padding(10.dp)
                        )



                    }
                }
            )

    }
}