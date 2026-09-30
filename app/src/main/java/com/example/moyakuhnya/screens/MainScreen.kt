package com.example.moyakuhnya.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.moyakuhnya.R
import com.example.moyakuhnya.screens.vidgets.RecepieCard
import com.example.moyakuhnya.screens.vidgets.RecepieSearchBar
import com.example.moyakuhnya.screens.vidgets.GreetingField

@Preview
@Composable
fun MainScreen(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(R.color.creamy))
    ) {
        GreetingField()
        RecepieSearchBar()
        RecepieCard()
    }
}

