package com.example.ecommerceappme.composables.imageSlider

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ecommerceappme.R
import com.example.ecommerceappme.ui.theme.Blue
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import kotlin.math.absoluteValue

@Composable
fun ImageSlider(modifier: Modifier = Modifier, vm: ImageSliderViewModel = hiltViewModel()) {
    val pageState = rememberPagerState(initialPage = 0, pageCount = { vm.imageSlider.size })

    LaunchedEffect(pageState) {
        while (true) {
            yield()
            delay(2000)
            val nextPage = (pageState.currentPage + 1) % vm.imageSlider.size
            pageState.animateScrollToPage(nextPage)
        }
    }

    Box(modifier = modifier) {
        HorizontalPager(
            state = pageState,
            contentPadding = PaddingValues(horizontal = 16.dp),
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
        ) { page ->
            Card(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.graphicsLayer {
                    val pageOffset = (pageState.currentPage - page + pageState.currentPageOffsetFraction).absoluteValue
                    lerp(
                        start = 0.85F,
                        stop = 1F,
                        fraction = 1F - pageOffset.coerceIn(0F, 1F)
                    ).also { scale ->
                        scaleX = scale
                        scaleY = scale
                    }
                    alpha = lerp(
                        start = 0.5F,
                        stop = 1F,
                        fraction = 1F - pageOffset.coerceIn(0F, 1F)
                    )
                }
            ) {
                Image(
                    painter = painterResource(id = vm.imageSlider[page]),
                    contentDescription = stringResource(R.string.image_slider),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        // Custom Page Indicator
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(vm.imageSlider.size) { index ->
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(if (index == pageState.currentPage) 12.dp else 8.dp)
                        .graphicsLayer {
                            alpha = if (index == pageState.currentPage) 1f else 0.5f
                        }
                        .background(if (index == pageState.currentPage) Blue else Color.Gray, RoundedCornerShape(50))
                )
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun ImageSliderPreview() {
    val previewViewModel = ImageSliderViewModel().apply {
        imageSlider = listOf(R.drawable.logo, R.drawable.logo, R.drawable.logo)
    }
    ImageSlider(vm = previewViewModel)
}
