package com.learnandroid.loginapplication.composables

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.learnandroid.loginapplication.BottomMenuContent
import com.learnandroid.loginapplication.R
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.compose.navigate

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomePage(navController: NavController, context: Context) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        Column {
            GreetingSection("IPox")

            CategoryMenu(
                items = listOf(
                    BottomMenuContent("", R.drawable.famous),
                    BottomMenuContent("", R.drawable.phone),
                    BottomMenuContent("", R.drawable.tablet),
                    BottomMenuContent("", R.drawable.laptop),
                    BottomMenuContent("", R.drawable.more),
                )
            )

            val paddingModifier = Modifier
                .padding(bottom = 10.dp)
                .padding(top = 0.dp)
            LazyVerticalGrid(
                cells = GridCells.Fixed(2)
            ) {
                item {
                    Card(elevation = 0.dp, modifier = paddingModifier) {
                        Image(
                            painter = painterResource(id = R.drawable.dv1)
                        )
                    }
                    Text(
                        text = "Iphone 13 Pro", textAlign = TextAlign.Center,
                        color = Color.Black,
                        modifier = Modifier.padding(top = 190.dp).padding(horizontal  = 50.dp)
                    )
                    Text(
                        text = "$25.00", textAlign = TextAlign.Center,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(top = 210.dp)
                            .padding(horizontal  = 50.dp)
                            .padding(bottom = 10.dp)
                    )
                }
                item {
                    Card(elevation = 0.dp, modifier = paddingModifier) {
                        Image(
                            painter = painterResource(id = R.drawable.dv2)
                        )
                    }
                    Text(
                        text = "Iphone 11", textAlign = TextAlign.Center,
                        color = Color.Black,
                        modifier = Modifier.padding(top = 190.dp).padding(horizontal  = 50.dp)
                    )
                    Text(
                        text = "$12.00", textAlign = TextAlign.Center,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(top = 210.dp)
                            .padding(horizontal  = 50.dp)
                            .padding(bottom = 10.dp)
                    )
                }
                item {
                    Card(elevation = 0.dp, modifier = paddingModifier) {
                        Image(
                            painter = painterResource(id = R.drawable.dv3)
                        )
                    }
                    Text(
                        text = "Iphone 11 Pro", textAlign = TextAlign.Center,
                        color = Color.Black,
                        modifier = Modifier.padding(top = 190.dp).padding(horizontal  = 50.dp)
                    )
                    Text(
                        text = "$50.00", textAlign = TextAlign.Center,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(top = 210.dp)
                            .padding(horizontal  = 50.dp)
                            .padding(bottom = 10.dp)
                    )
                }
                item {
                    Card(elevation = 0.dp, modifier = paddingModifier) {
                        Image(
                            painter = painterResource(id = R.drawable.dv4)
                        )
                    }
                    Text(
                        text = "Iphone 12", textAlign = TextAlign.Center,
                        color = Color.Black,
                        modifier = Modifier.padding(top = 190.dp).padding(horizontal  = 50.dp)
                    )
                    Text(
                        text = "$20.00", textAlign = TextAlign.Center,
                        color = Color.Black,
                        modifier = Modifier
                            .padding(top = 210.dp)
                            .padding(horizontal  = 50.dp)
                            .padding(bottom = 10.dp)
                    )
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
fun GreetingSection(
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

@Composable
fun CategoryMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeHighlightColor: Color = Color(0xFFF7F4F4),
    activeTextColor: Color = Color.Black,
    inactiveTextColor: Color = Color.Black,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(15.dp)
    ) {
        items.forEachIndexed { index, item ->
            CategoryMenuItem(
                item = item,
                isSelected = (index == selectedItemIndex),
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor
            ) {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun CategoryMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeHighlightColor: Color = Color(0xff505cf3),
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = Color(0xff9aa5c4),
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(activeHighlightColor)
                .padding(20.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = item.title,
            color = if(isSelected) activeTextColor else inactiveTextColor
        )
    }
}

@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeTextColor: Color = Color.Black,
    inactiveTextColor: Color = Color.Black,
    initialSelectedItemIndex: Int = 0,
    navController: NavController
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFFF7F4F4))
            .padding(15.dp)
    ) {
        items.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor,
                onItemClick = {
                    if (index == 0) {
                        navController.navigate("home_page"){
                            popUpTo = navController.graph.startDestination
                            launchSingleTop = true
                        }
                    } else if (index == 2) {
                        navController.navigate("notification_page"){
                            popUpTo = navController.graph.startDestination
                            launchSingleTop = true
                        }
                    }else if (index == 3) {
                        navController.navigate("profile_page"){
                            popUpTo = navController.graph.startDestination
                            launchSingleTop = true
                        }
                    }
                }
            ) {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = Color(0xff9aa5c4),
    onItemClick: () -> Unit,
    function: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = item.title,
            color = if(isSelected) activeTextColor else inactiveTextColor
        )
    }
}