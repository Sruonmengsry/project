package com.example.Test_MyProject

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DeleteForever
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.Test_MyProject.ProductViewModels


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteFoodScreen(
    navController: NavController,
    vm: ProductViewModels
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Product Favorite") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Rounded.ArrowBackIosNew,
                            contentDescription = "Back",
                            modifier = Modifier.size(30.dp)
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF2B96E7)
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding // Apply the padding for the scaffold
        ) {
            items(vm.favoriteList.value) { item ->
                // Create a Row for each item
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            navController.navigate("product_detail/${item.pid}") // Use `item` here
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(modifier = Modifier.size(120.dp)) {
                        // Image
                        AsyncImage(
                            model = item.image,
                            contentDescription = null,
                        )
                    }
                    // Title and additional details in a Column
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp)
                    ) {
                        Text(
                            text = "Title: ${item.title}",
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                        Text(
                            text = "Price: ${item.price}",
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                        Text(
                            text = "Qty: ${item.qty}",
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                    }

                    // Remove button
                    IconButton(onClick = {
                        vm.removeFromFavorite(item)
                    }) {
                        Icon(
                            Icons.Default.DeleteForever,
                            contentDescription = "Remove",
                            tint = Color(color = 0xFFDF0526)
                        )
                    }
                }
            }
        }
    }
}

