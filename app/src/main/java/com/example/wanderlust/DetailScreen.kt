package com.example.wanderlust

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailScreen(navController: NavController) {
    Scaffold(
        content = {
            LazyColumn() {

                item {
                    DetailHeader(navController)
                    TripInfoContent()

                }

                itemsIndexed(tripDays) { position, data ->
                    TripDayContent(data)


                }
                item {
                    Spacer(modifier = Modifier.navigationBarsPadding())
                    Spacer(modifier = Modifier.height(38.dp))
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
                    verticalAlignment = CenterVertically
                ) {
                    androidx.compose.material3.IconButton(onClick = { navController.navigate("HomeScreen") }) {
                        androidx.compose.material3.Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Home",
                            tint = Color.Unspecified
                        )
                    }
                    androidx.compose.material3.IconButton(onClick = { navController.navigate("Search") }) {
                        androidx.compose.material3.Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = Color.Unspecified
                        )
                    }
                    androidx.compose.material3.IconButton(onClick = { navController.navigate("Bookmark") }) {
                        androidx.compose.material3.Icon(
                            imageVector = Icons.Default.Bookmark,
                            contentDescription = "Bookmark",
                            tint = Color.Unspecified
                        )
                    }
                    androidx.compose.material3.IconButton(onClick = { navController.navigate("ProfileScreen") }) {
                        androidx.compose.material3.Icon(
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
fun DetailHeader(navController: NavController) {

    val detailHeaderImageUrl = R.drawable.thai_detail

    Box() {

        Image(
            painter = rememberCoilPainter(request = detailHeaderImageUrl),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        )


        Box(
            modifier = Modifier
                .statusBarsPadding()
                .fillMaxWidth()
        ) {

            TopButton(
                imageVector = Icons.Default.ArrowBack,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
            ) {
                navController.popBackStack()
            }

            TopButton(
                imageVector = Icons.Default.BookmarkBorder,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(16.dp)
            ) {

            }

        }


    }

}


@Composable
fun TripInfoContent() {

    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Row {

            LocationChip(text = "Bangkok, Thailand")
            Spacer(modifier = Modifier.weight(1f))

            Icon(
                imageVector = Icons.Default.Star, contentDescription = "",
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(12.dp)
                    .align(CenterVertically),
                tint = Color(0xFFFBC110)
            )

            Text(
                text = "4.8 (2.5k reviews)",
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp
            )

        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Exploring Thai Lifestyle!",
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.SemiBold,
            fontSize = 22.sp,
            lineHeight = 28.sp,
            letterSpacing = (-0.2).sp
        )

        Divider(
            color = Color(0xFFECECEE),
            modifier = Modifier.padding(8.dp)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            TripDataItem(
                imageVector = Icons.Default.CalendarToday,
                title = "Duration",
                subtitle = "5 days"
            )

            TripDataItem(
                imageVector = Icons.Default.Person,
                title = "Package For",
                subtitle = "2 Person"
            )

            TripDataItem(
                imageVector = Icons.Default.AttachMoney,
                title = "Apprx Cost",
                subtitle = "999"
            )

        }

        Divider(
            color = Color(0xFFECECEE),
            modifier = Modifier.padding(8.dp)
        )

    }

}

data class TripDayData(val title: String, val detail: String)

var tripDays = listOf(
    TripDayData(
        title = "THE BANGKOK CITY",
        detail = "Our journey through Thailand commences in Bangkok, the nation's capital and a primary entry point for international travelers. I suggest dedicating three days to this bustling city. This timeframe allows for acclimatization to the climate and potential time differences, as well as ample opportunity to explore the city and embark on a day trip to a nearby UNESCO World Heritage site, " +
                "which we'll delve into shortly. First, let's delve into the highlights of what awaits you in Bangkok."
    ),

    TripDayData(
        title = "KANCHANABURI",
        detail = "After exploring Bangkok, my next suggested destination is Kanchanaburi. While the town's name might not immediately resonate, the river it is situated on likely will—the renowned River Kwai, " +
                "celebrated for its bridge, a story immortalized in film."
    ),
    TripDayData(
        title = "AYUTTHAYA",
        detail = "After Kanchanaburi, I recommend venturing to one of Thailand's ancient capital cities. You have two primary options to consider: Ayutthaya and Sukhothai. " +
                "Given the brevity of this trip, choosing either one of these historical sites should be sufficient."
    ),
    TripDayData(
        title = "KHAO SOK",
        detail = "Next on our journey is a southward expedition to one of my favorite gems in Thailand – Khao Sok National Park. Surprisingly underrated, " +
                "this destination stands out uniquely from anywhere else I've explored in the country."
    ),
)


@Composable
fun TripDayContent(day: TripDayData) {

    Column(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    ) {

        Text(
            text = day.title.uppercase(),
            fontSize = 14.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = 0.75.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = day.detail,
            fontSize = 14.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Light,
            lineHeight = 18.sp
        )

    }

}


@Composable
fun TripDataItem(imageVector: ImageVector, title: String, subtitle: String) {

    Row {

        Icon(
            modifier = Modifier
                .padding(8.dp)
                .clip(CircleShape)
                .background(Color(0xFFF5F6FF))
                .size(32.dp)
                .padding(8.dp),

            imageVector = imageVector, contentDescription = ""
        )

        Column {

            Text(
                text = title,
                fontSize = 12.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.ExtraBold
            )

            Text(
                text = subtitle,
                fontSize = 14.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal
            )
        }

    }


}


@Composable
fun LocationChip(text: String) {

    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .background(Color(0xFFFBF110))
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {

        Icon(
            imageVector = Icons.Default.LocationOn,
            contentDescription = "",
            modifier = Modifier
                .padding(end = 4.dp)
                .size(12.dp)
                .align(CenterVertically)
        )

        Text(
            text = text,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            color = Color.Black
        )
    }

}

@Composable
fun TopButton(imageVector: ImageVector, modifier: Modifier, clickListener: () -> Unit) {


    Button(
        onClick = { clickListener() },
        border = BorderStroke(2.dp, Color(0xFFEAFBFF)),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xDDF6F9FF),
            contentColor = Color(0xFF3562D7)
        ),
        modifier = modifier.size(48.dp)

    ) {

        Icon(imageVector = imageVector, contentDescription = "")
    }
}