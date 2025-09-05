package com.example.jetpackcomposecourse.`24_BottomNavBar`

import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector


data class BottomNavItems(
    val name: String,
    val icon: ImageVector,
    val unSelectedIcon: ImageVector,
)
@Composable
fun BottomNavigationBar() {
    var selectedItem by remember { mutableIntStateOf(0) }
    val bottomNavItems = listOf(
        BottomNavItems("Home", Icons.Default.Home, Icons.Outlined.Home),
        BottomNavItems("Search", Icons.Default.Search, Icons.Outlined.Search),
        BottomNavItems("Profile", Icons.Default.Person, Icons.Outlined.Person),
        BottomNavItems("Settings", Icons.Default.Settings, Icons.Outlined.Settings)
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                bottomNavItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItem == index,
                        onClick = { selectedItem = index },
                        icon = {
                            Icon(
                                imageVector = if (selectedItem == index) item.icon else item.unSelectedIcon,
                                contentDescription = item.name
                            )
                        },
                        label = { Text(item.name) }
                    )
                }
            }
        }
    ) { innerPadding ->
        // Main content
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Selected: ${bottomNavItems[selectedItem].name}")
        }
    }
}


