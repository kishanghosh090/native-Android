import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface RandomUserApi {
    @GET("api/")
    suspend fun getRandomUser(): RandomUserResponse
}

object RetrofitInstance {
    val api: RandomUserApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RandomUserApi::class.java)
    }
}


@Composable
fun RandomUserScreen(viewModel: RandomUserViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    // Show toast for error/success
    LaunchedEffect(uiState) {
        when (uiState) {
            is UiState.Error -> Toast.makeText(context, (uiState as UiState.Error).message, Toast.LENGTH_SHORT).show()
            is UiState.Success -> Toast.makeText(context, "User fetched!", Toast.LENGTH_SHORT).show()
            else -> {}
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (uiState) {
            is UiState.Loading -> {
                CircularProgressIndicator()
                Spacer(modifier = Modifier.height(16.dp))
                Text("Loading...")
            }

            is UiState.Success -> {
                val user = (uiState as UiState.Success).user
                Image(
                    painter = rememberAsyncImagePainter(user.picture.large),
                    contentDescription = "User Image",
                    modifier = Modifier.size(120.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "${user.name.first} ${user.name.last}", style = MaterialTheme.typography.titleLarge)
                Text(text = user.email, style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(16.dp))
            }

            is UiState.Error, UiState.Idle -> {
                Text("Press the button to fetch a random user")
                Spacer(modifier = Modifier.height(16.dp))
            }
        }

        Button(onClick = { viewModel.fetchRandomUser() }) {
            Text("Fetch Random User")
        }
    }
}



sealed class UiState {
    object Idle : UiState()
    object Loading : UiState()
    data class Success(val user: User) : UiState()
    data class Error(val message: String) : UiState()
}

class RandomUserViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
    val uiState: StateFlow<UiState> = _uiState

    fun fetchRandomUser() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val response = RetrofitInstance.api.getRandomUser()
                _uiState.value = UiState.Success(response.results.first())
            } catch (e: Exception) {
                e.printStackTrace()
                _uiState.value = UiState.Error("Failed to fetch user")
            }
        }
    }
}

data class RandomUserResponse(
    val results: List<User>
)

data class User(
    val name: Name,
    val email: String,
    val picture: Picture
)

data class Name(
    val first: String,
    val last: String
)

data class Picture(
    val large: String
)
