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
import br.com.francivaldo.secreto.R
import br.com.francivaldo.secreto.ui.theme.surface
import br.com.francivaldo.secreto.ui.theme.write

data class ItemNotification(val IconId:Int,val subscription:String,val onClick:()->Unit)
@Composable
fun ComponentNotifications (){
    val items = listOf<ItemNotification>(
        ItemNotification(0,"Descricao longa de exemplos,Descricao longa de exemplos,Descricao longa de exemplos,Descricao longa de exemplos,Descricao longa de exemplos"){},
        ItemNotification(0,"Descricao longa de exemplos,Descricao longa de exemplos,Descricao longa de exemplos,Descricao longa de exemplos,Descricao longa de exemplos"){},
        ItemNotification(0,"Descricao longa de exemplos,Descricao longa de exemplos,Descricao longa de exemplos,Descricao longa de exemplos,Descricao longa de exemplos"){},
        ItemNotification(0,"Descricao longa de exemplos,Descricao longa de exemplos,Descricao longa de exemplos,Descricao longa de exemplos,Descricao longa de exemplos"){}
    )
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)){
        items(items){
            Column(Modifier.fillMaxWidth()) {
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
                        painter = if (it.IconId == 0) {
                            painterResource(R.drawable.ic_notification)
                        } else{
                            painterResource(id = it.IconId)
                        }, contentDescription = "Avatar"
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                    Text(text = it.subscription, fontSize = 12.sp,color = write)
                }
                Spacer(modifier = Modifier.size(8.dp))
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .padding(horizontal = 8.dp)
                    .background(write.copy(alpha = 0.3f)))
            }
        }
    }
}