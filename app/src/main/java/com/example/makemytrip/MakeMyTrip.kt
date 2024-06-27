package com.example.makemytrip

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.makemytrip.expandablecard.HomeStaysVilla

@Composable
fun MakeMyTrip() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination =Routes.Home )
    {
        composable(Routes.Home){
            HomeScreen(navController)
        }
        composable(Routes.MyTrip){
            MyTrips()
        }
        composable(Routes.WhereToGo){
            WhereToGo()
        }
        composable(Routes.TripMoney){
            TripMoney()
        }
        composable(Routes.BeAhost){
           BeAHost()
        }

        //Navigation set for expandable Card

        composable(Routes.homeStaysVilla){
            HomeStaysVilla()
        }

    }
    
}