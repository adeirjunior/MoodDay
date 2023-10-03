package me.adeir.moodday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import me.adeir.moodday.ui.theme.MoodDayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoodDayTheme {
                MoodDayApp()
            }
        }
    }
}





