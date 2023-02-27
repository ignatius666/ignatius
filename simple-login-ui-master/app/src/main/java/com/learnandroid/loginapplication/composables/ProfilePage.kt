package com.learnandroid.loginapplication.composables

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.learnandroid.loginapplication.BottomMenuContent
import com.learnandroid.loginapplication.R

@Composable
fun ProfilePage(navController: NavController, context: Context, name: MutableState<String>, email: MutableState<String>) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()


    ) {
        Column (){
            Section("IPox")

            Column (
                modifier = Modifier.fillMaxSize(),

                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .padding(PaddingValues(top = 20.dp))
                        .padding(PaddingValues(bottom = 10.dp))

                )
                Text(name.value, fontWeight = FontWeight.Light, fontSize = 20.sp)
                Text(email.value, fontWeight = FontWeight.Light, fontSize = 20.sp)
            }

        }
        BottomMenu(items = listOf(
            BottomMenuContent("Home", R.drawable.home),
            BottomMenuContent("Cart", R.drawable.pin),
            BottomMenuContent("Notification", R.drawable.noitf),
            BottomMenuContent("User", R.drawable.user),
        ), modifier = Modifier.align(Alignment.BottomCenter), navController = navController)
    }

}

@Composable
fun Section(
    name: String = ""
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .padding(horizontal = 20.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            tint = Color.Black,
            modifier = Modifier.size(25.dp)
        )
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = name,
                color = Color.Black,
                style = MaterialTheme.typography.h2,
                fontSize = 25.sp
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_cart),
            tint = Color.Black,
            modifier = Modifier.size(25.dp)
        )
    }
}


