package com.example.wanderlust

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavHostController) {
    val context = LocalContext.current
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var firebaseAuth = FirebaseAuth.getInstance()
    val cardBackgroundColor = Color(255, 255, 255, 150)
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = com.example.wanderlust.R.drawable.img_4),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable {},
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = cardBackgroundColor)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Welcome Back",
                    fontSize = 45.sp,
                    style = MaterialTheme.typography.headlineLarge.copy(),
                    fontFamily = FontFamily.SansSerif,

                    color = Color(0xFF4169e1),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Login to your account",
                    fontSize = 15.sp,

                    style = MaterialTheme.typography.headlineLarge.copy(),
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = username,
                    onValueChange = { it -> username = it },
                    label = { Text(text = "Email ID",color = Color(0xFF1e90ff),fontWeight = FontWeight.Bold,fontSize = 15.sp,
                        style = TextStyle(fontFamily = FontFamily.SansSerif))
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "User Icon",
                            tint = Color(0xFF6495ed)
                        )
                    },
                    modifier = Modifier
                        .padding(10.dp)
                        .width(280.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = Color.Black,
                        focusedLeadingIconColor = Color(0xFF1e90ff),
                        focusedBorderColor=  Color(0xFF6495ed),
                        unfocusedBorderColor = Color(0xFF6495ed),

                        )

                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(

                    value = password,
                    onValueChange = { password = it },
                    label = { Text(text = "Password", color = Color(0xFF1e90ff),fontWeight = FontWeight.Bold,fontSize = 15.sp,
                        style = TextStyle(fontFamily = FontFamily.SansSerif))
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "Password Icon",
                            tint = Color(0xFF6495ed)
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                        }

                    ),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = Color.Black,
                        focusedLeadingIconColor = Color(0xFF1e90ff),
                        focusedBorderColor=  Color(0xFF6495ed),
                        unfocusedBorderColor = Color(0xFF6495ed),
                    ),
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                contentDescription = "Toggle password visibility"
                            )
                        }
                    },
                    modifier = Modifier
                        .padding(10.dp)
                        .width(280.dp)
                )
                Spacer(modifier = Modifier.height(50.dp))

                Button(
                    modifier = Modifier
                        .width(200.dp)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors( Color(0xFF4169e1),
                        contentColor = Color.White),
                    onClick = {
                        if (username.isNotEmpty() && password.isNotEmpty()) {
                            FirebaseAuth.getInstance().signInWithEmailAndPassword(username, password)
                                .addOnCompleteListener { task ->
                                    if (task.isSuccessful) {
                                        navController.navigate("HomeScreen")
                                    } else {
                                        Toast.makeText(context, "Authentication failed.", Toast.LENGTH_SHORT).show()
                                    }
                                }
                        } else {
                            Toast.makeText(context, "Please fill in both fields.", Toast.LENGTH_SHORT).show()
                        }
                    },
                ) {

                    Text(
                        "Login",
                        fontSize = 20.sp
                    )
                    Spacer(modifier = Modifier.width(10.dp))


                }
                Spacer(modifier = Modifier.height(20.dp))

                val signUpText = buildAnnotatedString {
                    append("Don't have an account? ")
                    pushStringAnnotation(
                        tag = "SignUp",
                        annotation = "SignUp"
                    )
                    withStyle(
                        style = SpanStyle(
                            color = Color.Blue,
                            textDecoration = TextDecoration.Underline
                        )
                    ) {
                        append("Sign Up")
                    }
                    pop()
                }

                val signUpClicked = remember { mutableStateOf(false) }

                ClickableText(
                    text = signUpText,
                    onClick = { offset ->
                        signUpText.getStringAnnotations(
                            tag = "SignUp", start = offset, end = offset
                        ).firstOrNull()?.let {
                            signUpClicked.value = !signUpClicked.value
                            // Add navigation logic here
                            if (signUpClicked.value) {
                                navController.navigate("SignUp")

                            }
                        }
                    }
                )

            }
        }
    }
}




