package net.firzen.android.composelearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.firzen.android.composelearning.theme.ComposelearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ComposelearningTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Greeting(
                            name = "Android"
                        )

                        Button(onClick = { println("ABC") }) {
                            Text(text = "Test")
                        }

                        MailButton(1337) {
                            println("Mail id $it expanded!")
                        }
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
fun MailButton(mailId: Int, mailPressedCallback: (Int) -> Unit) {
    Button(onClick = {mailPressedCallback(mailId)}) {
        Text(text = "Expand mail $mailId")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposelearningTheme {
        Greeting("Android")
    }
}
