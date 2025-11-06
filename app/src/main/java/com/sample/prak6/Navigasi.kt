package com.sample.prak6

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
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
    Scaffold { isiRuang->
        _root_ide_package_.androidx.navigation.NavHost(
            navController = navController,
            startDestination = navigasi.Formulir.name,
            modifier = modifier.padding(isiRuang)
        ) {
            composable(route = navigasi.Formulir.name) {
                FormIsian(
                    OnSubmitBtnClick = {
                        navController.navigate(navigasi.Detail.name)
                    }
                )
            }
            
        }
    }
}