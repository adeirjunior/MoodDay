package me.adeir.moodday.util

import androidx.navigation.NavHostController
import me.adeir.moodday.MoodDayScreen

fun goHome (navController: NavHostController){
    navController.popBackStack(route = MoodDayScreen.Home.name, inclusive = false, saveState = false)
}