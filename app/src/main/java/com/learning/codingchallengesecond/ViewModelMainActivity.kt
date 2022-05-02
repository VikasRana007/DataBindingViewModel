package com.learning.codingchallengesecond

import androidx.lifecycle.ViewModel

class ViewModelMainActivity : ViewModel() {
    private var outputValue = 0


    fun getOutputValue(): Int {
        return outputValue
    }

    fun setInputValue(value: Int) {
        outputValue = outputValue + value
    }


}