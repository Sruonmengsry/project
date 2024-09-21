package com.example.Test_MyProject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Apple_first(navController: NavHostController, vm:ProductViewModels) {
    Scaffold(
        topBar = { composeTopBar() },
//        bottomBar = { composeBottomAppBar(navController)},
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(Color(0xFFF8F2F4)),
            contentAlignment = Alignment.Center,
        ) {
            AppleMultiLayouts(navController,vm)
        }
    }
}

@Composable
fun composeTopBar() {
    Box(
        modifier = Modifier
            .background(Color(0xFF2B96E7))
            .height(70.dp)
            .width(500.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(bottom = 8.dp, start = 25.dp, top = 20.dp) // Add padding to space out from the bottom
                .fillMaxWidth() // Ensure the Column takes full width to center the text properly
        ) {
            Text(
                text = "Apple Stores",
                style = TextStyle(
                    fontSize = 24.sp, // Set your desired font size
                    color = Color(0xFFFFFFFF), // Set your desired text color (using the same color as TopAppBar background for example)
                    fontWeight = FontWeight.Bold // Optional: set the font weight (e.g., Bold)
                ),
//                textAlign = TextAlign.Center // Center-align the text within the Text composable
            )
        }

    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(top= 10.dp, start = 345.dp) // Add padding to space out from the bottom
    ) {

    }
}