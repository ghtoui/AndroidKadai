package com.example.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val describeTextId: Int,
    val courseNum: Int,
    @DrawableRes val imageResourceId: Int
)
