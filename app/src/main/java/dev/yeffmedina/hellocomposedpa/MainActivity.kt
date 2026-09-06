package dev.yeffmedina.hellocomposedpa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yeffmedina.hellocomposedpa.ui.theme.HelloComposeDPATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloComposeForm()
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelloComposeForm(){
    var name by remember { mutableStateOf(  "") }
    var birthDate by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar({Text("Bienvenido a ESAN")})
            TopAppBar({Text("Bienvenido a ESAN")})

        }
    ) { padding ->
        Column(
           modifier = Modifier
               .padding(padding)
               .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Text("Bienvenido a Jetpack Compose")
            OutlinedTextField(
                value = name
                , onValueChange = {name=it}
                , label = {Text("Nombre")}
                , keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            OutlinedTextField(
                value = birthDate
                , onValueChange = {birthDate=it}
                , label = {Text("Fecha de nacimiento")}
            )
            Button(
                onClick = {},
                enabled = name.isNotEmpty()&& birthDate.isNotEmpty()
            )
            {
                Text("Enviar")
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HelloComposeDPATheme {
        Greeting("Android")
    }
}