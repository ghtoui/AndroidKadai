package com.example.lemonadeapp.ui

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.example.lemonadeapp.R
import com.example.lemonadeapp.data.LemonUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LemonViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(LemonUiState())
    val uiState: StateFlow<LemonUiState> = _uiState.asStateFlow()

    init {
        getRandomCount()
    }

    private fun getRandomCount() {
        _uiState.update { currentState ->
            currentState.copy(
                necessaryCount = (2..5).random()
            )
        }
    }

    private fun getImageAndText(count: Int): Pair<Int, Int> {
        return when (count) {
            1 -> Pair(R.drawable.lemon_squeeze, R.string.keep_tapping_lemon)
            2 -> Pair(R.drawable.lemon_drink, R.string.tap_lemonade)
            3 -> Pair(R.drawable.lemon_restart, R.string.tap_empty_glass)
            else -> Pair(R.drawable.lemon_tree, R.string.tap_lemon_tree)
        }
    }

    fun updateState() {
        val count = when (_uiState.value.count) {
            1 -> 2
            2 -> 3
            3 -> 4
            else -> 1
        }
        var isSqueeze: Boolean = count == 2

        val (image, text) = getImageAndText(count = count)

        if (isSqueeze) {
            val tappedCount = _uiState.value.tappedCount
            val necessaryCount = _uiState.value.necessaryCount
            if (tappedCount == necessaryCount) {
                _uiState.update {
                    it.copy(
                        tappedCount = 0,
                    )
                }
                isSqueeze = false
                getRandomCount()
            } else {
                _uiState.update {
                    it.copy(
                        tappedCount = tappedCount + 1
                    )
                }
            }
        }

        if (!isSqueeze) {
            _uiState.update { currentState ->
                currentState.copy(
                    image = image,
                    text = text,
                    count = count
                )
            }
        }
    }


}