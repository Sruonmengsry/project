package com.example.Test_MyProject

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScaffold(vm: ProductViewModels, navController: NavHostController) {
    var searchQuery by remember { mutableStateOf("") }

    val defaultTextStyle = TextStyle(fontSize = 16.sp, color = Color.Black)

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    TextField(
                        value = searchQuery,
                        onValueChange = { newQuery -> searchQuery = newQuery },
                        placeholder = {
                            Text("Search products...", style = defaultTextStyle)
                        },
                        textStyle = defaultTextStyle,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .border(
                                width = 2.dp,
                                color = Color.White,
                                shape = RoundedCornerShape(20.dp)
                            ),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            disabledContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                        )
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("Home_page") }) {
                        Icon(
                            Icons.Rounded.Home,
                            contentDescription = "Home",
                            modifier = Modifier.size(30.dp),
                            tint = Color(0xFF323536)
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFF2B96E7)),
                actions = {
                    Box(modifier = Modifier.padding(12.dp)) {
                        IconButton(onClick = {
//                            nc.navigate("favorite")
                            navController.navigate("cart")
                        }) {
                            Icon(
                                Icons.Default.ShoppingCart,
                                contentDescription = "ShoppingCart",
                            )
                        }
                        Badge(
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .clip(CircleShape)
                        ) {
                            Text(vm.numOfFavorite().toString())
                        }
                    }

                }
            )
        }
    ) { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            ProductBody(
                vm = vm,
                navController = navController,
                searchQuery = searchQuery,
                textStyle = defaultTextStyle
            )
        }
    }
}

@Composable
fun ProductBody(
    vm: ProductViewModels,
    navController: NavHostController,
    searchQuery: String,
    textStyle: TextStyle
) {
    LaunchedEffect(Unit) {
        vm.getResultList()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        when {
            vm.isLoading -> CircularProgressIndicator()
            vm.errorMessage.isNotEmpty() -> Text("Error: ${vm.errorMessage}", style = textStyle)
            else -> {
                LazyColumn {
                    items(vm.records.filter { it.title.contains(searchQuery, ignoreCase = true) }) { element ->
                        Row(
                            modifier = Modifier
                                .padding(10.dp)
                                .clickable {
                                    navController.navigate("product_detail/${element.pid}")
                                },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Surface(modifier = Modifier.size(120.dp)) {
                                AsyncImage(
                                    model = element.image,
                                    contentDescription = element.title
                                )
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text("Title: ${element.title}", style = textStyle)
                                    Text("USD ${element.price}", style = textStyle)
                                    Text("In Stock: ${element.qty}", style = textStyle)
                                }
                                IconButton(
                                    onClick = {
                                        vm.addToFavorite(element)
                                    },
                                    modifier = Modifier.size(30.dp)
                                ) {
                                    Icon(Icons.Rounded.FavoriteBorder, contentDescription = "Add to Cart")
                                }
                                IconButton(
                                    onClick = {
                                        vm.addToFavorite(element)
                                    },
                                    modifier = Modifier.size(30.dp)
                                ) {
                                    Icon(Icons.Rounded.ShoppingCart, contentDescription = "Add to Cart")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}