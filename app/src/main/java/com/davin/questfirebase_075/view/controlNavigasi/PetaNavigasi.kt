package com.davin.questfirebase_075.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.davin.questfirebase_075.view.DetailSiswaScreen
import com.davin.questfirebase_075.view.EditSiswaScreen
import com.davin.questfirebase_075.view.EntrySiswaScreen
import com.davin.questfirebase_075.view.HomeScreen
import com.davin.questfirebase_075.view.route.DestinasiDetail
import com.davin.questfirebase_075.view.route.DestinasiEdit
import com.davin.questfirebase_075.view.route.DestinasiEntry
import com.davin.questfirebase_075.view.route.DestinasiHome

@Composable
fun DataSiswaApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    HostNavigasi(navController = navController)
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                navigateToItemUpdate = {
                    // Mengirim ID sebagai bagian dari Route
                    navController.navigate("${DestinasiDetail.route}/$it")
                }
            )
        }
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(
                navigateBack = { navController.navigate(DestinasiHome.route) }
            )
        }
        composable(
            DestinasiDetail.routeWithArgs,
            arguments = listOf(navArgument(DestinasiDetail.itemIdArg) {
                type = NavType.StringType // ID diterima sebagai String
            })
        ) {
            DetailSiswaScreen(
                // Mengirim ID ke layar Edit
                navigateToEditItem = { navController.navigate("${DestinasiEdit.route}/$it") },
                navigateBack = { navController.navigate(DestinasiHome.route) }
            )
        }
        composable(
            DestinasiEdit.routeWithArgs,
            arguments = listOf(navArgument(DestinasiEdit.itemIdArg) {
                type = NavType.StringType
            })
        ) {
            EditSiswaScreen(
                navigateBack = { navController.navigate(DestinasiHome.route) },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}