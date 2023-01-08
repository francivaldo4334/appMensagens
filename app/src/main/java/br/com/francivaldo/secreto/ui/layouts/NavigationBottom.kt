package br.com.francivaldo.secreto.ui.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.*
import br.com.francivaldo.secreto.EnumBottomNavigate
import br.com.francivaldo.secreto.MainActivity
import br.com.francivaldo.secreto.ui.theme.surface
import br.com.francivaldo.secreto.R
import br.com.francivaldo.secreto.ui.theme.primary
import br.com.francivaldo.secreto.ui.theme.write

@Composable
fun BottonNavigation (){
    var enum = MainActivity.BottonNav
    Row(
        Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(surface)
    ) {
        Box(modifier = Modifier
            .fillMaxWidth(0.5f)
            .fillMaxHeight()
            .clickable {
                MainActivity.BottonNav = EnumBottomNavigate.suggestions
            }, contentAlignment = Alignment.Center){
            Icon(painter = painterResource(id = R.drawable.ic_activities), contentDescription = "Actifities",Modifier.size(24.dp), tint = if(enum == EnumBottomNavigate.suggestions) primary else write)
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .clickable {
                MainActivity.BottonNav = EnumBottomNavigate.Chat
            }, contentAlignment = Alignment.Center){
            Icon(painter = painterResource(id = R.drawable.ic_chat), contentDescription = "Actifities",Modifier.size(24.dp), tint = if(enum == EnumBottomNavigate.Chat) primary else write)
        }
    }
}