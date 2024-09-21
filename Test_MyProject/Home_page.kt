package com.example.Test_MyProject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.rounded.AccountCircle
//import androidx.compose.material.icons.rounded.BookmarkAdd
//import androidx.compose.material.icons.rounded.CoPresent
//import androidx.compose.material.icons.rounded.Home
//import androidx.compose.material3.BottomAppBar
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
//
//@Composable
//fun Apple_home(navController: NavHostController, vm:ProductViewModels) {
//    Scaffold(
//
//        bottomBar = { composeBottomApp(navController)},
//
//        ) {
//        Box(
//            modifier = Modifier
//                .padding(it)
//                .fillMaxSize()
//                .background(Color(0xFFF8F2F4)),
//            contentAlignment = Alignment.Center,
//        ) {
//            Apple_first(navController,vm)
//        }
//    }
//}
//
//@Composable
//fun composeBottomApp(navController: NavHostController) {
//
//    BottomAppBar(
//        containerColor = Color(0xDFFFFFFF),
//        contentColor = Color.DarkGray,
//        modifier = Modifier.height(80.dp)
//    ) {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
//            modifier = Modifier.padding(bottom = 8.dp) // Add padding to space out from the bottom
//        ) {
//            IconButton(onClick = { navController.navigate("First_page") }) {
//                Icon(Icons.Rounded.Home, contentDescription = "Home", modifier = Modifier.size(30.dp))
//            }
//            Text("Home", style = TextStyle(fontSize = 16.sp))
//        }
//
//        Spacer(modifier = Modifier.width(40.dp)) // Adding space between icons
//
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
//            modifier = Modifier.padding(bottom = 8.dp) // Add padding to space out from the bottom
//        ) {
//            IconButton(onClick = {navController.navigate("Booking")}) {
//                Icon(Icons.Rounded.BookmarkAdd, contentDescription = "Cart", modifier = Modifier.size(30.dp))
//            }
//            Text("My Booking", style = TextStyle(fontSize = 16.sp))
//        }
//
//        Spacer(modifier = Modifier.width(40.dp)) // Adding space between icons
//
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
//            modifier = Modifier.padding(bottom = 8.dp) // Add padding to space out from the bottom
//        ) {
//            IconButton(onClick = { navController.navigate("Support")}) {
//                Icon(Icons.Rounded.CoPresent, contentDescription = "Account", modifier = Modifier.size(30.dp))
//            }
//            Text("Support", style = TextStyle(fontSize = 16.sp))
//        }
//
//        Spacer(modifier = Modifier.width(40.dp)) // Adding space between icons
//
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
//            modifier = Modifier.padding(bottom = 8.dp) // Add padding to space out from the bottom
//        )
//        {
//
////            IconButton(onClick = { navController.navigate("Account") }) {
////                Icon(Icons.Rounded.AccountCircle, contentDescription = "Account", modifier = Modifier.size(30.dp))
////            }
////            Text("About US", style = TextStyle(fontSize = 16.sp))
//            IconButton(onClick = { navController.navigate("AboutUs") }) {
//                Icon(Icons.Rounded.AccountCircle, contentDescription = "About Us", modifier = Modifier.size(30.dp))
//            }
//        }
//    }
//}
@Composable
fun Apple_home(navController: NavHostController, vm: ProductViewModels) {
    Scaffold(
        bottomBar = { composeBottomApp(navController, vm) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color(0xFFF8F2F4)),
            contentAlignment = Alignment.Center
        ) {
            Apple_first(navController, vm)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun composeBottomApp(navController: NavHostController, vm: ProductViewModels) {
    BottomAppBar(
        containerColor = Color(0xDFFFFFFF),
        contentColor = Color.DarkGray,
        modifier = Modifier.height(80.dp)
    ) {
        val iconSize = 40.dp
        val iconTint = Color(0xFF2B96E7)

        // Home Icon
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(1f) // Ensures equal spacing
        ) {
            IconButton(onClick = { navController.navigate("First_page") }) {
                Icon(Icons.Rounded.Home, contentDescription = "Home", modifier = Modifier.size(iconSize), tint = iconTint)
            }
            Text("Home", style = TextStyle(fontSize = 16.sp))
        }

        // Favorite Icon
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(1f) // Ensures equal spacing
        ) {
            IconButton(onClick = { navController.navigate("cart") }) {
                Box {
                    Icon(Icons.Rounded.FavoriteBorder, contentDescription = "Favorite", modifier = Modifier.size(iconSize), tint = iconTint)
                    Badge(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .clip(CircleShape)
                            .padding(4.dp) // Padding around the badge
                    ) {
                        Text(vm.numOfFavorite().toString())
                    }
                }
            }
            Text("Favorite", style = TextStyle(fontSize = 16.sp))
        }

        // Cart Icon with Badge
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(1f) // Ensures equal spacing
        ) {
            IconButton(onClick = { navController.navigate("cart") }) {
                Box {
                    Icon(Icons.Rounded.ShoppingCart, contentDescription = "Cart", modifier = Modifier.size(iconSize), tint = iconTint)
                    Badge(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .clip(CircleShape)
                            .padding(4.dp) // Padding around the badge
                    ) {
                        Text(vm.numOfFavorite().toString())
                    }
                }
            }
            Text("Cart", style = TextStyle(fontSize = 16.sp))
        }

        // About Us Icon
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(1f) // Ensures equal spacing
        ) {
            IconButton(onClick = { navController.navigate("About_us") }) {
                Icon(Icons.Rounded.AccountCircle, contentDescription = "About Us", modifier = Modifier.size(iconSize), tint = iconTint)
            }
            Text("About Us", style = TextStyle(fontSize = 16.sp))
        }
    }
}