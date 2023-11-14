package com.example.wanderlust

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class VisitedPlace(
    val placeName: String,
    val dateVisited: LocalDate,
    val imageResource: Int
)
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun VisitedPlaceItem(visitedPlace: VisitedPlace) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {},
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),

    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)

        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(visitedPlace.imageResource),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)


                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Image(
                        painter = painterResource(visitedPlace.imageResource),
                        contentDescription = null,
                        modifier = Modifier
                            .weight(1f)
                            .height(200.dp)
                            .clip(MaterialTheme.shapes.medium)
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = visitedPlace.placeName,
                        style = MaterialTheme.typography.headlineLarge,
                        fontSize = 36.sp,

                        fontFamily = FontFamily.Cursive,
                        fontWeight = FontWeight.Bold,

                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = visitedPlace.dateVisited.format(DateTimeFormatter.ISO_DATE),
                        style = MaterialTheme.typography.headlineMedium,
                        fontSize = 20.sp,
                        color = Color.Gray,
                    )
                }
            }
        }
    }
}
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun VisitedPlaces(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Gallery",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 25.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("ProfileScreen") }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
                actions = {
                    IconButton(onClick = { /* Handle search action */ }) {
                        Icon(imageVector = Icons.Default.Image, contentDescription = null)
                    }
                }
            )
            Spacer(modifier = Modifier.height(35.dp))
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                VisitedPlacesList(visitedPlaces = mockVisitedPlaces)
                Spacer(modifier = Modifier.height(35.dp))
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

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun VisitedPlacesList(visitedPlaces: List<VisitedPlace>) {
    LazyColumn {
        items(visitedPlaces) { place ->
            VisitedPlaceItem(visitedPlace = place)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
private val mockVisitedPlaces = listOf(
    VisitedPlace("Kerala", LocalDate.parse("2023-01-01"), R.drawable.kerala),
    VisitedPlace("Assam", LocalDate.parse("2023-02-15"), R.drawable.assam),
    VisitedPlace("Jaipur", LocalDate.parse("2023-03-25"), R.drawable.jaipur),
    VisitedPlace("Rajasthan", LocalDate.parse("2022-05-07"), R.drawable.rajasthan),
    VisitedPlace("Shimla", LocalDate.parse("2022-07-01"), R.drawable.shimla),

)

