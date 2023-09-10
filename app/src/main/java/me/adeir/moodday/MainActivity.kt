package me.adeir.moodday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.adeir.moodday.ui.theme.MoodDayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoodDayTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Route.screenOne
                    ) {
                        composable(route = Route.screenOne) {
                            ScreenOne (
                                navigateToScreenTwo = {
                                    navController.navigate(Route.screenTwo)
                                }
                            )
                        }
                        composable(route = Route.screenTwo) {
                            ScreenTwo (
                                navigateToScreenOne = {
                                    navController.navigate(Route.screenOne)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

object Route {
    const val screenOne = "screenOne"
    const val screenTwo = "screenTwo"
}

@Composable
fun ScreenOne(
    navigateToScreenTwo: () -> Unit
) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Screen 1")
        Button(onClick = navigateToScreenTwo) {
            Text("Navigate to Screen 2")
        }
    }
}

@Composable
fun ScreenTwo(
    navigateToScreenOne: () -> Unit
) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Screen 2")
        Button(onClick = navigateToScreenOne) {
            Text("Navigate to Screen 1")
        }
    }
}