package com.udemy.shoppinglist

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp



data class ShoppingItem(
    val id:Int,
    val name:String,
    var quantity:Int,
    var isEditing:Boolean = false
)

@Composable
fun ShoppingListApp(
    innerPadding: PaddingValues
){
    // State variables for the shopping list----
    var sItems by remember { mutableStateOf(
        listOf<ShoppingItem>()
    ) }
    var showDialog by remember { mutableStateOf(false) }

    var itemName by remember { mutableStateOf("") }
    var itemQuantity by remember { mutableStateOf("1") }

    Column(
        modifier = Modifier.fillMaxSize().padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        FloatingActionButton (
            onClick = {
                showDialog = true
            },
            modifier = Modifier.padding(10.dp),
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            shape = MaterialTheme.shapes.medium,
            elevation = FloatingActionButtonDefaults.elevation(8.dp),
            content = {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ){
            items(sItems){ item ->
                ShoppingListItem(
                    item,
                    onEdit = {
                        sItems = sItems.map {
                            if (it.id == item.id) {
                                it.copy(isEditing = true)
                            } else {
                                it.copy(isEditing = false)
                            }
                        }
                    },
                    onDelete = { id ->
                        sItems = sItems.filter { it.id != id }
                    }
                )
            }
        }
    }


    if (showDialog){
        AlertDialog(
            modifier = Modifier
                .border(
                    color = Color.Green,
                    width = 1.dp,
                    shape = AlertDialogDefaults.shape
                ),
            onDismissRequest = {
                showDialog = false
            },
            title = {
                Text(text = "Add Shopping Item")
            },
            text = {
                Column {
                    OutlinedTextField(
                        value = itemName,
                        onValueChange = {
                            itemName = it
                        },
                        label = { Text(text = "Item Name") },
                        singleLine = true,
                        modifier = Modifier.padding(vertical = 8.dp),
                        shape = RoundedCornerShape(10.dp)

                    )
                    OutlinedTextField(
                        value = itemQuantity,
                        onValueChange = {
                            itemQuantity = it
                        },
                        label = { Text(text = "Quantity") },
                        singleLine = true,
                        modifier = Modifier.padding(vertical = 8.dp),
                        shape = RoundedCornerShape(10.dp)
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        if (itemName.isNotEmpty()){
                            val item = ShoppingItem(
                                id = sItems.size + 1,
                                name = itemName,
                                quantity = itemQuantity.toIntOrNull() ?: 0
                            )
                            sItems = sItems + item
                        }
                        itemName = ""
                        itemQuantity = "1"
                        showDialog = false
                    }
                ) {
                    Text(text = "Add")
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        showDialog = false
                    }
                ) {
                    Text(text = "Cancel")
                }
            },

        )
    }



}

@Composable
fun ShoppingListItem(
    item: ShoppingItem,
    onEdit: () -> Unit,
    onDelete: (id: Int) -> Unit
){

    var randomColorNumber = (0..4).random()
    var randomColor = Color.Red
    when(randomColorNumber){
        0 -> randomColor = Color.Red
        1 -> randomColor = Color.Green
        2 -> randomColor = Color.Blue
        3 -> randomColor = Color.Yellow
        4 -> randomColor = Color.Magenta
    }
    Box(
        modifier = Modifier.padding(vertical = 8.dp).border(
            border = BorderStroke(2.dp, randomColor),
            shape = RoundedCornerShape(10.dp)
        ),
    ){
        Row (
            modifier = Modifier.padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){

            Text(
                text = item.name,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(1f).padding(start = 8.dp)
            )
            Text(
                text = item.quantity.toString(),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(start = 8.dp)
            )

            IconButton (onClick = onEdit) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = null)
            }
            IconButton (onClick = { onDelete(item.id) }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = null)
            }



        }
    }
}