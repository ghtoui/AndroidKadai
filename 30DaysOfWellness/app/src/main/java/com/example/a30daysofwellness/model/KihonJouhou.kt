package com.example.a30daysofwellness.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class KihonJouhou(
    @StringRes val question: Int,
    @StringRes val answer: Int,
    @DrawableRes val questionImage: Int,
    var isVisible: Boolean = false
)
