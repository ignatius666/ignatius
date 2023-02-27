package com.learnandroid.loginapplication.composables


import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.learnandroid.loginapplication.BottomMenuContent
import com.learnandroid.loginapplication.R

@Composable
fun NotificationPage(navController: NavController, context: Context) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()


    ) {
        Column (){
            Secction("IPox")

            Column (

                modifier = Modifier.fillMaxSize().padding(20.dp)

            ) {

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                        .clickable{ },
                    elevation = 10.dp
                ) {
                    Column(
                        modifier = Modifier.padding(15.dp)
                    ) {
                        Text(
                            buildAnnotatedString {
                                append("Hai ")
                                withStyle(style = SpanStyle(fontWeight = FontWeight.W900, color = Color(0xFF4552B8))
                                ) {
                                    append("Pesananan Anda Diserahkan Ke Kurir ")
                                }
                            }
                        )
                        Text(
                            buildAnnotatedString {
                                append("paket dengan kode ")
                                withStyle(style = SpanStyle(fontWeight = FontWeight.W900)) {
                                        append("W66DDDH399JD7HH ")
                                }
                                append("Telah dikirim oleh LerLergum official")
                            }
                        )
                    }
                }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                        .clickable{ },
                    elevation = 10.dp
                ) {
                    Column(
                        modifier = Modifier.padding(15.dp)
                    ) {
                        Text(
                            buildAnnotatedString {
                                append("Hai ")
                                withStyle(style = SpanStyle(fontWeight = FontWeight.W900, color = Color(0xFF4552B8))
                                ) {
                                    append("Pesananan Anda Diserahkan Ke Kurir ")
                                }
                            }
                        )
                        Text(
                            buildAnnotatedString {
                                append("paket dengan kode ")
                                withStyle(style = SpanStyle(fontWeight = FontWeight.W900)) {
                                    append("S78S9YWH3J2992NG ")
                                }
                                append("Telah dikirim oleh kongkongdim official")
                            }
                        )
                    }
                }
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
fun Secction(
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