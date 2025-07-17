package com.vedabits.wishlistapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(){
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
//            FloatingActionButtonView(
//                onFabClick = {}
//            )
            FloatingActionButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(16.dp),
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

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {

            items(10) {
                WishItem(
                    wish = Wish(
                        title = "Wish $it",
                        description = "Description $it"
                    ),
                    onClick = {
                        //TODO
                    }
                )
            }

        }

    }
}

@Composable
fun WishItem(wish: Wish, onClick:()-> Unit){
    Card (
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .background(color = colorResource(R.color.white)),
        onClick = onClick,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
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