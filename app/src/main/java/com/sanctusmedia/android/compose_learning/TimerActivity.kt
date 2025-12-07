package com.sanctusmedia.android.compose_learning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.sanctusmedia.android.compose_learning.ui.theme.ComposelearningTheme
import kotlin.concurrent.timer

// example from page 15

class TimerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposelearningTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Row(modifier = Modifier.padding(innerPadding)) {
                        TimerText(seconds)
                    }
                }
            }
        }
    }
}

// operator `by` delegates get/set calls from `seconds` to `mutableStateOf()`, which triggers
// recomposition of Compose
private var seconds by mutableStateOf(0)

private val stopWatchTimer = timer(period = 1000) { seconds++ }

@Composable
fun TimerText(seconds: Int) {
    Text(text = "Elapsed: $seconds")
}
