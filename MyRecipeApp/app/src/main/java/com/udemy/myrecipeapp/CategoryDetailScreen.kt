package com.udemy.myrecipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryDetailScreen(category: Category,navController: NavHostController){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
//        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = {
                Text(text = "${category.strCategory} Detail",
                    modifier = Modifier.padding(start = 8.dp)
                    )

            },
            modifier = Modifier.padding(bottom = 8.dp),
            navigationIcon = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = category.strCategory,
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    }
                    )
            }
        )
        Text(
            text = category.strCategory,
            style = MaterialTheme.typography.headlineLarge
        )

        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 8.dp)
                .size(200.dp)
                .aspectRatio(1f),
            alignment = Alignment.Center,
        )
        Text(
            text = category.strCategoryDescription,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(top = 8.dp)
                .verticalScroll(rememberScrollState()),
            textAlign = TextAlign.Justify,
        )
    }

}