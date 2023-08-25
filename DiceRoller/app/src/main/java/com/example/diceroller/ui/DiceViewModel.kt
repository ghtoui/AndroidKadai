package com.example.diceroller.ui

import androidx.lifecycle.ViewModel
import com.example.diceroller.R
import com.example.diceroller.data.DiceUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DiceViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(DiceUiState())
    val uiState: StateFlow<DiceUiState> = _uiState.asStateFlow()

    private var diceNumber: Int = 0

    init {
        reset()
    }

    fun clickButton() {
        diceNumber = (1..6).random()
        updateState(diceNumber = diceNumber)
    }

    private fun updateState(diceNumber: Int) {
        val updateDiceImage = when (diceNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        _uiState.update { currentState ->
            currentState.copy (
                diceImage = updateDiceImage
            )
        }
    }

    fun reset() {
        updateState(1)
    }

}