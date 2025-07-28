package com.vedabits.musicappcompose.ui.theme

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(){

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer (
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet (
                modifier = Modifier.fillMaxWidth()
            ){
                Text("Drawer title", modifier = Modifier.padding(16.dp))
                repeat(5) {
                    Text("Item $it", modifier = Modifier.padding(16.dp))
                }
            }
        },
        modifier = Modifier.fillMaxSize(),
        scrimColor = androidx.compose.material3.MaterialTheme.colorScheme.surfaceVariant,


    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Show drawer") },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    drawerState.apply {
                                        if (isClosed) open() else close()
                                    }
                                }
                            }
                        ) {
                            Icon(Icons.Filled.AccountCircle, contentDescription = "")
                        }
                    }
                )
            }
        ) { contentPadding ->
            // Screen content
            Text(
                modifier = Modifier.padding(contentPadding),
                text = "Content of the screen"
            )
        }
    }
}