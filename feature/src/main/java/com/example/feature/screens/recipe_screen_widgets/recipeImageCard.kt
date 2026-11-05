package com.example.feature.screens.recipe_screen_widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.domain.model.recipie.Recipe
import com.example.domain.profile.User
import com.example.feature.R
import com.example.feature.screens.main_widgets.GreetingField
import com.example.feature.screens.main_widgets.iconKeyToDrawable
import com.example.feature.screens.theme.InterFontFamily


@Composable
fun RecipeCard(recipe: Recipe){
    Box(modifier = Modifier
        .height(248.dp)
        .fillMaxWidth()) {
        RecipeImageCard(recipe)

        RecipeButtonsRow()

        UserCooking(recipe)
    }
    RecipeInfoCard(recipe)
}

@Composable
fun RecipeButtonsRow(){
    Row(
        modifier = Modifier
            .padding(14.dp)
            .fillMaxWidth(),
    ){
        OnBackPressedButton()
        Spacer(Modifier.weight(1f))
        ShareRecipeButton()
        Spacer(Modifier.width(8.dp))
        SavedRecipeButton()
    }
}

@Composable
fun RecipeImageCard(recipe: Recipe){
    AsyncImage(
        model = recipe.imageUrl,
        contentDescription = null,
        modifier = Modifier.fillMaxWidth(),
        contentScale = ContentScale.FillWidth

    )
}

@Composable
fun OnBackPressedButton(){
    Card(
        shape = CircleShape,
        colors = CardDefaults.cardColors(Color(0xFFFFFFFF).copy(alpha = 0.9f)),
        modifier = Modifier
            .size(40.dp)) {
        Box(modifier = Modifier
            .fillMaxSize()
            .align(Alignment.Start),
            contentAlignment = Alignment.TopCenter) {
            Image(
                modifier = Modifier
                    .padding(all = 12.dp),
                painter = painterResource(R.drawable.back),
                contentDescription = null
            )
        }
    }
}

@Composable
fun ShareRecipeButton(){
    Card(
        shape = CircleShape,
        colors = CardDefaults.cardColors(Color(0xFFFFFFFF).copy(alpha = 0.9f)),
        modifier = Modifier
            .size(40.dp)) {
        Box(modifier = Modifier
            .fillMaxSize()
            .align(Alignment.End),
            contentAlignment = Alignment.TopCenter) {
            Image(
                modifier = Modifier
                    .padding(all = 12.dp),
                painter = painterResource(R.drawable.share),
                contentDescription = null
            )
        }
    }
}

@Composable
fun SavedRecipeButton(modifier: Modifier = Modifier){
    Card(
        shape = CircleShape,
        colors = CardDefaults.cardColors(Color(0xFFFFFFFF).copy(alpha = 0.9f)),
        modifier = modifier
            .size(40.dp)) {
        Box(modifier = Modifier
            .fillMaxSize()
            .align(Alignment.End),
            contentAlignment = Alignment.TopCenter) {
            Image(
                modifier = Modifier
                    .padding(all = 12.dp),
                painter = painterResource(R.drawable.save_image),
                contentDescription = null
            )
        }
    }
}

@Composable
fun UserCooking(recipe: Recipe) {
    Column(modifier = Modifier.fillMaxSize()){
        Spacer(modifier = Modifier.weight(1f))
        Card(
            shape = RoundedCornerShape(100),
            colors = CardDefaults.cardColors(Color(0xFFFFFCF7)),
            modifier = Modifier
                .padding(all = 16.dp)
        ) {
            Text(
                modifier = Modifier
                    .padding(horizontal = 10.dp),
                text = stringResource(
                    R.string.user_cooking,
                    recipe.tags.firstOrNull()?.uppercase() ?: "",
                    recipe.authorName
                ),
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Composable
fun RecipeInfoCard(recipe: Recipe){
    Card(
        modifier = Modifier
            .fillMaxSize(),
        colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.surface,
    )) {
        Column(modifier = Modifier
            .padding(start = 18.dp, top = 15.dp, end = 18.dp)
        ) {
            Row(){
                Text(
                    text = recipe.title,
                    fontFamily = InterFontFamily,
                    fontSize = 27.sp,
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    modifier = Modifier
                        .align(Alignment.Bottom),
                    painter = painterResource(R.drawable.star_icon),
                    contentDescription = null
                )
            }
        }
    }
}

