package com.learning.codingchallengesecond

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

// This factory class is use to create the customized object of our ViewModel class , its very helpful concise  and optimized code
class MainActivityViewModelFactory(private val startingTotal: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelMainActivity::class.java))
            return ViewModelMainActivity(startingTotal) as T
        throw IllegalArgumentException("Unknown View Model Class")
    }
}