package com.example.makemytrip.expandablecard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AirportCab() {
    Column (modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center
        ){

        Text(text = "Airport Cab")

    }
}