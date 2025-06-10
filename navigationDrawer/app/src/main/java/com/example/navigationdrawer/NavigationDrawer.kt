package com.example.navigationdrawer

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet

import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import  androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

data class screens(
    val title: String,
    val item: ImageVector
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawer(){


    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val seltedItem = remember { mutableStateOf("Home") }

    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)


    val drawerItems = listOf(
        screens("Home", Icons.Default.Home),
        screens("Settings", Icons.Default.Settings),
        screens("Profile", Icons.Default.Person)
    )

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet (
                modifier = Modifier.width(400.dp).fillMaxHeight()
            ){
                Column (
                    modifier = Modifier.padding(16.dp).fillMaxSize()
                ) {
                    Text(
                        text = "Main Menu",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    drawerItems.forEach { item ->
                        NavigationDrawerItem(
                            icon = {
                                Icon(
                                    imageVector = item.item,
                                    contentDescription = item.title
                                )
                            },
                            label = { Text(text = item.title) },
                            selected = item.title == seltedItem.value,
                            onClick = {
                                scope.launch {
                                    drawerState.close()
                                }
                                seltedItem.value = item.title
                            },
                            modifier = Modifier.padding(vertical = 16.dp),
                        )
                    }
                }

            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {Text(text = seltedItem.value)},
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    drawerState.open()
                                }
                            }
                        ) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                )
            }
        ){innterPadding ->
            Column (
                modifier = Modifier.padding(innterPadding)
                    .fillMaxSize()
            ){
                when(seltedItem.value){
                    "Home" -> HomeScreen(modifier = Modifier.padding(innterPadding), onOpenBottomSheet = {showBottomSheet=true})
                    "Profile" -> ProfileScreeen(modifier = Modifier.padding(innterPadding))
                    "Settings" -> SettingsScreen(modifier = Modifier.padding(innterPadding))
                }
                if (showBottomSheet){
                    ModalBottomSheet(
                        onDismissRequest = { showBottomSheet = false },
                        sheetState = sheetState

                    ) {
                        BottomSheet(onCLose = { showBottomSheet = false })
                    }
                }
            }

        }
    }
}


@Composable
fun HomeScreen(modifier: Modifier,onOpenBottomSheet: () -> Unit){
    Column {
        Text(text = "Home Screen")
        Button(
            onClick = {
                onOpenBottomSheet()
            }
        ) {
            Text(text = "Open Bottom Sheet")
        }
    }
}

@Composable
fun ProfileScreeen(modifier: Modifier){
    Text(text = "profile Screen")
}
@Composable
fun SettingsScreen(modifier: Modifier){
    Text(text = "settrings Screen")
}


@Composable
fun BottomSheet(onCLose: () -> Unit){

    Column(
        modifier = Modifier.padding(16.dp).fillMaxWidth().height(400.dp)
    ) {
        Text(text = "Bottom Sheet content")
        Spacer(modifier = Modifier.height(16.dp))
        Button (onClick = onCLose) {
            Text(text = "Close Bottom Sheet")
        }
    }

}