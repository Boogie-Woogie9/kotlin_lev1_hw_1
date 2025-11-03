package com.example.kotlin_lev1_hw1.viewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class NumberViewModel : ViewModel() {
    private val _numbers = mutableStateListOf<Int>()
    val numbers: List<Int> get() = _numbers

    fun addNumber(){
        _numbers.add(_numbers.size)
    }
}