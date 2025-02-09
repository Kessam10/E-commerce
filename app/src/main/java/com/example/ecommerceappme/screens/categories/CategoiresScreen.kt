package com.example.ecommerceappme.screens.categories

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ecommerceappme.R
import com.example.ecommerceappme.ui.theme.darkGray
//
//@Composable
//fun CategoryTitle(title: String, modifier: Modifier) {
//    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
//        Text(
//            title, style = MaterialTheme.typography.headlineSmall,
//            fontWeight = FontWeight.SemiBold,
//            modifier = modifier, color = darkGray
//        )
//
//        Text(
//            "view all",
//            style = MaterialTheme.typography.bodyMedium,
//            modifier = modifier,
//            color = darkGray
//        )
//    }
//}
//
@Composable
fun CategoriesScreen( modifier: Modifier =  Modifier) {
//    Column(modifier = modifier.height(400.dp)) {
//        CategoryTitle("Categories", Modifier.padding(20.dp))
//        LazyHorizontalGrid(rows = GridCells.Fixed(2)) {
//            items(categoriesViewModel.categories.size) { index ->
//                CategoryItem(
//                    categoriesViewModel.categories[index],
//                    Modifier
//                        .height(10.dp)
//                        .padding(10.dp)
//                )
//            }
//
//        }
//    }
}
//
//@Composable
//fun CategoryItem(category: Category, modifier: Modifier) {
//    Column(horizontalAlignment = Alignment.CenterHorizontally) {
//        CategoryImage(
//            modifier = Modifier
//                .padding(5.dp)
//                .width(100.dp)
//                .height(100.dp)
//                .clip(shape = CircleShape),
//            image = category.Image,
//            ""
//        )
//        CategoryDescription(
//            text = category.text,
//            modifier = Modifier.padding(5.dp)
//        )
//    }
//}
//
//@Composable
//fun CategoryDescription(modifier: Modifier, text: String) {
//    Text(text = text, modifier = modifier, color = darkGray)
//}
//
//@Composable
//fun CategoryImage(modifier: Modifier, image: Int, contentDescription: String) {
//    Image(
//        painterResource(image),
//        contentDescription,
//        modifier = modifier,
//        contentScale = ContentScale.Crop
//    )
//
//}
//
//
//@Preview(showBackground = true)
//@Composable
//fun CategoryItemPreview() {
//    CategoryItem(Category(R.drawable.girl, ""), modifier = Modifier.padding(10.dp))
//}
//
//@Preview(showBackground = true)
//@Composable
//fun ListPreview() {
//    CategoriesScreen(viewModel(), Modifier)
//}
//
//@Preview(showBackground = true)
//@Composable
//fun titlePreview() {
//    CategoryTitle("Categories", Modifier.padding(vertical = 10.dp))
//
//}