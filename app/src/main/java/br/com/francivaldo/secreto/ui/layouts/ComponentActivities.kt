package br.com.francivaldo.secreto.ui.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.francivaldo.secreto.EnumBottomNavigate
import br.com.francivaldo.secreto.MainActivity
import br.com.francivaldo.secreto.ui.theme.primary
import br.com.francivaldo.secreto.R
import br.com.francivaldo.secreto.Routes
import br.com.francivaldo.secreto.ui.theme.surface
import br.com.francivaldo.secreto.ui.theme.write

@Composable
fun ComponentActivities (){
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        Column(
            Modifier
                .padding(8.dp)
                .weight(1f)) {
            when(MainActivity.BottonNav){
                EnumBottomNavigate.suggestions ->Sugestions()
                EnumBottomNavigate.Chat -> Chat()
            }
        }
        BottonNavigation()
    }
}
@Composable
private fun Sugestions(){
    Column(Modifier.fillMaxSize(1f)) {
        val onClicks = listOf<()->Unit>(
            {},
            {},
            {},
            {},
            {},
            {}
        )
        BoxButton(w = 1f, h = 0.2f, text = "Copiar o link do meu perfil",onClick = onClicks[0])
        Row(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f)) {
            Column(
                Modifier
                    .fillMaxWidth(0.5f)
                    .fillMaxHeight()) {
                BoxButton(w = 1f, h = 0.4f, text = "Enviar uma mensagem!",onClick = onClicks[1])
                BoxButton(w = 1f, h = 1f, text = "Enviar uma foto!",onClick = onClicks[2])
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()) {
                BoxButton(w = 1f, h = 0.6f, text = "Enviar um video!",onClick = onClicks[3])
                BoxButton(w = 1f, h = 1f, text = "Adicionar um contato.",onClick = onClicks[4])
            }
        }
        BoxButton(w = 1f, h = 1f, text = "Trocar de tema",onClick = onClicks[5])
    }
}
data class ItemChat(val AvatarId:Int,val Name:String,val onClick: () -> Unit)
@Composable
private fun Chat(){
    val items = listOf<ItemChat>(
        ItemChat(0,"item 1"){
            MainActivity.navController.navigate(Routes.Chat)
        },
        ItemChat(0,"item 2"){}
    )
    LazyColumn(modifier = Modifier.fillMaxSize()){
        items(items){
            Row(
                Modifier
                    .clickable(onClick = it.onClick)
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(
                            surface
                        ),
                    painter = if (it.AvatarId == 0) {
                        painterResource(R.drawable.ic_avatar)
                    } else{
                        painterResource(id = it.AvatarId)
                    }, contentDescription = "Avatar"
                )
                Spacer(modifier = Modifier.size(16.dp))
                Text(text = it.Name, fontSize = 14.sp,color = write)
            }
        }
    }
}
@Composable
private fun BoxButton(w:Float,h:Float,text:String,onClick:()->Unit){
    Box(modifier = Modifier
        .clickable(onClick = onClick)
        .fillMaxWidth(w)
        .fillMaxHeight(h)
        .padding(8.dp)
        .clip(RoundedCornerShape(8.dp))
        .background(primary), contentAlignment = Alignment.BottomStart){
        Text(text = text,Modifier.padding(bottom = 8.dp, start = 8.dp,end = 8.dp),fontSize = 14.sp,color = write)
    }
}