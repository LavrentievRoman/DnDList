package com.example.dnd_characterlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ui.screen.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "List of Character") {
        composable("List of Character") { ListOfCharactersScreen(navController) }
        composable("Creation Character") { NewCharacterCreationScreen(navController) }
        composable("Browse Character") { CharacterBrowseScreen(navController) }
        composable("Notes") { NotesScreen(navController) }
        composable("Throw Dice") { DiceScreen(navController) }
    }
}