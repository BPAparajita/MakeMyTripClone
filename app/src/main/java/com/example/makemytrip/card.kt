package com.example.makemytrip

import android.graphics.drawable.Icon
import android.graphics.drawable.PaintDrawable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

data class card(
    val title:String,
    val icon: Painter,
    val color: Color,

)