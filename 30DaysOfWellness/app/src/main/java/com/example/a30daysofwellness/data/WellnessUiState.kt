package com.example.a30daysofwellness.data

import com.example.a30daysofwellness.model.KihonJouhou
import com.example.a30daysofwellness.model.KihonJouhouRepository

data class WellnessUiState(
    val kihonJouhouList: List<KihonJouhou> = KihonJouhouRepository.KihonJouhouList,
)
