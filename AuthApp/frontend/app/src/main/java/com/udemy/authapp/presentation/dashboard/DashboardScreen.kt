package com.udemy.authapp.presentation.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.udemy.authapp.data.datastore.UserPreferences
import com.udemy.authapp.presentation.navigation.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun DashboardScreen(navController: NavController = rememberNavController()) {
    val context = LocalContext.current
    val prefs = remember { UserPreferences(context) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to Dashboard 🎉", style = MaterialTheme.typography.labelLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            CoroutineScope(Dispatchers.Main).launch {
                prefs.clearToken()
                navController.navigate(Screen.Login.route) {
                    popUpTo(Screen.Dashboard.route) { inclusive = true }
                }
            }
        }) {
            Text("Logout")
        }
    }
}
