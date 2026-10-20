package com.example.feature.screens.main_vidgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.domain.model.Category
import com.example.domain.model.recipie.Recipe
import com.example.domain.model.recipie.RecipeCategory
import com.example.feature.screens.theme.InterFontFamily
import com.example.feature.R

@Composable
fun lazyRecipeCard(recipe : Recipe){
    Column(
        Modifier.padding(
            start = 16.dp)
    ) {
        Card(
            shape = RoundedCornerShape(topStart = 30.dp, topEnd = 12.dp, bottomEnd = 30.dp, bottomStart = 12.dp),
            modifier = Modifier
                .padding(
                    top = 10.dp,
                    end = 12.dp)
                .width(173.dp)
                .height(88.dp)
        ) {
            Box(modifier = Modifier
                .fillMaxSize()
            ){
                CardImg(recipe)
                Foreground()
                recipe.tags.firstOrNull()?.let {
                    ScrollableTopStartCard(it)
                }
                iconTopend()
                Column(modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(all = 16.dp)) {
                }
            }
        }
        Spacer(Modifier.height(8.dp))

        Text(
            color = Color(0xFF29261F),
            text = recipe.title,
            fontFamily = InterFontFamily,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier
            .height(8.dp))
        Text(
            color = Color(0xFF756E62),
            text = stringResource(R.string.cooking_description, recipe.cookingTimeMinutes, recipe.rating),
//            text = recipe.cookingTimeMinutes.toString() + " мин" +  " · " + recipe.rating + " ★",
            fontFamily = InterFontFamily,
            fontSize = 11.sp
        )
    }

}

@Composable
fun CardImg(recipe: Recipe){
    AsyncImage(
        model = recipe.imageUrl,
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .fillMaxSize()
    )
}

@Composable
fun Foreground(){
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
fun BoxScope.ScrollableTopStartCard(text : String) {
    Card(
        shape = RoundedCornerShape(100),
        colors = CardDefaults.cardColors(Color(0xFFFFFCF7)),
        modifier = Modifier
            .padding(all = 16.dp)
            .align(Alignment.TopStart)
    ) {
        Text(modifier = Modifier
            .padding(horizontal = 9.dp, vertical = 5.dp),
            text = text,
            fontFamily = InterFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 10.sp,
            color = Color(0xFF3E7B58)
        )
    }
}

@Composable
fun BoxScope.iconTopend(){
    Card(
        shape = CircleShape,
        colors = CardDefaults.cardColors(Color(0xFFFFFFFFE8).copy(alpha = 0.9f)),
        modifier = Modifier
            .padding(vertical = 16.dp, horizontal = 16.dp)
            .align(Alignment.TopEnd)
            .size(30.dp)) {
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

@Composable
fun BoxScope.CategoriesCard(text: String){
    Text(
        text = text
    )

    Row(
        horizontalArrangement=Arrangement.SpaceBetween
    ){
        when {

        }
    }
}

@Composable
fun BoxScope.CategoryCardWidget(category: RecipeCategory){
    Card(
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 8.dp, bottomEnd = 16.dp, bottomStart = 8.dp),
        colors = CardDefaults.cardColors(Color(0xFFDDE9DC).copy(alpha = 0.9f))
        ) {
        Box(modifier = Modifier
            .fillMaxSize()) { }
        category.iconKey
    }
}