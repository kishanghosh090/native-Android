package com.example.taskmanager.ui.tasklist

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.taskmanager.ui.addtask.AddTaskDialog

@Composable
//@Preview(showBackground = true, showSystemUi = true)
fun TaskListScreen(innerPadding: PaddingValues) {
    var isDialogOpen by remember { mutableStateOf(false) }
    TaskHeader(onClickListener = {
        isDialogOpen = !isDialogOpen
    },
        innerPadding = innerPadding
        )
   if (isDialogOpen){
       AddTaskDialog(

           onDismiss = {
               isDialogOpen = !isDialogOpen
           },
           onTaskAdded = {}
       )
   }
}