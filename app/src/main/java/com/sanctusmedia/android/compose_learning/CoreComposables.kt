package com.sanctusmedia.android.compose_learning

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sanctusmedia.android.compose_learning.ui.theme.ComposelearningTheme

// examples from pages 20 to 31

class CoreComposables : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposelearningTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        Column {
                            // Text is the equivalent of TextView
                            Text(
                                text = "Text replaces TextView",
                                fontStyle = FontStyle.Italic,
                                textAlign = TextAlign.Center,
                                color = Color.Blue,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.SemiBold
                            )

                            NameInput()

                            Button(
                                onClick = { println("Pressed!") },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Red,
                                    contentColor = Color.White
                                )
                            ) {
                                Text(
                                    text = "Press me"
                                )
                            }

                            Image(
                                painter = painterResource(R.drawable.parrots),
                                contentDescription = "Parrots being fed",
                                contentScale = ContentScale.Fit
                            )

                            ColoredBox()
                            HorizontalNumbersList()
                            VerticalNamesList()
                        }

                        MyFloatingActionButton(modifier = Modifier.align(Alignment.BottomEnd))
                    }
                }
            }
        }
    }
}

@Composable
fun NameInput() {
    // remember is in-memory storage only, to keep data between Compose recompositions
    // it does not survive configuration changed or deallocation!
    val textState = remember { mutableStateOf("") }

    TextField(
        value = textState.value,
        onValueChange = { newValue ->
            textState.value = newValue
        },
        label = { Text("Your name") }
    )
}


@Composable
fun ColoredBox() {
    // Box replaces FrameLayout
    Box(modifier = Modifier
        // Be aware that modifiers are applied from outer layer to inner layer.
        // That means their order matters!
        .size(120.dp)
        .background(Color.Green)
        .padding(8.dp)
        .clip(RoundedCornerShape(size = 10.dp))
        .background(Color.Red)
    )
}

private val listTextSize = 20.sp

@Composable
fun HorizontalNumbersList() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("1", fontSize = listTextSize)
        Text("2", fontSize = listTextSize)
        Text("3", fontSize = listTextSize)
        Text("4", fontSize = listTextSize)
    }
}

@Composable
fun VerticalNamesList() {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.End,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("John", fontSize = listTextSize)
        Text("Ella", fontSize = listTextSize)
        Text("Milan", fontSize = listTextSize)
        Text("Barbara", fontSize = listTextSize)
    }
}

@Composable
fun MyFloatingActionButton(modifier: Modifier) {
    Box(modifier) {
        Surface(
            modifier = Modifier.size(48.dp),
            color = Color.Green,
            shape = CircleShape,
            content = {}
        )
        Text(
            text = "+",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
