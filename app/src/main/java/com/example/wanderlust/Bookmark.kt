package com.example.wanderlust

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Bookmark(navController: NavController) {
    val bookmarkedPlaces = remember {
        mutableStateListOf(
            Place("Bangkok", "Thailand", R.drawable.bangkok,"Thailand’s capital, is a large city known for ornate shrines and vibrant street life.","4.8"),
            Place("Paris", "France", R.drawable.paris,"a cultural hub of art and romance.","4.3"),
            Place("Sydney", "Australia", R.drawable.sydney,"Coastal beauty with iconic harbor landmarks.","4.0") ,
            Place("Tokyo", "Japan", R.drawable.tokyo,"Modern city fusing technology and tradition.","4.2"),
        Place("New York", "USA", R.drawable.newyork," Bustling metropolis known for diversity.","4.0")

        )
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = " Bookmarked Places ",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black,
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("Search") }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.Black
                        )
                    }
                },
                    actions = {
                            Icon(
                                imageVector = Icons.Default.Bookmark,
                                contentDescription = "location",
                                tint = Color.Unspecified
                            )
                },
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.height(56.dp))
                for (place in bookmarkedPlaces) {
                    BookmarkItem(place) {
                        bookmarkedPlaces.remove(place)
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
@Composable
fun BookmarkItem(place: Place, onRemove: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {},
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)

        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                ) {
                    Image(
                        painter = painterResource(id = place.image),
                        contentDescription = null,
                        modifier = Modifier
                            .size(140.dp)
                            .clip(MaterialTheme.shapes.medium),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Column {
                        Text(
                            text = place.name,

                            style = TextStyle(
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                            )
                        )
                        Text(
                            text = place.description,

                            style = TextStyle(
                                fontSize = 12.sp,

                                color = Color.Gray,
                            )
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Row {
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = "location",
                                tint = Color(0xFFFFA500)

                            )
                            Text(
                                text = place.review, style = MaterialTheme.typography.bodyMedium,
                                fontSize = 15.sp,

                                color = Color.Black
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Icon(
                                imageVector = Icons.Default.LocationOn,
                                contentDescription = "location",
                                tint = Color(0xFF6495ed)
                            )
                            Text(
                                text = place.country,
                                style = MaterialTheme.typography.bodyMedium,
                                fontSize = 15.sp,

                                color = Color(
                                    0xFF4169e1,

                                    )
                            )
                        }

                    }
                }
            }
            IconButton(
                onClick = { onRemove() },
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.TopEnd)
            ) {
                Icon(
                    imageVector = Icons.Default.Clear,
                    contentDescription = "location",
                    tint = Color.Unspecified
                )
            }
        }
    }
}
data class Place(val name: String, val country: String, val image: Int,val description: String,
                 val review: String)

