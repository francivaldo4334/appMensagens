package br.com.francivaldo.secreto.ui.layouts

import android.view.MenuInflater
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.*
import br.com.francivaldo.secreto.EnumTopNavigate
import br.com.francivaldo.secreto.MainActivity
import br.com.francivaldo.secreto.ui.theme.surface
import br.com.francivaldo.secreto.R
import br.com.francivaldo.secreto.ui.theme.primary
import br.com.francivaldo.secreto.ui.theme.write


@Composable
fun TopNavigation (){
    var enum = MainActivity.topNav
    Column(
        Modifier
            .fillMaxWidth()
            .background(surface)
            .padding(bottom = 8.dp),
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
            contentAlignment = Alignment.CenterStart
        ){
            IconButton(
                modifier = Modifier.size(40.dp),
                onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "MenuDeOpcoes", tint = write, modifier = Modifier.size(16.dp))
            }
            Text(text = stringResource(id = R.string.app_name), fontSize = 18.sp, modifier = Modifier.padding(start = 72.dp))
        }
        Spacer(modifier = Modifier.height(32.dp))
        Row(Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
            Column(
                Modifier
                    .fillMaxWidth(0.5f)
                    .clickable {
                        MainActivity.topNav = EnumTopNavigate.Activities
                    }, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = stringResource(R.string.activities),fontSize = 12.sp)
                Box(modifier = Modifier
                    .fillMaxWidth(if (enum == EnumTopNavigate.Activities) 1f else 0f)
                    .height(4.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(primary))
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .clickable {
                        MainActivity.topNav = EnumTopNavigate.Notifications
                    }, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = stringResource(R.string.notifications),fontSize = 12.sp)

                Box(modifier = Modifier
                    .fillMaxWidth(if (enum == EnumTopNavigate.Notifications) 1f else 0f)
                    .height(4.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(primary))
            }
        }
    }
}