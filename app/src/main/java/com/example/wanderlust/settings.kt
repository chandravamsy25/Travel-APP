package com.example.wanderlust
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun SettingsScreen(navController: NavController) {
    var notificationEnabled by remember { mutableStateOf(true) }
    var selectedLanguage by remember { mutableStateOf("English") }
    var selectedCurrency by remember { mutableStateOf("USD") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Heading
        Text(
            text = "Settings",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // User Profile
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    // Handle click action for navigating to personal details screen
                }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                // User Image (Replace with your image loading logic)
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary)
                ) {
                    // Image loading logic or placeholder
                    Image(
                        painter = painterResource(id = R.drawable.profile_image), // Replace with your image resource
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }


                Spacer(modifier = Modifier.width(8.dp))

                // User Name and Edit Details
                Column {
                    Text(text = "Walter White", style = MaterialTheme.typography.bodyMedium)
                    Text(
                        text = "Edit personal details",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.clickable {
                            // Handle click action for editing personal details
                        }
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                // Right Arrow
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        // Dark Mode Switch
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    // Handle click action for navigating to dark mode settings
                }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_night),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary)
                )


                Spacer(modifier = Modifier.width(8.dp))

                Text(text = "Dark Mode", style = MaterialTheme.typography.bodyMedium)

                Spacer(modifier = Modifier.weight(1f))
                Spacer(modifier = Modifier.width(60.dp))

                // Switch for Dark Mode
                Switch(
                    checked = false, // Replace with your logic for dark mode state
                    onCheckedChange = {
                        // Handle dark mode switch change
                    },
                    modifier = Modifier.padding(2.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))



            }
        }

        // Change Password
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    // Handle click action for navigating to change password screen
                }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(text = "Change Password", style = MaterialTheme.typography.bodyMedium)

                Spacer(modifier = Modifier.weight(1f))

                // Right Arrow
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            }
        }

        // Other Settings
        listOf("Notification", "Language", "Currency", "Logout").forEach { setting ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        // Handle click action for each setting
                    }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(text = setting, style = MaterialTheme.typography.bodyMedium)

                    Spacer(modifier = Modifier.weight(1f))

                    // Right Arrow
                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    // Replace with your theme or use the default theme
    MaterialTheme {
        SettingsScreen(navController = rememberNavController())
    }
}


