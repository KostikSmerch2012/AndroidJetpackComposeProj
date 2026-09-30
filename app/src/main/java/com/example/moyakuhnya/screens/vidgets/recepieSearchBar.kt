package com.example.moyakuhnya.screens.vidgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.moyakuhnya.R

@Composable
fun RecepieSearchBar(){
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