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
import com.sample.prak6.view.HomePage
import com.sample.prak6.FormDataDiri

enum class navigasi {
    Home,
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
            startDestination = navigasi.Home.name,
            modifier = modifier.padding(isiRuang)
        ) {
            composable(route = navigasi.Home.name) {
                HomePage(
                    onNavigateToForm = {
                        navController.navigate(navigasi.Formulir.name)
                    }
                )
            }
            composable(route = navigasi.Formulir.name) {
                FormDataDiri()
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

