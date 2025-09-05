package com.udemy.locationapp

import android.Manifest
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import com.udemy.locationapp.ui.theme.LocationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: LocationViewModel = viewModel()
            LocationAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(viewModel)
                }
            }
        }
    }
}


@Composable
fun MyApp(viewModel: LocationViewModel){
    val context = LocalContext.current
    val locationUtils = LocationUtil(context)
    LocationDisplay(
        locationUtil = locationUtils,
        context = context,
        viewModel = viewModel
    )
}


@Composable
fun LocationDisplay(
    locationUtil: LocationUtil,
    context: Context,
    viewModel: LocationViewModel
){
    val locationData = viewModel.locationData.value
    var address: String? = null
    locationData?.let {
        address = locationUtil.reverseGeoCodeLocation(it)
    }


    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions() ,
        onResult = { permissions ->
            if (permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true
                && permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true
                ) {
                locationUtil.requestLocationUpdates(viewModel = viewModel)
                // permission granted
//                Toast.makeText(context,"Already Granted", Toast.LENGTH_LONG).show()

            }else{
                // permission denied
                val rationalRequired = ActivityCompat.shouldShowRequestPermissionRationale(
                    context as MainActivity,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) || ActivityCompat.shouldShowRequestPermissionRationale(
                    context,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )

                if (rationalRequired){
                    Toast.makeText(context,"Permission Required", Toast.LENGTH_LONG).show()

                }else{
                    Toast.makeText(context,"Permission Denied", Toast.LENGTH_LONG).show()
                }


            }
        }
    )

    Column(
        modifier = Modifier.padding(16.dp).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        if (locationData != null){
            Text(text = "Latitude: ${locationData.latitude}")
            Text(text = "Longitude: ${locationData.longitude}")
            Text(text = "Address: $address")
        }else{
            Text(text = "Location not available")
        }
        Button(
            onClick = {
                if (locationUtil.hssLocationPermission(context)) {
                    // permission granted
                    locationUtil.requestLocationUpdates(viewModel = viewModel)
//                    Toast.makeText(context,"Already Granted", Toast.LENGTH_LONG).show()
                }else{
                    // request permission
                    requestPermissionLauncher.launch(
                        arrayOf(
                            Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION
                        )
                    )
                }
            }
        ) {
            Text(text = "Get Location")
            }

    }
}