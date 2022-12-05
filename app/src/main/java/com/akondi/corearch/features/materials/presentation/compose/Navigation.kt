package com.akondi.corearch.features.materials.presentation.compose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.akondi.corearch.features.materials.domain.entities.materials.MaterialView


@Composable
fun Navigation(materials: List<MaterialView>) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MaterialsScreen.route) {
        composable(route = Screen.MaterialsScreen.route) {
            MaterialsScreen(navController = navController, materials)
        }
        composable(route = Screen.MaterialDetailsScreen.route) {
            val material =
                navController.previousBackStackEntry?.savedStateHandle?.get<MaterialView>("material")
            material.let {
                MaterialDetailsScreen(navController = navController, material)
            }
        }
    }
}