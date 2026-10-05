package com.example.feature.screens.main_vidgets

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.feature.screens.theme.InterFontFamily

@Composable
fun BoxScope.CardTextVidget(){
    Column(modifier = Modifier
        .align(Alignment.BottomStart)
        .padding(all = 16.dp)) {
        NameText()
        DescriptionText()
    }
}

@Composable
fun NameText(){ //переписать под динамическое изменение названия
    Text(
        color = Color(0xFFFFFFFF),
        text = "Тёплая шакшука с фетой",
        fontFamily = InterFontFamily,
        fontSize = 24.sp
    )
}

@Composable
fun DescriptionText(){ //Переписать под динамическое время готовки и рейтинг
    Text(
        color = Color(0xFFFFFFFF),
        text = "25 мин · легко",
        fontFamily = InterFontFamily,
        fontSize = 12.sp
    )
}
