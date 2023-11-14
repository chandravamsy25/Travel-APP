package com.example.wanderlust

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun VisitedState(navController: NavController) {
    val tokyoo = painterResource(R.drawable.tokyoo)
    val alaska = painterResource(R.drawable.alaska)
    val england = painterResource(R.drawable.england)
    val queensland = painterResource(R.drawable.queensland)
    Scaffold(
        content = {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Back button
            IconButton(onClick = { navController.navigate("ProfileScreen") }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier.size(30.dp)
                )
            }

            // Heading "Visited Country"
            Text(
                text = "Visited City",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dp) // Adjust the start padding as needed
            )
        }
        Spacer(modifier = Modifier.height(45.dp))
        // Card 1

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(90.dp))
                .clickable { /* Handle click event */ }
        ) {
            Row(
                modifier = Modifier.padding(30.dp)
            ) {
                Image(
                    modifier = Modifier
                        .size(50.dp),
                    painter = tokyoo,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(30.dp))
                Text(
                    text = "Tokyo",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold
                    ), // Make the text bold
                )


                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

        // Card 2
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(90.dp))
                .clickable { /* Handle click event */ }
        ) {
            Row(
                modifier = Modifier.padding(30.dp)
            ) {
                Image(
                    modifier = Modifier
                        .size(45.dp),
                    painter = queensland,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(30.dp))
                Text(
                    text = "Queensland      ",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold
                    ), // Make the text bold
                )


                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

        // Card 3
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(90.dp))
                .clickable { /* Handle click event */ }
        ) {
            Row(
                modifier = Modifier.padding(30.dp)
            ) {
                Image(
                    modifier = Modifier
                        .size(50.dp),
                    painter = england,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(30.dp))
                Text(
                    text = "England  ",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold
                    ), // Make the text bold
                )

                    }
                }
                Spacer(modifier = Modifier.height(16.dp))

                // Card 4
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(90.dp))

        ) {
            Row(
                modifier = Modifier.padding(30.dp)
            ) {
                Image(
                    modifier = Modifier
                        .size(50.dp),
                    painter = alaska,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(30.dp))
                Text(
                    text = "Alaska        ",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold
                    ), // Make the text bold
                )


                    }
                }
            }
        },
        bottomBar = {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 1.dp, bottom = 1.dp, start = 1.dp, end = 1.dp)
                    .background(Color.White),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(onClick = { navController.navigate("HomeScreen") }) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Home",
                        tint = Color.Unspecified
                    )
                }
                IconButton(onClick = { navController.navigate("Search") }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color.Unspecified
                    )
                }
                IconButton(onClick = { navController.navigate("Bookmark") }) {
                    Icon(
                        imageVector = Icons.Default.Bookmark,
                        contentDescription = "Bookmark",
                        tint = Color.Unspecified
                    )
                }
                IconButton(onClick = { navController.navigate("ProfileScreen") }) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Profile",
                        tint = Color.Unspecified
                    )

                }

            }
        }
    )
}
