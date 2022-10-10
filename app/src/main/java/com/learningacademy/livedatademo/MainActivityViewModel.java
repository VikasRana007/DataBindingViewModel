package com.learningacademy.livedatademo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
private int count = 0;
private MutableLiveData<Integer> countLiveData = new MutableLiveData<>();     // Live Data also survive configuration changes it is in the view model class


    public MutableLiveData<Integer> getInitialCount(){
          countLiveData.setValue(count);
          return countLiveData;
    }


    public void getCurrentCount(){
        count += 1;
        countLiveData.setValue(count);
    }
}
