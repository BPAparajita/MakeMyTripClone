package com.example.makemytrip.expandablecard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.makemytrip.R

@Composable
fun HomeStaysVilla() {
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.heritage), // replace with your image resource
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Homestays - Villas, Apts & more",
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "8000+ Apartments\nfor a comfy stay with modern amenities",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White.copy(alpha = 0.9f))
                        .padding(16.dp)
                ) {
                    Column {
                        var location by remember { mutableStateOf(TextFieldValue("Goa")) }
                        var checkInDate by remember { mutableStateOf(TextFieldValue("")) }
                        var checkOutDate by remember { mutableStateOf(TextFieldValue("")) }
                        var guests by remember { mutableStateOf(TextFieldValue("")) }

                        BasicTextField(
                            value = location,
                            onValueChange = { location = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White)
                                .padding(8.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        TextField(
                            value = checkInDate,
                            onValueChange = { checkInDate = it },
                            placeholder = { Text("Check-In") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White)
                                .padding(8.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        TextField(
                            value = checkOutDate,
                            onValueChange = { checkOutDate = it },
                            placeholder = { Text("Check-Out") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White)
                                .padding(8.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        TextField(
                            value = guests,
                            onValueChange = { guests = it },
                            placeholder = { Text("Guests") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White)
                                .padding(8.dp)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = { /* Handle search action */ },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("SEARCH")
                        }
                    }
                }
            }
        }
    }
}