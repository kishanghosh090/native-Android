package com.example.jetpackcomposecourse.`14_ProgressIndicator`

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ProgressIndicatorSample() {
    var loading by remember {
        mutableStateOf(false)
    }
  Column(
      modifier = Modifier
          .fillMaxSize()
          .padding(16.dp)
          .clickable(
              onClick = {
                  if (loading){
                      loading = !loading
                  }
              }
          ),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
  ) {
      Button(
          onClick = {
              loading = !loading
          },
          enabled = !loading,
//          modifier = Modifier.align(Alignment.CenterHorizontally)
      ) {
          Text(
              text = if (loading) "Loading" else "Load",
              modifier = Modifier.padding(end = 8.dp)
              )

      }
      if (loading){
          CircularProgressIndicator(
              modifier = Modifier.width(60.dp),
              color = MaterialTheme.colorScheme.primary,
              trackColor = MaterialTheme.colorScheme.surfaceVariant
          )
      }

  }
}

