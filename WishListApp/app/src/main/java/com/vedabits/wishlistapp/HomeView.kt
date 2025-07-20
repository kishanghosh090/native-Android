package com.vedabits.wishlistapp

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.vedabits.wishlistapp.data.Wish



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(
    viewModel: WishViewModel,
    navController: NavHostController
){
//    val context = LocalContext.current
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
//    var isScrollBarVisible = mutableStateOf(false)

    Scaffold (

        topBar = {
//           if (isScrollBarVisible.value == true){
               AppBarView(
                   title = "WishList App",
                   onBackNavClick = {},
                   scrollBehavior = scrollBehavior
               )
//           }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.AddScreen.route + "/-1")
                },
                modifier = Modifier
                    .padding(20.dp),
                containerColor = colorResource(R.color.black),
                contentColor = colorResource(R.color.white)

            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                )
            }
        }


    ){innerPadding ->

        var getAllWishes = viewModel.getAllWishes.collectAsState(initial = emptyList())
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

//            items(DummyWish.wishList) { item ->
//                WishItem(
//                    wish = item,
//                    onClick = {}
//                )
//            }

//            // get all the wishes from the database
//            items(getAllWishes.value){ it ->
//
//
//                WishItem(
//                    wish = it,
//                    onClick = {
//                        navController.navigate(
//                            Screen.AddScreen.route + "/${it.id}"
//                        )
//                    }
//                )
//            }
            items(getAllWishes.value,key = { wish-> wish.id}) { wishItem ->

                val dismissState = rememberSwipeToDismissBoxState(
                    confirmValueChange = {
                        if (it == SwipeToDismissBoxValue.EndToStart || it == SwipeToDismissBoxValue.StartToEnd) {
                            viewModel.deleteWish(wishItem.id)
//                            navController.navigate(Screen.HomeScreen.route)
                            true

                        } else false
                    },
                    positionalThreshold = { distance: Float ->
                        distance * 3
                    }
                )

                SwipeToDismissBox(
                    state = dismissState,

                    backgroundContent = {
                        val color by animateColorAsState(
                            if (dismissState.dismissDirection == SwipeToDismissBoxValue.EndToStart){
                                colorResource(R.color.teal_200)
                            }else{
                                colorResource(R.color.white)
                            }
                        )
                        val alignment = Alignment.CenterEnd
                        Box (
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color)
                                .padding(horizontal = 20.dp),
                            contentAlignment = alignment
                        ){
                            Icon(Icons.Default.Delete, contentDescription = "Delete")
                        }
                    }, // optional: you can show a delete icon here
                    content = {
                        WishItem(
                            wish = wishItem,
                            onClick = {
                                navController.navigate(
                                    Screen.AddScreen.route + "/${wishItem.id}"
                                )
                            }
                        )
                    }
                )
            }





        }
    }
}



@Composable
fun WishItem(wish: Wish, onClick: () -> Unit){

    Card (
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
            .background(color = colorResource(R.color.white)),
        onClick = onClick,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.white)
        ),
        shape = CardDefaults.elevatedShape,

    ){

        Text(
            text = wish.title,
            modifier = Modifier.padding(start = 16.dp,top = 16.dp),
            color = colorResource(R.color.black),
            fontWeight = FontWeight.W800
        )
        Text(
            text = wish.description,
            modifier = Modifier.padding(16.dp)
        )
    }
}

