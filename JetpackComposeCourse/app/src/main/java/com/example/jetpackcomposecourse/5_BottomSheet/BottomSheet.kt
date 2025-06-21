package com.example.jetpackcomposecourse.`5_BottomSheet`

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(innerPadding: PaddingValues){
    val context = LocalContext.current
    var bottomSheet by remember {
        mutableStateOf(false)
    }

    var sheetState = rememberModalBottomSheetState (
        skipPartiallyExpanded = false,
    )

    Column (
        modifier = Modifier.fillMaxWidth().padding(innerPadding.calculateTopPadding()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Button(
            onClick = {
                bottomSheet = true
            }
        ) {
            Text(text = "Let's Go")
        }
        if (bottomSheet){
            ModalBottomSheet(
                modifier = Modifier.fillMaxHeight().padding(10.dp),
                sheetState = sheetState,
                onDismissRequest = {
                    bottomSheet = false
                }
            ) {
                LazyColumn (
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFF0F0F0)) // Light background
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(bottom = innerPadding.calculateBottomPadding(), top = innerPadding.calculateTopPadding())
                ) {
                    items(10) { index ->
                        Card (
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(190.dp),     // Fixed card height for uniformity
                            shape = RoundedCornerShape(16.dp),
                            elevation = CardDefaults.cardElevation(8.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White)
                        ) {
                            Column (
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(16.dp),
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                LazyRow (
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ){
                                    items(10) { index ->
                                        Card (
                                            modifier = Modifier
                                                .padding(7.dp),
                                            colors = CardDefaults.cardColors(containerColor = Color.Green),
                                            shape = RoundedCornerShape(10.dp)

                                        ) {
                                            Text(text = "Item $index",modifier = Modifier.padding(8.dp))
                                        }
                                    }
                                }
                                Text(
                                    text = "Card Title $index",
                                    style = MaterialTheme.typography.titleMedium,
                                    color = Color(0xFF333333)
                                )

                                Text(
                                    text = "This is a nice description for card number $index. You can modify this as needed.",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = Color(0xFF666666)
                                )

                                Button (
                                    onClick = { Toast.makeText(context, "View Clicked", Toast.LENGTH_SHORT).show() },
                                    modifier = Modifier.align(Alignment.End),
                                    shape = RoundedCornerShape(8.dp)
                                ) {
                                    Text("View")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}