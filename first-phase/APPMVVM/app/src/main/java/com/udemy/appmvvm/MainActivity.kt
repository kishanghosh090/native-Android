package com.udemy.appmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.udemy.appmvvm.ui.theme.APPMVVMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: CounterViewModel = viewModel()
            APPMVVMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TheCounterApp(
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}

@Composable
fun TheCounterApp(viewModel: CounterViewModel){

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "Counter: ${viewModel.count.value}")
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { viewModel.increment() }
            ) {
                Text(text = "Increment")
            }
            Spacer(
                modifier = Modifier.padding(horizontal = 16.dp).height(12.dp)
            )
            Button(
                onClick = { viewModel.decrement() }
            ) {
                Text(text = "Decrement")
            }
        }

    }

}
