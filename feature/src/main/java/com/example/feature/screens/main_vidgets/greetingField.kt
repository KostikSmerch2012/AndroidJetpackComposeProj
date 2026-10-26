package com.example.feature.screens.main_vidgets

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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.domain.profile.User
import com.example.feature.R

@Composable
fun GreetingField(user: User){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .systemBarsPadding()
            .padding(start = 16.dp, top = 10.dp, end = 16.dp)
            .fillMaxWidth().wrapContentHeight()
    ) {
//        greetingText()
        Column() {
            Text(text = stringResource(R.string.greeting_field, user.name).uppercase(),
            fontFamily = FontFamily(Font(R.font.inter_normal, FontWeight(400))),
            fontSize = 11.sp,
            color = Color(0xFF3E7B58))
            Text(text = stringResource(R.string.what_cook),
                fontFamily = FontFamily(Font(R.font.inter_normal, FontWeight(400))),
                fontSize = 24.sp)
        }
            greetingProfileImage(user)

    }
}


//@Composable
//fun greetingText(user: User){
//    Column() {
//        Text(text = stringResource(R.string.greeting_field, user.name),
//            fontFamily = FontFamily(Font(R.font.inter_normal, FontWeight(400))),
//            fontSize = 11.sp,
//            color = Color(0xFF3E7B58))
//        Text(text = stringResource(R.string.what_cook),
//            fontFamily = FontFamily(Font(R.font.inter_normal, FontWeight(400))),
//            fontSize = 24.sp)
//    }
//}

@Composable
fun greetingProfileImage(user: User){
    Row(
        horizontalArrangement = Arrangement.End
    ) {
        AsyncImage(
            model = user.avatarUrl,
            contentDescription = null,
            placeholder = painterResource(R.drawable.avatar),
            error = painterResource(R.drawable.avatar),
            modifier = Modifier
                .size(size = 40.dp)
                .clip(CircleShape)
        )

    }
}
