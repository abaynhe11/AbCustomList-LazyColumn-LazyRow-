package com.google.firebase.quickstart.auth.abcustomlistlazycolumnlazyrow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.quickstart.auth.abcustomlistlazycolumnlazyrow.ui.theme.AbCustomListLazyColumnLazyRowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                    AbCustomList()
        }
    }
}

private val fruitsList = mutableListOf<FruitModel>()

@Composable
fun ListRow(model: FruitModel) {
    Row(

        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .background(color = Color.Blue)
    ) {
        Image(
            painter = painterResource(id = model.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .padding(5.dp)
        )
        Text(
            text = model.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )
    }
}


@Composable
fun AbCustomList()
{
    fruitsList.add(FruitModel("Apple", R.drawable.ic_baseline_food_bank_24))
    fruitsList.add(FruitModel("Orange", R.drawable.ic_baseline_food_bank_24))
    fruitsList.add(FruitModel("Banana", R.drawable.ic_baseline_food_bank_24))
    fruitsList.add(FruitModel("Strawberry", R.drawable.ic_baseline_food_bank_24))
    fruitsList.add(FruitModel("Mango", R.drawable.ic_baseline_food_bank_24))


    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        items(fruitsList) { model ->
            ListRow(model = model)
        }
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun defaultPreview()
{
    AbCustomList()
}