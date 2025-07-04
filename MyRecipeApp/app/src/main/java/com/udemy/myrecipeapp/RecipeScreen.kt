package com.udemy.myrecipeapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import coil.compose.rememberAsyncImagePainter

@Composable
fun RecipeScreen(modifier: Modifier = Modifier,viewState: MainViewModel.RecipeState, navigateToDetail: (Category) -> Unit = {}){

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        when{
            viewState.isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            viewState.error != null -> {
                Text(
                    text = viewState.error ?: "Unknown error",
                    modifier = Modifier.fillMaxSize()
                )
            }

            else -> {
               // recipe list
                CategoryScreen(categories = viewState.list, navigateToDetail)
            }
        }
    }
}

@Composable
fun CategoryScreen(categories: List<Category>,navigateToDetail: (Category) -> Unit){
    LazyVerticalGrid(
        GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize()
    ){
        items(categories) {
            CategoryItem(category = it, navigateToDetail)
        }
    }
}


// How each item looks like
@Composable
fun CategoryItem(
    category: Category,
    navigateToDetail: (Category) -> Unit = {}
    ){

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize()
            .clickable(
                onClick = {
                    navigateToDetail(category)
                }
            )
            .border(
                border = BorderStroke(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.primary
            ),
                shape = MaterialTheme.shapes.medium
            )
    ){


        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = null,
            modifier = Modifier.padding(8.dp).size(120.dp),
        )
        Text(
            text = category.strCategory,
            modifier = Modifier.padding(top = 5.dp, bottom = 3.dp),
            maxLines = 2,
            style = TextStyle(fontWeight = FontWeight.Bold)
        )

    }

}
