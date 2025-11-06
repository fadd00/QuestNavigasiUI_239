package com.sample.prak6

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

enum class navigasi {
    Formulir,
    Detail
}

@Composable
fun DataApp(
    navController: NavController = rememberNavController(),
    modifier: Modifier
){
    
}