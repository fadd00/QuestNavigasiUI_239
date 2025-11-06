package com.sample.prak6

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sample.prak6.view.TampilData

enum class navigasi {
    Formulir,
    Detail
}

@Composable
fun DataApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
){
    Scaffold { isiRuang->
        NavHost(
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
            composable(route = navigasi.Detail.name) {
                TampilData(
                    OnBackBtnClick = {
                        cancelAndBackToFormulir(navController)
                    }
                )
            }
        }
    }
}
private fun cancelAndBackToFormulir(
    navController: NavHostController
){
    navController.popBackStack(navigasi.Formulir.name, inclusive = false)
}