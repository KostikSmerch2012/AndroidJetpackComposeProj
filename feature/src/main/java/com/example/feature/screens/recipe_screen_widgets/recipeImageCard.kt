package com.example.feature.screens.recipe_screen_widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.domain.model.recipie.Ingredients
import com.example.domain.model.recipie.Recipe
import com.example.feature.R
import com.example.feature.screens.theme.InterFontFamily
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.LineHeightStyle
import com.example.domain.model.recipie.Steps


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
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop

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
        //        .fillMaxSize(),ПУ ПУ ПУ - ТЫ В LazyColumn ебашишь fillmaxsize = fillmaxheight - а откуда лейзиколумну считать область прокрутки если у тебя fill max size, если высота не ограничена мля  Vertically scrollable component was measured with an infinity maximum height constraints, which is disallowed
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.surface,
    )) {
        Column(modifier = Modifier
            .padding(start = 18.dp, top = 15.dp, end = 18.dp)
        ) {
            //смотри все дочерние элементы чтобы не было fillMaxHeight ( size )
            RecipeHeader(recipe)
            Text(
                text = recipe.description,
                color = MaterialTheme.colorScheme.tertiary,
                fontFamily = InterFontFamily,
                fontSize = 12.sp,
                lineHeight = 16.sp
            )
            RecipeCookingInfoCard(recipe)
            IngridienrsInfoRow(recipe)
            Spacer(Modifier.height(9.dp))
            RecipeGridIngredients(recipe.ingredients.orEmpty())
        }
    }
    CookingTutorial(recipe.steps.orEmpty())
}

@Composable
fun RecipeHeader(recipe: Recipe){
    Row(modifier = Modifier.padding(bottom = 5.dp)){
        Text(
            modifier = Modifier.weight(1f),
            text = recipe.title,
            fontFamily = InterFontFamily,
            fontSize = 27.sp,
            maxLines = 2,
            color = MaterialTheme.colorScheme.primary
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
            color = MaterialTheme.colorScheme.primary
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
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 26.dp), verticalAlignment = Alignment.CenterVertically) {

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
            lineHeight = 10.sp,
            color = MaterialTheme.colorScheme.primary
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
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp,
                lineHeight = 10.sp,
                color = MaterialTheme.colorScheme.primary
            )
            Text(text = "Сложность",
                color = MaterialTheme.colorScheme.tertiary,
                fontFamily = InterFontFamily,
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
                lineHeight = 10.sp,
                color = MaterialTheme.colorScheme.primary
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
                lineHeight = 10.sp,
                color = MaterialTheme.colorScheme.primary
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
    Row(modifier = Modifier.padding(top = 12.dp)) {
        Text(
            text = "Ингредиенты",
            fontFamily = InterFontFamily,
            fontSize = 20.sp,
            color = MaterialTheme.colorScheme.primary
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


@Composable
fun RecipeGridIngredients(ingredients: List<Ingredients>){
    val rows = (ingredients.size + 1) / 2
    val height = 20.dp * rows + 7.dp * (rows - 1).coerceAtLeast(0)

    LazyVerticalStaggeredGrid(
        modifier = Modifier.height(height),
        userScrollEnabled = false,
        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 7.dp,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(ingredients) { item -> RecipeGridContent(item) }
    }
//    LazyVerticalStaggeredGrid(
//        columns = StaggeredGridCells.Fixed(2),
//        verticalItemSpacing = 7.dp,
//        horizontalArrangement = Arrangement.spacedBy(12.dp),
//    content =  {
//        items(ingredients){ item: Ingredients ->
//            RecipeGridContent(item)
//        }
//    }
//    )
}

@Composable
fun RecipeGridContent(ingredients: Ingredients){
   Row(
       verticalAlignment = Alignment.CenterVertically
       ){
        Image(
            painter = painterResource(R.drawable.checkbox),
            contentDescription = null
        )
       Spacer(Modifier.width(10.dp))
        Text(
            text = ingredients.name,
            fontFamily = InterFontFamily,
            fontSize = 10.sp,
            lineHeight = 12.sp,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(Modifier.weight(1f))
       Text(
           text = stringResource(R.string.recipe_item_units, ingredients.amount, ingredients.unit),
           color = MaterialTheme.colorScheme.tertiary,
           lineHeight = 12.sp,
           fontSize = 9.sp
       )
    }
}

@Composable
fun CookingTutorial(steps: List<Steps>){
    Column(modifier = Modifier.padding(vertical = 10.dp, horizontal = 18.dp)){
        Text(
            text = "Приготовление",
            fontFamily = InterFontFamily,
            fontSize = 20.sp,
            lineHeight = 24.sp,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(9.dp))
        Column(verticalArrangement = Arrangement.spacedBy(9.dp)) {
            steps.forEach { CookingTutorialSteps(it) }
        }
    }
}

@Composable
fun CookingTutorialSteps(steps: Steps){
    Row(horizontalArrangement = Arrangement.SpaceBetween){
        Card(
            shape = CircleShape,
            modifier = Modifier
                .size(28.dp),
            colors = CardDefaults.cardColors(Color(0xFF3E7B58))
        ) {
            val label = if (steps.number < 10.0) "0${stringResource(R.string.step_number, steps.number)}" else steps.number.toString()
            Box(modifier = Modifier
                .fillMaxSize(),
                contentAlignment = Alignment.Center){
                Text(
                    modifier = Modifier.padding(9.dp),
                    text = label,
                    fontFamily = InterFontFamily,
                    lineHeight = 11.sp,
                    fontSize = 9.sp,
                    color = MaterialTheme.colorScheme.onTertiary
                )
            }
        }
            Spacer(Modifier.width(10.dp))
            Column() {
                Text(
                    text = steps.title,
                    fontFamily = InterFontFamily,
                    lineHeight = 13.sp,
                    fontSize = 11.sp,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = steps.description,
                    fontFamily = InterFontFamily,
                    lineHeight = 12.sp,
                    fontSize = 9.sp,
                    color = MaterialTheme.colorScheme.tertiary
                )
        }
    }
}