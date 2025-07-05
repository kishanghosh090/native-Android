package com.udemy.githubapi.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.udemy.githubapi.viewmodel.GitHubViewModel

@Composable
fun GitHubProfileScreen(viewModel: GitHubViewModel) {
    var username by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("GitHub Username") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { viewModel.fetchUser(username) }) {
            Text("Search")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (viewModel.isLoading) {
            CircularProgressIndicator()
        }

        viewModel.user?.let { user ->
            Image(
                painter = rememberAsyncImagePainter(user.avatar_url),
                contentDescription = "Profile Picture",
                modifier = Modifier.size(100.dp).clip(CircleShape)
            )
            Text("Name: ${user.name ?: "N/A"}")
            Text("Followers: ${user.followers}")
        }

        viewModel.error?.let { error ->
            Text(error, color = Color.Red)
        }
    }
}

