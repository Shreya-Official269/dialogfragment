package com.example.dialogfragment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.Colors
import com.example.dialogfragment.ui.theme.DialogFragmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DialogFragmentTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        DialogExample()
                    }
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun DialogExample() {
    // State to manage whether the dialog is shown
    val showDialog = remember { mutableStateOf(false) }

    Column {
        Button(onClick = { showDialog.value = true }) {
            Text(text = "Show Dialog")
        }

        // Show dialog based on state
        if (showDialog.value) {
            AlertDialog(
                onDismissRequest = { showDialog.value = false },
                title = { Text(text = "Sample Dialog") },
                text = {
                    Text(
                        text = "This is a simple dialog.",
                        color = MaterialTheme.colorScheme.onSurface
                    )
                },
                confirmButton = {
                    Button(
                        onClick = {
                            showDialog.value = false
                            // Handle button click actions here
                        }
                    ) {
                        Text(text = "OK")
                    }
                },
                dismissButton = {
                    Button(
                        onClick = {
                            showDialog.value = false
                            // Handle dismiss actions here
                        }
                    ) {
                        Text(text = "Cancel")
                    }
                }
            )
        }
    }
}

@Preview
@Composable
fun PreviewDialogExample() {
    DialogExample()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DialogFragmentTheme {
        Greeting("Android")
    }
}