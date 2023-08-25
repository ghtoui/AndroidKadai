package com.example.testapp.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.example.testapp.data.TestUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalTime
import java.time.LocalTime.*
import java.time.temporal.ChronoUnit
import java.time.format.DateTimeFormatter

class TestViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(TestUiState())
    val uiState: StateFlow<TestUiState> = _uiState.asStateFlow()

    @RequiresApi(Build.VERSION_CODES.O)
    private val targetTime: LocalTime = parse("20:30:00")

    @RequiresApi(Build.VERSION_CODES.O)
    private val formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd (E) HH:mm:ss")

    init {

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getNowTime(): LocalTime {
        return LocalTime.now()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getDiffTime() {
        val now = getNowTime()
        val diff = ChronoUnit.HOURS.between(now, targetTime)
        println(now.format(formatter))
        upDateState(time = now.format(formatter))
    }

    private fun upDateState(time: String) {
        _uiState.update { currentState ->
            currentState.copy (
                time = time
            )
        }
    }
}