package com.example.lemonadeapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.lemonadeapp.R

data class LemonUiState(
    @DrawableRes val image: Int = R.drawable.lemon_tree,
    @StringRes val text: Int = R.string.tap_lemon_tree,
    val necessaryCount: Int = (2..4).random(),
    val tappedCount: Int = 0,
    val count: Int = 0
)
