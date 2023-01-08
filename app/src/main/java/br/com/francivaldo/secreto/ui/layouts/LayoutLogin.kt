package br.com.francivaldo.secreto.ui.layouts

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.francivaldo.secreto.MainActivity
import br.com.francivaldo.secreto.Routes

@Composable
fun LayoutLogin() {
    var valueEmail by remember{ mutableStateOf("") }
    var valuePass by remember{ mutableStateOf("") }
    Column(Modifier.fillMaxSize().padding(horizontal = 16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.size(72.dp))
        Text(text = "Email")
        BasicTextField(value = valueEmail, onValueChange = {valueEmail = it})
        Spacer(modifier = Modifier.size(16.dp))
        Text(text = "Password")
        BasicTextField(value = valuePass, onValueChange = {valuePass = it})
        Spacer(modifier = Modifier.size(32.dp))
        Button(onClick = {
            MainActivity.navController.navigate(Routes.Home)
        }) {
            Text(text = "Logar")
        }
        Button(onClick = {
            MainActivity.navController.navigate(Routes.Loginup)
        }) {
            Text(text = "Ir pra Cadastro")
        }
    }
}