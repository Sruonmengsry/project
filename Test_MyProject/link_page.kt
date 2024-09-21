package com.example.Test_MyProject

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

//import androidx.compose.runtime.Composable
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.example.local_product_modul.ProductScaffold
//
//@Composable
//fun link_Page() {
//    val vm=ProductViewModels()
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = "Home_page") {
////      composable(route = "Sign_In") {
////            composeSignIn(navController)
////        }
////        composable(route = "Sign_Up") {
////            composeSignUp(navController)
////        }
//        composable(route = "Home_page") {
//            Apple_home(navController,vm)
//        }
//        composable(route = "First_page") {
//            Apple_first(navController,vm)
//        }
//        composable(route = "ListMenuApple") {
//            ProductScaffold(vm,navController)
//        }
//
//        // Add the About Us page route
////        composable(route = "AboutUs") {
////            AboutUsPage()
////        }
//        composable(route = "About_us") {
//            AboutUsPage(navController,vm)
//        }
//    }
//}
@Composable
fun link_Page() {
    val vm=ProductViewModels()
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home_page") {
        composable(route = "Home_page") {
            Apple_home(navController,vm)
        }
        composable(route = "First_page") {
            Apple_first(navController,vm)
        }
        composable(route = "ListMenuApple") {
            ProductScaffold(vm, navController)
        }
        composable("product_detail/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId") ?: ""
            ProductDetailScreen(productId = productId, vm, navController = navController)
        }
        composable(route = "About_us") {
            AboutUsPage(navController,vm)
        }
        composable(route = "cart") {
            FavoriteFoodScreen(navController,vm)
        }


    }
}