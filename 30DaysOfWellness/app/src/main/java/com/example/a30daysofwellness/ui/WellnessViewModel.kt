package com.example.a30daysofwellness.ui

import androidx.lifecycle.ViewModel
import com.example.a30daysofwellness.data.WellnessUiState
import com.example.a30daysofwellness.model.KihonJouhou
import com.example.a30daysofwellness.model.KihonJouhouRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class WellnessViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(WellnessUiState())
    val uiState: StateFlow<WellnessUiState> = _uiState.asStateFlow()

    private val kihonJouhouList: List<KihonJouhou> = _uiState.value.kihonJouhouList

    init {
        reset()
    }

    fun itemClick(item: KihonJouhou) {
        item.isVisible = !item.isVisible
    }

    private fun getItemFromIndex(index: Int): KihonJouhou {
        return if (index < kihonJouhouList.size) {
            kihonJouhouList[index]
        } else {
            kihonJouhouList.last()
        }
    }

    fun reset() {
        kihonJouhouList.forEach{
            it.isVisible = false
        }
    }
}