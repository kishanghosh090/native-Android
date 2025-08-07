package com.vedabits.composemusicapp


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(){

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val viewModel: MainViewModel = viewModel()

    val navController = rememberNavController()
    val NavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = NavBackStackEntry?.destination?.route

    val currentScreen = remember {
        viewModel.currentScreen.value
    }

    val title = remember {
        mutableStateOf(currentScreen.title)
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text(text = "Drawer content")

                listOf(
                    Screens.DrawerScreens.Account,
                    Screens.DrawerScreens.Subscription,
                    Screens.DrawerScreens.AddAccount
                ).forEach { item ->
                    DrawerItem(
                        selected = currentRoute == item.dRoute,
                        item = item,
                        onDrawerItemClicked = {
                            viewModel.setCurrentScreen(item)
                            title.value = item.dTitle
                            scope.launch { drawerState.close()
                            }

                            navController.navigate(item.dRoute)
                        }
                    )
                }


            }
        },
        modifier = Modifier.padding(1.dp).width(
            500.dp
        )
    ) {
        Scaffold(
            topBar = {
              TopAppBar(
                  title = { Text(text = title.value) },
                  navigationIcon = {
                      IconButton(onClick = { scope.launch { drawerState.open() } }) {
                          Icon(
                              imageVector = Icons.Filled.AccountCircle,
                              contentDescription = "Localized description"
                          )
                      }
                  }

              )
            }
        ) { innerPadding ->
            Navigation(
                navController = navController,
                paddingValues = innerPadding,
                viewModel = viewModel
            )
        }
    }
}

@Composable
fun DrawerItem(
    selected: Boolean,
    item: Screens.DrawerScreens,
    onDrawerItemClicked: () -> Unit,
){
    val background = if (selected) MaterialTheme.colorScheme.errorContainer else MaterialTheme.colorScheme.surface
    Row(
        modifier = Modifier
            .padding(8.dp)
            .clickable(
                onClick = { onDrawerItemClicked() }
            )
            .background(background)
            .fillMaxWidth()
            .clip(shape = androidx.compose.foundation.shape.RoundedCornerShape(4.dp))
    ) {
        Icon(
            painter = painterResource(id = item.icon),
            contentDescription = item.dTitle,
            modifier = Modifier.padding(3.dp)
        )
        Text(
            text = item.dTitle,
            modifier = Modifier.padding(3.dp)
        )
    }
}


@Composable
fun Navigation(
    navController: NavHostController,
    paddingValues: PaddingValues,
    viewModel: MainViewModel
){
    NavHost(
        navController = navController,
        startDestination = Screens.DrawerScreens.Account.dRoute,
        modifier = Modifier.padding(paddingValues)
    ) {
        composable(Screens.DrawerScreens.Account.dRoute) {

            AccountView()
        }
        composable(Screens.DrawerScreens.Subscription.dRoute) {

            Text(text = "Subscription")
        }
        composable(Screens.DrawerScreens.AddAccount.dRoute) {

            AccountDialog(
                dialogOpen = viewModel.dialogOpen
            )
        }
    }

}


