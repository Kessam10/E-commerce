package com.example.ecommerceappme.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.ecommerceappme.R
import com.example.ecommerceappme.composables.Categories
import com.example.ecommerceappme.composables.imageSlider.ImageSlider
import com.example.ecommerceappme.composables.search.SearchBar


@Composable
fun HomeScreen(
//    categoriesList: List<CategoryItemEntity>,
    navigateToMyCart:()->Unit
) {
    val navHostController = rememberNavController()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
//            .padding(10.dp)
    ) {
        // Image item (route logo)
        item {
            Image(
                painter = painterResource(id = R.drawable.route_logo_2),
                contentDescription = "route logo image",
                modifier = Modifier
                    .size(65.dp),
                contentScale = ContentScale.Fit
            )
        }

        // SearchBar item
        item {
            SearchBar(navigateToMyCart = { navigateToMyCart() })
        }

        // ImageSlider item
        item {
            ImageSlider()
        }

        // Categories item
        item {
            Categories()
        }


    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenView() {
    HomeScreen(navigateToMyCart = {})
}