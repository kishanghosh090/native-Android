package com.udemy.retrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
//import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
//import androidx.compose.material3.LoadingIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.udemy.retrofit.ui.theme.RETROFITTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: MainViewModel = viewModel ()
            RETROFITTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                        RecipeFun(viewModel = viewModel, innerPadding = innerPadding)

                    RecipeScreen(
                    )
                }
            }
        }
    }
}

//
////@OptIn(ExperimentalMaterial3ExpressiveApi::class)
//@Composable
//fun RecipeFun(viewModel: MainViewModel,innerPadding: PaddingValues) {
//    val state = viewModel.categoriesState.value
//    if (state.isLoading){
//        CircularProgressIndicator(
//            modifier = Modifier.size(48.dp),
//            color = MaterialTheme.colorScheme.primary,
//            strokeWidth = 4.dp
//        )
//
//    }
//    LazyVerticalGrid(
//        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = innerPadding.calculateTopPadding()),
//        columns = GridCells.Adaptive(150.dp),
//        ) {
//
//        items(state.categories.size) { index ->
//            Image(
//                painter = rememberAsyncImagePainter(state.categories[index].strCategoryThumb),
//                contentDescription = null,
//                modifier = Modifier.padding(4.dp).size(150.dp)
//            )
//            Text(text = state.categories[index].strCategory)
//        }
//    }
//
//
//}
//
//
