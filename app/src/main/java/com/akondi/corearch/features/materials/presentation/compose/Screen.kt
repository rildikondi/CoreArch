package com.akondi.corearch.features.materials.presentation.compose

sealed class Screen (val route: String){
    object RootScreen: Screen("root_screen")
    object LoginScreen: Screen("login_screen")
    object MaterialsScreen: Screen("materials_screen")
    object MaterialDetailsScreen: Screen("material_details_screen")
}