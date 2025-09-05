package com.example.jetpackcomposecourse.Menus

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun DropDownMenuSample(){
    var expended by remember { mutableStateOf(false) }

    Box (
        modifier = Modifier.fillMaxWidth().padding(18.dp),
        contentAlignment = Alignment.TopEnd
    ){
        IconButton(
            onClick = {
                expended = !expended
            }
        ) {
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = "Menu"
            )
        }
        DropdownMenu(
            expanded = expended,
            onDismissRequest = { expended = false },
            border = BorderStroke(1.dp, color = androidx.compose.ui.graphics.Color.Black),
//            modifier = Modifier.fillMaxWidth().padding(18.dp),
            offset = androidx.compose.ui.unit.DpOffset(0.dp, 0.dp),


        ) {
            DropdownMenuItem(
                text = { Text("Item 1") },
                onClick = { /* Handle Item 1 click */ },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = null
                    )
                },


            )
            HorizontalDivider(modifier = Modifier.height(1.dp))
            DropdownMenuItem(
                text = { Text("Item 2") },
                onClick = { /* Handle Item 2 click */ },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = null
                    )
                }
            )
        }
    }
}