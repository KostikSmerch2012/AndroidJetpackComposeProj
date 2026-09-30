package com.example.moyakuhnya.screens.vidgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moyakuhnya.R
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
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .fillMaxSize()
    )
}

@Composable
fun BoxScope.iconTopStart() {
    Card(
        shape = RoundedCornerShape(100),
        modifier = Modifier
            .align(Alignment.TopStart)
            .padding(horizontal = 16.dp, vertical = 16.dp),
        colors = CardDefaults.cardColors(Color(0xFFFFFCF7))
    ) {
        Text(modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 6.dp),
        text = "ВЫБОР ДНЯ",
        fontFamily = FontFamily(Font(R.font.inter_normal, FontWeight(400))),
        fontSize = 10.sp,
            color = Color(0xFF3E7B58)
    )
    }
}
