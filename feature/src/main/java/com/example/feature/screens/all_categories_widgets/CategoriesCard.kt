package com.example.feature.screens.all_categories_widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.model.Category
import com.example.feature.R
import com.example.feature.screens.main_widgets.iconKeyToDrawable
import com.example.feature.screens.recipe_screen_widgets.RecipeGridContent
import com.example.feature.screens.theme.InterFontFamily
import com.google.android.material.color.MaterialColors

@Composable
fun CategoriesCardMenue(category: List<Category>){
    Column(modifier = Modifier
        .padding(horizontal = 16.dp, vertical = 4.dp)){
        Spacer(Modifier.height(10.dp))
        AllCategoriesText()
        Spacer(Modifier.height(20.dp))
        FindCategory()
        Spacer(Modifier.height(20.dp))
        CategoryCards(category)
    }
}

@Composable
fun OnMainButton(
    onBackClick: () -> Unit
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
        .clickable{ onBackClick() }
            .padding(8.dp)){
        Image(
            modifier = Modifier.size(20.dp),
            painter = painterResource(R.drawable.back_arrow),
            contentDescription = null
        )
        Spacer(Modifier.width(8.dp))
        Box(modifier = Modifier.align(Alignment.CenterVertically)){
            Text(
                text = "На главную",
                fontFamily = InterFontFamily,
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.secondary,
                lineHeight = 15.sp
            )
        }
    }
}

@Composable
fun AllCategoriesText(){
    Text(
        text = "Все категории",
        fontFamily = InterFontFamily,
        fontSize = 24.sp,
        color = MaterialTheme.colorScheme.primary,
        lineHeight = 29.sp
    )
    Spacer(Modifier.height(8.dp))
    Text(
        text = "Что вам по настроению? Выберите своё.",
        fontFamily = InterFontFamily,
        fontSize = 12.sp,
        color = MaterialTheme.colorScheme.tertiary,
        lineHeight = 18.sp
    )
}

@Composable
fun FindCategory(){
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
            .height(56.dp),
        state = rememberTextFieldState(),
        placeholder = {Text("Найти категорию", color = Color(0xFF47464F))}
    )
}

@Composable
fun CategoryCards(category: List<Category>){
    val rows = (category.size + 1) / 2
    val height = 173.dp * rows + 12.dp * (rows - 1).coerceAtLeast(0)

    LazyVerticalStaggeredGrid(
        modifier = Modifier.height(height),
        userScrollEnabled = false,
        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 12.dp,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(category) { item -> CategoryCardsContent(item) }
    }
}

@Composable
fun CategoryCardsContent(category: Category){
    Card(
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 10.dp, bottomEnd = 24.dp, bottomStart = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Card(
                modifier = Modifier.size(48.dp),
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 8.dp, bottomEnd = 16.dp, bottomStart = 8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer)
            ){
                Box(modifier = Modifier
                    .fillMaxSize(),
                    contentAlignment = Alignment.Center){
                    Image(
                        painter = painterResource(iconKeys(category.iconKey ?: "")),
                        contentDescription = null
                    )
                }
            }
//            Spacer(Modifier.height(8.dp))
            Text(
                text = category.name,
                fontFamily = InterFontFamily,
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.primary,
                lineHeight = 19.sp
            )
            Spacer(Modifier.height(5.dp))
            Text(
                text = "Временная заглушка",
                fontFamily = InterFontFamily,
                fontSize = 10.sp,
                color = MaterialTheme.colorScheme.tertiary,
                lineHeight = 12.sp
            )
            Spacer(Modifier.height(36.dp))
        }
    }
}

fun iconKeys(iconKey : String?) : Int {
    return when (iconKey) {
        "bowl" -> R.drawable.bowl
        "timer" -> R.drawable.timer
        "sunrise" -> R.drawable.sunrise
        "croissant" -> R.drawable.croissant
        "leaf" -> R.drawable.leaf
        "plate" ->R.drawable.dish
        else -> R.drawable.dish
    }
}