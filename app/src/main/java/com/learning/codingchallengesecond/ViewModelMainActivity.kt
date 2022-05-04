package com.learning.codingchallengesecond

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelMainActivity(startingTotal: Int) : ViewModel() {

    private var total = MutableLiveData<Int>()

    val totalOutput: LiveData<Int>
        get() = total         // that is backing property of kotlin


    val inputValue = MutableLiveData<String>()

    init {
        // the outputValue variable now is a MutableLiveData so we can not just assign the outputValue to it
        // besides that  we need to get the property of it(outputValue) and then assign the outputValue to it...
        total.value = startingTotal
    }


    fun totalSum() {
        val intInput: Int = inputValue.value!!.toInt()
        total.value = (total.value)?.plus(intInput)
        // here is LiveData object

        // Here it is MutableLiveData, Null check safety is also applied here and instead of
        // plus operator we have use plus keyword...
//        outputValue.value = (outputValue.value)?.plus(input)


    }


}


