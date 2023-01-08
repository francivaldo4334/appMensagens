package br.com.francivaldo.secreto.ui.layouts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.francivaldo.secreto.EnumTopNavigate
import br.com.francivaldo.secreto.MainActivity

@Composable
fun LayoutHome(){
    Column(Modifier.fillMaxSize()) {
        TopNavigation()
        when(MainActivity.topNav){
            EnumTopNavigate.Activities -> ComponentActivities()
            EnumTopNavigate.Notifications -> ComponentNotifications()
        }
    }
}