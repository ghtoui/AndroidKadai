package com.example.happybirthday.ui

import androidx.lifecycle.ViewModel
import com.example.happybirthday.data.HappyBirthdayUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HappyBirthdayViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(HappyBirthdayUiState())
    var uiState: StateFlow<HappyBirthdayUiState> = _uiState.asStateFlow()

    init {

    }
}