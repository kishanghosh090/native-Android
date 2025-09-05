package com.example.neetrootcourse
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
//import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

//@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginUi(navController: NavController){

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var context = LocalContext.current


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(17.dp),
            placeholder = { Text("Enter username") },
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.colors(
//                focusedContainerColor = androidx.compose.ui.graphics.Color.White,
//                unfocusedContainerColor = androidx.compose.ui.graphics.Color.White,
                focusedIndicatorColor = androidx.compose.ui.graphics.Color.Transparent,
                unfocusedIndicatorColor = androidx.compose.ui.graphics.Color.Transparent,
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Person, contentDescription = "Person")
            }


        )
        TextField(
            value = password,
            onValueChange = {
                password  = it
            },
            label = { Text(text = "password") },
            modifier = Modifier.fillMaxWidth().padding(17.dp),
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.colors(
//                focusedContainerColor = androidx.compose.ui.graphics.Color.White,
//                unfocusedContainerColor = androidx.compose.ui.graphics.Color.White,
                focusedIndicatorColor = androidx.compose.ui.graphics.Color.Transparent,
                unfocusedIndicatorColor = androidx.compose.ui.graphics.Color.Transparent,
            ),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
            singleLine = true,
            placeholder = { Text(text = "Enter password") },
            visualTransformation = androidx.compose.ui.text.input.PasswordVisualTransformation(),
            leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = "password")
            }
        )
        Text(text = "username = $username")
        Text(text = "password = $password")
        Box( modifier = Modifier.fillMaxWidth().padding(17.dp)){
            Button(onClick = {
                if (!username.isEmpty() && !password.isEmpty()){
                    Toast.makeText(context,"$username $password",Toast.LENGTH_SHORT).show()
                    navController.navigate(routes.Details(name = username,password = password))

                }
                else{

                    Toast.makeText(context,"please enter username and password",Toast.LENGTH_SHORT).show()
                }


            },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),


            ) {
                Text(text = "Login")
            }
        }
    }

}
