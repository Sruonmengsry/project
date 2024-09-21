package com.example.week12


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.Test_MyProject.ProductViewModels
import com.example.Test_MyProject.link_Page

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            AsyncApp()



        }
    }
}
@Composable
fun AsyncApp(){
    val vm = ProductViewModels()
    link_Page()
}
