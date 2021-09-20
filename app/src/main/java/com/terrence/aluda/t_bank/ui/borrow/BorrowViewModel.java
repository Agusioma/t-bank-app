package com.terrence.aluda.t_bank.ui.borrow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BorrowViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BorrowViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Borrow!");
    }

    public LiveData<String> getText() {
        return mText;
    }
}