package com.tvmaze.challenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.tvmaze.challenge.presentation.navigation.RootNavGraph
import com.tvmaze.challenge.presentation.theme.ChallengeDecemberTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChallengeDecemberTheme {
                RootNavGraph(rememberNavController())
            }
        }
    }
}