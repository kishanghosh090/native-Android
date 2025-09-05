package com.udemy.githubapi.ui
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil.compose.rememberAsyncImagePainter
import com.udemy.githubapi.viewmodel.GitHubViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GitHubProfileScreen(viewModel: GitHubViewModel) {
    var username by remember { mutableStateOf("") }
    var isShown by remember { mutableStateOf(false) }

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

        Button(onClick = {
            Log.d("usernamethgfhfgh", username)
            viewModel.user = null
            viewModel.fetchUser(username)
            isShown = true
        }) {
            Text("Search")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (viewModel.isLoading) {
            CircularProgressIndicator()
        }

        viewModel.user?.let { user ->
          if (isShown){
              AlertDialog(
                  modifier = Modifier
                      .border(
                          color = Color.Green,
                          width = 1.dp,
                          shape = AlertDialogDefaults.shape
                      ),
                  onDismissRequest = {
                      isShown = false
                  },
                  title = {
                      Text(text = "Add Shopping Item")
                  },
                  text = {
                      Column(
                          horizontalAlignment = Alignment.CenterHorizontally,
                          modifier = Modifier.padding(16.dp).fillMaxWidth()

                      ) {
                        Image(
                            painter = rememberAsyncImagePainter(user.avatar_url),
                            contentDescription = null,
                            modifier = Modifier
                                .size(128.dp)
                                .clip(CircleShape),
                        )
                          Text(text = "Name: ${user.name}")
                          Text(text = "Login: ${user.login}")
                          Text(text = "Followers: ${user.followers}")

                      }


                  },
                  confirmButton = {

                  },
                  dismissButton = {
                      Button(onClick = { isShown = false }) {
                          Text(text = "Dismiss")
                      }
                  },

                  )
          }

        }

        viewModel.error?.let { error ->
            Text(error, color = Color.Red)
        }
    }
}

