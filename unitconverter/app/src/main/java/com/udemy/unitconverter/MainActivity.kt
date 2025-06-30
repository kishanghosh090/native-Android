package com.udemy.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.udemy.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UnitConverter(innerPadding)
                }
            }
        }
    }
}


@Composable
fun UnitConverter(innerPadding: PaddingValues){

    var focousManager = LocalFocusManager.current
    var text = remember { mutableStateOf("") }
    var outputVal by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Centimeters") }
    var outputUnit by remember { mutableStateOf("Meters") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }

    val conversionFactors = remember { mutableStateOf(0.01) }

    fun convertUnit(){
        val inputValDouble = text.value.toDoubleOrNull() ?: 0.0
        val conversionFactor = conversionFactors.value
        val result = (inputValDouble * conversionFactor).toString()
        outputVal = result
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = innerPadding.calculateTopPadding(),
                bottom = innerPadding.calculateBottomPadding(),
                start = 16.dp,
                end = 16.dp)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ){
                focousManager.clearFocus()
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Unit Converter",
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 32.dp)
            )
        OutlinedTextField(
            value = text.value,
            onValueChange = {
                text.value = it
                convertUnit()
            },
            placeholder = {
                Text(text = "Enter a value")
            },
            label = {
                Text(text = "Enter a unit")
            },
            modifier = Modifier.padding(bottom = 16.dp),
            singleLine = true,
            textStyle = MaterialTheme.typography.headlineSmall,
            shape = MaterialTheme.shapes.extraLarge,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                disabledContainerColor = MaterialTheme.colorScheme.surface,
            ),
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row (
            modifier = Modifier
                .padding(
                    bottom = 16.dp
                ),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(){
                Button(
                    onClick = {
                        iExpanded = true
                    },
                    modifier = Modifier.padding(end = 10.dp)
                ) {
                    Text(text = "$inputUnit")
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Drop Down"
                    )
                }
                DropdownMenu(
                    expanded = iExpanded,
                    onDismissRequest = {
                        iExpanded = false
                    },
                    shape = RoundedCornerShape(17.dp)

                ) {
                    DropdownMenuItem(
                        text = {
                            Text(text = "Centimeters")
                               },
                        onClick = {
                            inputUnit = "Centimeters"
                            iExpanded = false
                            conversionFactors.value = 0.01
                            convertUnit()
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Text(text = "Meters")
                               },
                        onClick = {
                            inputUnit = "Meters"
                            iExpanded = false
                            conversionFactors.value = 1.0
                            convertUnit()
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Text(text = "Feet")
                               },
                        onClick = {
                            inputUnit = "Feet"
                            iExpanded = false
                            conversionFactors.value = 0.3048
                            convertUnit()
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Text(text = "Miles")
                               },
                        onClick = {
                            inputUnit = "Miles"
                            iExpanded = false
                            conversionFactors.value = 1609.35
                            convertUnit()
                        }
                    )
                }
            }

            Box(){
                Button(
                    onClick = {
                        oExpanded = true
                    },
                    modifier = Modifier.padding(end = 10.dp)
                ) {
                    Text(text = "$outputUnit")
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Drop Down"
                    )
                }
                DropdownMenu(
                    expanded = oExpanded,
                    onDismissRequest = {
                        oExpanded = false
                    }
                ) {
                    DropdownMenuItem(
                        text = {
                            Text(text = "Centimeters")
                        },
                        onClick = {
                            outputUnit = "Centimeters"
                            oExpanded = false
                            conversionFactors.value = 0.1
                            convertUnit()

                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Text(text = "Meters")
                        },
                        onClick = {
                            outputUnit = "Meters"
                            oExpanded = false
                            conversionFactors.value = 1.0
                            convertUnit()

                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Text(text = "Feet")
                        },
                        onClick = {
                            outputUnit = "Feet"
                            oExpanded = false
                            conversionFactors.value = 3.28084
                            convertUnit()
                        }
                    )
                    DropdownMenuItem(
                        text = {
                            Text(text = "Miles")
                        },
                        onClick = {
                            outputUnit = "Miles"
                            oExpanded = false
                            conversionFactors.value = 0.000621371
                            convertUnit()
                        }
                    )
                }
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = outputVal, style = MaterialTheme.typography.headlineMedium)

    }
}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UnitConverterTheme {
        Greeting("Android")
    }
}