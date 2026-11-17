package com.example.feature.screens.recipe_screen_widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.domain.model.recipie.Recipe
import com.example.feature.R
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
        colors = CardDefaults.cardColors(Color(0xFF3E7B58).copy(alpha = 0.9f)),
        modifier = modifier
            .size(40.dp)) {
        Box(modifier = Modifier
            .fillMaxSize()
            .align(Alignment.End),
            contentAlignment = Alignment.TopCenter) {
            Image(
                modifier = Modifier
                    .padding(all = 12.dp),
                painter = painterResource(R.drawable.save_white),
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
fun RecipeInfoCard(recipe : Recipe){
    Card(
        modifier = Modifier
            .fillMaxSize(),
        colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.surface,
    )) {
        Column(modifier = Modifier
            .padding(start = 18.dp, top = 15.dp, end = 18.dp)
        ) {
            RecipeHeader(recipe)
            Text(
                text = recipe.description,
                color = MaterialTheme.colorScheme.tertiary,
                fontFamily = InterFontFamily,
                fontSize = 12.sp
            )
            RecipeCookingInfoCard(recipe)
            IngridienrsInfoRow(recipe)
        }
    }
}

@Composable
fun RecipeHeader(recipe: Recipe){
    Row(modifier = Modifier.padding(bottom = 5.dp)){
        Text(
            modifier = Modifier.weight(1f),
            text = recipe.title,
            fontFamily = InterFontFamily,
            fontSize = 27.sp,
            maxLines = 2
        )
//        Spacer(modifier = Modifier.weight(1f))
        Image(
            modifier = Modifier
                .padding(all = 5.dp)
                .align(Alignment.Bottom),
            painter = painterResource(R.drawable.star_icon),
            contentDescription = null
        )
        Text(
            modifier = Modifier.align(Alignment.Bottom),
            text = recipe.rating.toString(),
            fontFamily = InterFontFamily,
            fontSize = 12.sp,
        )
    }
}

@Composable
fun RecipeCookingInfoCard(recipe: Recipe){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp, bottomEnd = 16.dp, bottomStart = 16.dp),
        modifier = Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth()
            .height(59.dp)
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth().padding(horizontal = 26.dp), verticalAlignment = Alignment.CenterVertically) {

            CookingTime(recipe)
            CookingDifficulty(recipe)
            PortionAmount(recipe)
            Calories(recipe)

        }
    }
}

//@Preview
//@Composable
//fun RecipeCookingInfoCardPreview() {
//    RecipeCookingInfoCard(
//        Recipe(
//            "test",
//            "test",
//            30,
//            "hard",
//            true,
//            false,
//            emptyList(),
//            "",
//            5.0,
//            "test",
//            "test",
//            4,
//            100
//
//        )
//    )
//}

@Composable
fun CookingTime(recipe: Recipe){
    Column(verticalArrangement = Arrangement.spacedBy(2.dp), horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.wrapContentHeight()) {
        Image(
            painter = painterResource(R.drawable.timer),
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.time_cooking, recipe.cookingTimeMinutes),
            fontFamily = InterFontFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 10.sp,
            lineHeight = 10.sp
        )

        Text(text = "Время",
            color = MaterialTheme.colorScheme.tertiary,
            fontFamily = InterFontFamily,
            fontSize = 8.sp,
            lineHeight = 10.sp
        )
    }
}

@Composable
fun CookingDifficulty(recipe: Recipe){
    Box(modifier = Modifier
        .padding(vertical = 9.dp)) {
        Column(verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxHeight()) {
            Image(
                modifier = Modifier
                    .padding(vertical = 1.dp, horizontal = 12.dp),
                painter = painterResource(R.drawable.cooking_hat),
                contentDescription = null
            )
            Text(
                text = recipe.difficulty,
                fontFamily = InterFontFamily,
                fontSize = 10.sp,
                lineHeight = 10.sp
            )
            Text(text = "Сложность",
                color = MaterialTheme.colorScheme.tertiary,
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 8.sp,
                lineHeight = 10.sp
            )
        }
    }
}

@Composable
fun PortionAmount(recipe: Recipe){
    Box(modifier = Modifier
        .padding(vertical = 9.dp)) {
        Column(verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxHeight()) {
        Image(
                modifier = Modifier
                    .padding(vertical = 1.dp, horizontal = 12.dp),
                painter = painterResource(R.drawable.people_amoint),
                contentDescription = null
            )
            Text(
                text = recipe.servings.toString(),
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp,
                lineHeight = 10.sp
            )
            Text(text = "Порции",
                color = MaterialTheme.colorScheme.tertiary,
                fontFamily = InterFontFamily,
                fontSize = 8.sp,
                lineHeight = 10.sp
            )
        }
    }
}

@Composable
fun Calories(recipe: Recipe){
    Box(modifier = Modifier
        .padding(vertical = 9.dp)) {
        Column(verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxHeight()) {
        Image(
                modifier = Modifier
                    .padding(vertical = 1.dp, horizontal = 12.dp),
                painter = painterResource(R.drawable.calories),
                contentDescription = null
            )
            Text(
                text = recipe.calories.toString(),
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp,
                lineHeight = 10.sp
            )
            Text(text = "ккал",
                color = MaterialTheme.colorScheme.tertiary,
                fontFamily = InterFontFamily,
                fontSize = 8.sp,
                lineHeight = 10.sp
            )
        }
    }
}

@Composable
fun IngridienrsInfoRow(recipe: Recipe){
    Row() {
        Text(
            text = "Ингредиенты",
            fontFamily = InterFontFamily,
            fontSize = 20.sp,
        )
        Spacer(modifier = Modifier.weight(1f))
        ServingsAmount(recipe)
    }
}

@Composable
fun ServingsAmount(recipe: Recipe){
    Text(
        text = "-",
        color = MaterialTheme.colorScheme.secondary,
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    )
    Text(modifier = Modifier.padding(horizontal = 7.dp),
        text = pluralStringResource(R.plurals.servings_amount, recipe.servings, recipe.servings),
        color = MaterialTheme.colorScheme.secondary,
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.Bold,
    )
    Text(
        text = "+",
        color = MaterialTheme.colorScheme.secondary,
        fontFamily = InterFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    )
}