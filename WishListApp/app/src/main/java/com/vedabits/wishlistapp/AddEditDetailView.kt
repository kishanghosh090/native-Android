package com.vedabits.wishlistapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.vedabits.wishlistapp.data.Wish
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditDetailView(
    id: Long,
    viewModel: WishViewModel,
    navController: NavHostController
){
    val snackMessage = remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScrollState()

    Scaffold(
        topBar = {
            AppBarView(
                title = "Add Wish or update ",
                onBackNavClick = { navController.popBackStack() },
                scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
            )
        }
    ) {innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(
                modifier = Modifier.height(10.dp)
            )
            WishTextField(
                label = "Title",
                value = viewModel.title,
                onValueChange = {
                    viewModel.title = it
                }
            )
            Spacer(
                modifier = Modifier.height(10.dp)
            )
            WishTextField(
                label = "Description",
                value = viewModel.description,
                onValueChange = {
                    viewModel.description = it
                }
            )
            Spacer(
                modifier = Modifier.height(10.dp)
            )
            Button(
                onClick = {
                    if (viewModel.title.isNotEmpty() && viewModel.description.isNotEmpty()){

                        if (id != -1L){
                            viewModel.updateWish(
                                Wish(
                                    id = id,
                                    title = viewModel.title,
                                    description = viewModel.description
                                )
                            )

                        }else{
                            //
                            viewModel.addWish(
                                Wish(
                                    title = viewModel.title,
                                    description = viewModel.description
                                )
                            )

                        }
                    }else{
                        snackMessage.value = "Please fill all the fields"
                    }
                    scope.launch {
                        scaffoldState.animateScrollTo(0)
                        navController.popBackStack()
                        viewModel.title = ""
                        viewModel.description = ""
                    }
                },
                modifier = Modifier.padding(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.black),
                    contentColor = colorResource(R.color.white)
                )
            ) {
                Text(text = "Save")
            }
        }
    }
}

@Composable
fun WishTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = label, color = Color.Black)
        },
        singleLine = true,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        )
    )
}