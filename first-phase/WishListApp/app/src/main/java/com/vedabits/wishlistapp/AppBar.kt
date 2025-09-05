package com.vedabits.wishlistapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarView(
    title: String,
    onBackNavClick: () -> Unit,
    scrollBehavior: TopAppBarScrollBehavior
){

    val navigationIcon: @Composable () -> Unit = {
        if (!title.contains("WishList App")){
            IconButton(
                onClick = onBackNavClick
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = colorResource(R.color.white)
                )
            }
        }else{
            null
        }

    }
    TopAppBar(
        scrollBehavior = scrollBehavior,
        title = { Text(
            text = title,
            color = colorResource(R.color.white),
            modifier = Modifier
                .padding(start = 12.dp)
                .heightIn(max = 24.dp)
        ) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = colorResource(R.color.app_bar_color)
        ),
        modifier = Modifier.background(color = colorResource(R.color.app_bar_color)),
        navigationIcon = {
            navigationIcon()
        }

    )
}