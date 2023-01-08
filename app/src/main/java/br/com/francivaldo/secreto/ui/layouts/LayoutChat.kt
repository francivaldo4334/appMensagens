package br.com.francivaldo.secreto.ui.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.francivaldo.secreto.MainActivity
import br.com.francivaldo.secreto.ui.theme.background
import br.com.francivaldo.secreto.ui.theme.primary
import br.com.francivaldo.secreto.ui.theme.surface
import br.com.francivaldo.secreto.ui.theme.write

data class ItemConversation(val FirstPerson:Boolean,val menssage:String)
data class ItemContact(val Name:String,val Conversation:List<ItemConversation>);
@Composable
fun LayoutChat() {
    val item = ItemContact("Nome de Usuario", listOf(
        ItemConversation(true,"Hola."),
        ItemConversation(false,"Oi"),
        ItemConversation(true,"Tudo bem com voce?"),
        ItemConversation(false,"Sim, obrigado por perguntar :)"),
    ))
    Column(
        Modifier
            .fillMaxSize()
            .background(background)) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(surface)
            .height(56.dp), contentAlignment = Alignment.CenterStart){
            Text(text = item.Name, fontSize = 14.sp, modifier = Modifier.padding(start = 72.dp),color = write)
            IconButton(
                modifier = Modifier.size(40.dp),
                onClick = {
                MainActivity.navController.popBackStack()
            }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "BackPress", tint = write, modifier = Modifier.size(16.dp))
            }
        }
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(16.dp)){
            items(item.Conversation){
                if(it.FirstPerson){
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd){
                        Box(modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(
                                primary
                            )
                            .padding(8.dp)
                        ){
                            Text(text = it.menssage, fontSize = 12.sp,color = write)
                        }
                    }
                }else{
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart){
                        Box(modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(
                                surface
                            )
                            .padding(8.dp)
                        ){
                            Text(text = it.menssage, fontSize = 12.sp,color = write)
                        }
                    }
                }
                Spacer(modifier = Modifier.size(16.dp))
            }
        }
    }
}