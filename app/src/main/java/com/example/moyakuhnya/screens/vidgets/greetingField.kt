package com.example.moyakuhnya.screens.vidgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moyakuhnya.R

@Composable
fun GreetingField(){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .systemBarsPadding()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .height(44.dp)
            .fillMaxWidth()
    ) {
        greetingText()
        greetingProfileImage()
    }
}

@Composable
fun greetingText(){
    Column( modifier = Modifier
        .fillMaxHeight()) {
        Text(text = "ДОБРОЕ УТРО",
            fontFamily = FontFamily(Font(R.font.inter_normal, FontWeight(400))),
            fontSize = 11.sp,
            color = Color(0xFF3E7B58))
        Text(text = stringResource(R.string.what_cook),
            fontFamily = FontFamily(Font(R.font.inter_normal, FontWeight(400))),
            fontSize = 24.sp)
    }
}

@Composable
fun greetingProfileImage(){
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxHeight()
    ) {
        Image(
            painter = painterResource(R.drawable.avatar),
            contentDescription = null,
            modifier = Modifier
                .size(size = 40.dp)
                .clip(CircleShape)
        )

    }
}