package com.example.ecommerceappme.composables.imageSlider

import com.example.ecommerceappme.R
import com.example.ecommerceappme.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ImageSliderViewModel @Inject constructor() : BaseViewModel() {

    var imageSlider = listOf(
        R.drawable.offer25,
        R.drawable.offer30,
        R.drawable.offer20
    )

}