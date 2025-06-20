package com.example.jetpackcomposecourse.`3_CoreComponents`

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecourse.R
import androidx.compose.material3.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation



@Composable
//@Preview(showBackground = true, showSystemUi = true)
fun OutTextField() {
    var email by remember {
        mutableStateOf("")
    }
    var text by remember {
        mutableStateOf("")
    }
    val focusManager = LocalFocusManager.current
    var isOpen by remember {
        mutableStateOf(false)
    }

    val rainbowColors = listOf<Color>(
        Color(0xFF9575CD),
        Color(0xFFBA68C8),
        Color(0xFFE57373),
        Color(0xFFFFB74D),
        Color(0xFFFFF176),
    )
    var text1 by remember {
        mutableStateOf("")
    }

    val brush = remember {
        Brush.linearGradient(
            colors = rainbowColors
        )
    }
    Column (
        modifier = Modifier.fillMaxSize().clickable(
            indication = null,
            interactionSource = remember { MutableInteractionSource() }
        ) {
            focusManager.clearFocus() // 👉 hide keyboard when clicking outside
        },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){




        OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
            },
            placeholder = {
                Text(text = "Enter your name")
            },
            label = {
                Text(text = "Name")
            },
            shape = RoundedCornerShape(20.dp),
            leadingIcon = {
              Icon(imageVector = Icons.Default.Person, contentDescription = "") },
           colors = TextFieldDefaults.colors(
               focusedIndicatorColor = Color(0xFF00C2FF),
//               unfocusedIndicatorColor = Color(R.color.magenta)
           )
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = text1,
            onValueChange = {
                text1 = it
            },
            textStyle = TextStyle(
                brush = brush
            ),
            modifier = Modifier.clip(RoundedCornerShape(27.dp)),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,

            )
        )


    }

}

@Composable
//@Preview(showBackground = true, showSystemUi = true)
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ){
                focusManager.clearFocus()
            }
        ,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            placeholder = { Text("Enter your email") },
            singleLine = true,
            colors = TextFieldDefaults.colors(

            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            placeholder = { Text("Enter your password") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.colors(

            ),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(26.dp))
        Button(
            onClick = { /* Handle login button click */ },
            modifier = Modifier.fillMaxWidth().height(50.dp)
        ) {
            Text("Login")
        }
    }
}

