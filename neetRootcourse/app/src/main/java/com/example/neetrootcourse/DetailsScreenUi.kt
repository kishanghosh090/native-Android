package com.example.neetrootcourse
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.navOptions

@Composable
fun DetailsScreen(navController: NavController,name:String,password:String){
    Text(text = "Details Screen")
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "name = $name")
        Text(text = "password = $password")

        Button(onClick = {
            navController.navigate(routes.Login, navOptions = navOptions {
                popUpTo(routes.Login) {
                    inclusive = true
                    saveState = true
                }
            })
        }) {
            Text(text = "go back")
        }
    }

}
