package com.example.wanderlust

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
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
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wanderlust.R


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(navController: NavController) {
    val profileImage = painterResource(R.drawable.profile_picture)
    val cityImage = painterResource(R.drawable.cityscape)
    val countryImage = painterResource(R.drawable.countries)
    val locationPointerImage = painterResource(R.drawable.direction)
    val galleryImage = painterResource(R.drawable.gallery)
    val mapImage = painterResource(R.drawable.map)
    val worldImage = painterResource(R.drawable.worldmap)
    val settingsImage = painterResource(R.drawable.settings)
    val context = LocalContext.current
    Scaffold(
        content = {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                content = {
                    item {
                        Column(
                            modifier = Modifier
                                .padding(horizontal = 16.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                verticalAlignment = Alignment.Top


                            ) {
                                // Back button
                                IconButton(onClick = { navController.popBackStack() }) {
                                    Icon(
                                        imageVector = Icons.Default.ArrowBack,
                                        contentDescription = "Back",
                                        modifier = Modifier.size(30.dp)
                                    )
                                }

                                // Heading "Visited Country"
                                Text(
                                    text = "Profile",
                                    style = MaterialTheme.typography.headlineSmall,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(start = 8.dp) // Adjust the start padding as needed
                                )
                            }

                            // Profile picture
                            Box(
                                modifier = Modifier
                                    .size(100.dp)
                                    .align(Alignment.CenterHorizontally)
                                    .clip(CircleShape)
                            ) {
                                Image(
                                    painter = profileImage,
                                    contentDescription = null
                                )
                            }

                            // User name and profession
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(

                                text = "Walter White",
                                style = MaterialTheme.typography.headlineMedium,
                                modifier = Modifier.align(Alignment.CenterHorizontally)

                            )
                            Text(
                                text = "App Developer",
                                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold), // Make the text bold
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            )

                            // Visited cities, countries, and kilometers
                            Spacer(modifier = Modifier.height(16.dp))
                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    // City
                                    Column {
                                        Image(
                                            modifier = Modifier
                                                .size(95.dp),
                                            painter = cityImage,
                                            contentDescription = null
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(
                                            text = "City",
                                            style = MaterialTheme.typography.bodyLarge

                                        )
                                        Text(
                                            text = "8.5k",
                                            style = MaterialTheme.typography.bodyLarge
                                        )
                                    }

                                    // Country
                                    Column {
                                        Image(
                                            modifier = Modifier
                                                .size(95.dp),
                                            painter = countryImage,
                                            contentDescription = null
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(
                                            text = "Country",
                                            style = MaterialTheme.typography.bodyMedium.copy(
                                                fontWeight = FontWeight.Bold
                                            ), // Make the text bold
                                        )
                                        Text(
                                            text = "22+",
                                            style = MaterialTheme.typography.bodyMedium
                                        )
                                    }

                                    // Kilometers
                                    Column {
                                        Image(
                                            modifier = Modifier
                                                .size(95.dp),
                                            painter = locationPointerImage,
                                            contentDescription = null
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(

                                            text = "Kilometers",
                                            style = MaterialTheme.typography.bodyMedium
                                        )
                                        Text(
                                            text = "1000+",
                                            style = MaterialTheme.typography.bodyMedium
                                        )
                                    }
                                }
                            }

                            // Visited places cards
                            Spacer(modifier = Modifier.height(30.dp))

                            // Card 1

                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(90.dp))
                                    .clickable {
                                        navController.navigate("VisitedCountry")
                                    }
                            ) {
                                Row(
                                    modifier = Modifier.padding(30.dp)
                                ) {
                                    Image(
                                        modifier = Modifier
                                            .size(50.dp),
                                        painter = worldImage,
                                        contentDescription = null
                                    )
                                    Spacer(modifier = Modifier.width(30.dp))
                                    Text(
                                        text = "Visited Country",
                                        style = MaterialTheme.typography.headlineSmall.copy(
                                            fontWeight = FontWeight.Bold
                                        ),
                                    )
                                    Spacer(modifier = Modifier.width(20.dp))
                                    Icon(
                                        imageVector = Icons.Default.ArrowForward,
                                        contentDescription = null,
                                        modifier = Modifier.size(30.dp)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            // Card 2
                            Card(
                                modifier = Modifier
                                    .align(CenterHorizontally)
                                    .clip(RoundedCornerShape(90.dp))
                                    .clickable {
                                        navController.navigate("VisitedState")
                                    }
                            ) {
                                Row(
                                    modifier = Modifier.padding(30.dp)
                                ) {
                                    Image(
                                        modifier = Modifier
                                            .size(45.dp),
                                        painter = cityImage,
                                        contentDescription = null
                                    )
                                    Spacer(modifier = Modifier.width(30.dp))
                                    Text(
                                        text = "Visited City      ",
                                        style = MaterialTheme.typography.headlineSmall.copy(
                                            fontWeight = FontWeight.Bold
                                        ), // Make the text bold
                                    )
                                    Spacer(modifier = Modifier.width(30.dp))
                                    Icon(
                                        imageVector = Icons.Default.ArrowForward,
                                        contentDescription = null,
                                        modifier = Modifier.size(30.dp)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            // Card 3
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(90.dp))
                                    .clickable { navController.navigate("VisitedPlaces") }
                            ) {
                                Row(
                                    modifier = Modifier.padding(30.dp)
                                ) {
                                    Image(
                                        modifier = Modifier
                                            .size(50.dp),
                                        painter = galleryImage,
                                        contentDescription = null
                                    )
                                    Spacer(modifier = Modifier.width(30.dp))
                                    Text(
                                        text = "Photo Gallery  ",
                                        style = MaterialTheme.typography.headlineSmall.copy(
                                            fontWeight = FontWeight.Bold
                                        ), // Make the text bold
                                    )
                                    Spacer(modifier = Modifier.width(30.dp))
                                    Icon(
                                        imageVector = Icons.Default.ArrowForward,
                                        contentDescription = null,
                                        modifier = Modifier.size(30.dp)
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.height(16.dp))

                            // Card 4
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(90.dp))
                                    .clickable {
                                        context.startActivity(
                                            Intent(
                                                Intent.ACTION_VIEW,
                                                Uri.parse("https://maps.google.com/")
                                            )
                                        )
                                    }
                            ) {
                                Row(
                                    modifier = Modifier.padding(30.dp)
                                ) {
                                    Image(
                                        modifier = Modifier
                                            .size(50.dp),
                                        painter = mapImage,
                                        contentDescription = null
                                    )
                                    Spacer(modifier = Modifier.width(30.dp))
                                    Text(
                                        text = "Trips Map        ",
                                        style = MaterialTheme.typography.headlineSmall.copy(
                                            fontWeight = FontWeight.Bold
                                        ), // Make the text bold
                                    )
                                    Spacer(modifier = Modifier.width(38.dp))
                                    Icon(
                                        imageVector = Icons.Default.ArrowForward,
                                        contentDescription = null,
                                        modifier = Modifier.size(30.dp)
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        //card 5
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()

                                .clickable {
                                    navController.navigate("SettingsScreen")
                                }
                        ) {
                            Row(
                                modifier = Modifier.padding(10.dp)
                            ) {
                                Spacer(modifier = Modifier.width(40.dp))
                                Image(
                                    modifier = Modifier
                                        .size(45.dp),
                                    painter = settingsImage,
                                    contentDescription = null
                                )
                                Spacer(modifier = Modifier.width(30.dp))
                                Text(
                                    text = "Settings               ",
                                    style = MaterialTheme.typography.headlineSmall.copy(
                                        fontWeight = FontWeight.Bold
                                    ),
                                )
                                Spacer(modifier = Modifier.width(38.dp))
                                Icon(
                                    imageVector = Icons.Default.ArrowForward,
                                    contentDescription = null,
                                    modifier = Modifier.size(30.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(48.dp))
                    }

                }
            )
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


