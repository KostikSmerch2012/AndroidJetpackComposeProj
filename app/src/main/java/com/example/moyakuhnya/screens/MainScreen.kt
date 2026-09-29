package com.example.moyakuhnya.ui.theme.features

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moyakuhnya.R

@Composable
fun MainScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(R.color.creamy))
    ) {
        greetingField()
        recepieSearchBar()
    }
}

@Composable
fun greetingField(){
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
        Text(text = "Что приготовим?",
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
@Composable
fun recepieSearchBar(){
    TextField(
        shape = RoundedCornerShape(100),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFEAE7EF),
            unfocusedContainerColor = Color(0xFFEAE7EF),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        ),
        leadingIcon = {Image(painterResource(R.drawable.leading_icon), contentDescription = null)},
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 16.dp)
            .height(56.dp),
        state = rememberTextFieldState(),
        placeholder = {Text("Блюдо, продукт или кухня", color = Color(0xFF47464F))}
    )
}
