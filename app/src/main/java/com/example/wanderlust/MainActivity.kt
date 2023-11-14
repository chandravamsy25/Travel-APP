package com.example.wanderlust

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("SuspiciousIndentation")
@Composable
fun myapp(){
    var firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    val navController=rememberNavController()
    NavHost(
        navController=navController,
        startDestination="SplashScreen"
    ){
        composable("SplashScreen"){ SplashScreen(navController) }
        composable("SignUp"){ SignUp(navController)}
        composable("Login"){ Login(navController)}
        composable("HomeScreen"){ HomeScreen(navController) }
        composable("DetailScreen"){ DetailScreen(navController) }

        composable("Bookmark"){ Bookmark(navController) }
        composable("ProfileScreen"){ProfileScreen(navController)}
        composable("SettingsScreen"){SettingsScreen(navController)}


            composable("Search") {
                // Include the Search composable here
                Search(
                    pressBack = { navController.popBackStack() }, // Handle back press
                    navToPlaceDetail = { /* handle navigation to place detail */ },
                    navController

                )}
        composable("VisitedState"){VisitedState(navController)}
        composable("VisitedCountry"){ VisitedCountry(navController) }
        composable("VisitedPlaces"){VisitedPlaces(navController)}

    }
}

class MainActivity:ComponentActivity(){
    private lateinit var firebaseAuth: FirebaseAuth
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
        firebaseAuth = FirebaseAuth.getInstance()
        setContent{
            myapp()
        }
    }
}