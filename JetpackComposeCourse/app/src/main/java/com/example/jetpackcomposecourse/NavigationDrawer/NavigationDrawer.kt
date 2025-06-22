package com.example.jetpackcomposecourse.NavigationDrawer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true, showSystemUi = true)
fun NavigationDrawerSample(){
    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer (
      drawerContent = {
          ModalDrawerSheet (

          ) {
              Column(
                  modifier = Modifier
                      .fillMaxSize()
                      .padding(16.dp)
                      .verticalScroll(rememberScrollState()),
                  horizontalAlignment = Alignment.CenterHorizontally
              ) {

                  repeat(10) {
                      Text(
                          text = "Item $it",
                          modifier = Modifier.padding(16.dp)
                      )
                      HorizontalDivider()
                      NavigationDrawerItem(
                          label = {
                              Text(text = "Item 1")
                          },
                          selected = false,
                          onClick = {


                          }
                      )
                      NavigationDrawerItem(
                          label = {
                              Text(text = "Item 2")
                          },
                          selected = false,
                          onClick = {

                          }
                      )
                  }
              }


          }
      },
        drawerState = drawerState
    ){

        Scaffold (
            topBar = {
                TopAppBar(
                    title = {Text(text = "Navigation Drawer")},
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    if (drawerState.isClosed){
                                        drawerState.open()
                                    }else{
                                        drawerState.close()
                                    }
                                }
                            },

                        ){
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu"
                            )
                        }
                    }
                )
            }
        ){innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally
                ) {
                Text(text = "Main Screen")
            }
        }
    }


}