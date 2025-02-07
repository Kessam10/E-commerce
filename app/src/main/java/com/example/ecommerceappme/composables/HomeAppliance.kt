//package com.route.e_commercec40gsunwed.view.composable
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Card
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color.Companion.Blue
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.lifecycle.viewmodel.compose.viewModel
//
//@Composable
//fun HomeAppliance(modifier: Modifier = Modifier, vm: HomeApplianceViewModel = viewModel()) {
//
//    Column(modifier = Modifier.fillMaxWidth()) {
//        Text(
//            text = "Home Appliance",
//            fontSize = 20.sp,
//            color = Blue,
//            modifier = Modifier.padding(10.dp)
//        )
//        Box(modifier = modifier) {
//            LazyRow(
//                modifier = Modifier.fillMaxWidth()
//            ) {
//                items(vm.image.size) { index ->
//                    Card(
//                        modifier = Modifier
//                            .padding(10.dp)
//                            .width(160.dp)
//                            .height(211.dp), // Adjust size as needed
//                        shape = RoundedCornerShape(20.dp),
//
//                    ) {
//                        Box {
//                            Image(
//                                painter = painterResource(id = vm.image[index]),
//                                contentDescription = "Home Appliance Image",
//                                contentScale = ContentScale.Crop,
//                                modifier = Modifier
//                                    .fillMaxSize() // Adjust the image size within the card
//                            )
//                            Card(
//                                modifier = Modifier
//                                    .padding(8.dp)
//                                    .align(Alignment.TopEnd)
//                                    .size(25.dp),
//                                shape = CircleShape,
//                            ) {
//                                Image(
//                                    painter = painterResource(id = R.drawable.blue_heart),
//                                    contentDescription = "Like image",
//                                    contentScale = ContentScale.Crop,
//                                    modifier = Modifier
//                                        .padding(5.dp)
//                                        .size(20.dp) // Adjust the size as needed
//
//                                )
//                            }
//                        }
//                    }
//                }
//            }
//
//        }
//    }
//}
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//private fun HomeAppliancePreview() {
//    HomeAppliance()
//}
