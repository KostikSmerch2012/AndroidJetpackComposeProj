package com.example.feature.screens.main_vidgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.feature.screens.theme.InterFontFamily
import com.example.feature.R

@Composable
fun RecepieCard(){
    Card(
        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 12.dp, bottomEnd = 30.dp, bottomStart = 12.dp),
        modifier = Modifier
        .padding(all = 16.dp)
        .fillMaxWidth()
        .height(244.dp)
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
        ){
            recCardImg()
            darkForeground()
            iconTopStart()
            iconTopEnd()
            CardTextVidget()
        }
    }
}

@Composable
fun recCardImg(){
    Image(
        painter = painterResource(R.drawable.recom_recepie),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .fillMaxSize()
        )
}

@Composable
fun darkForeground(){
    Image(
        painter = painterResource(R.drawable.darkgradient),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize()
    )
}

//@Composable
//fun BoxScope.TopRowIcons(){
//    Row(modifier = Modifier
//        .padding(all = 16.dp)
//        .align(Alignment.TopCenter),
//        horizontalArrangement = Arrangement.SpaceBetween
//    ) {
//        iconTopStart()
//        iconTopEnd()
//    }
//}

@Composable
fun BoxScope.iconTopStart() {
    Card(
        shape = RoundedCornerShape(100),
        colors = CardDefaults.cardColors(Color(0xFFFFFCF7)),
        modifier = Modifier
            .padding(all = 16.dp)
            .align(Alignment.TopStart)
    ) {
        Text(modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 6.dp),
        text = "ВЫБОР ДНЯ",
            fontFamily = InterFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 10.sp,
            color = Color(0xFF3E7B58)
    )
    }
}

@Composable
fun BoxScope.iconTopEnd(){
    Card(
        shape = CircleShape,
        colors = CardDefaults.cardColors(Color(0xFFFFFFFFE8).copy(alpha = 0.9f)),
        modifier = Modifier
            .padding(vertical = 16.dp, horizontal = 16.dp)
            .align(Alignment.TopEnd)
            .size(34.dp)) {
        Box(modifier = Modifier
            .fillMaxSize(),
            contentAlignment = Alignment.TopCenter) {
            Image(
                modifier = Modifier
                    .padding(all = 9.dp),
                painter = painterResource(R.drawable.save_image),
                contentDescription = null
            )
        }
    }
}
