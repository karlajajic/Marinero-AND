package com.example.marinero_kj.ui.main;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class PageViewModel extends ViewModel {

    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    private MutableLiveData<String> mText= new MutableLiveData<>();

    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    public void setmText(String txt) {mText.setValue(txt);}

    public LiveData<String> getText() {
        return mText;
    }
}