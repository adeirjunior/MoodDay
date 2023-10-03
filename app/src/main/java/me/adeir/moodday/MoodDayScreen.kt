package me.adeir.moodday

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import me.adeir.moodday.ui.ScreenOne
import me.adeir.moodday.ui.ScreenTwo
import me.adeir.moodday.util.goHome

enum class MoodDayScreen(@StringRes val title: Int) {
    Home(title = R.string.app_name),
    ScreenTwo(title = R.string.screen_two)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoodDayAppBar(
    currenScreen: MoodDayScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currenScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoodDayApp(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MoodDayScreen.valueOf(
        backStackEntry?.destination?.route ?: MoodDayScreen.Home.name
    )

    Scaffold(
        topBar = {
            MoodDayAppBar(
                currenScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() })
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = MoodDayScreen.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = MoodDayScreen.Home.name) {
                ScreenOne(
                    navigateToScreenTwo = {
                        navController.navigate(MoodDayScreen.ScreenTwo.name)
                    }
                )
            }
            composable(route = MoodDayScreen.ScreenTwo.name) {
                ScreenTwo(
                    navigateToScreenOne = {
                        goHome(navController)
                    }
                )
            }
        }
    }

}