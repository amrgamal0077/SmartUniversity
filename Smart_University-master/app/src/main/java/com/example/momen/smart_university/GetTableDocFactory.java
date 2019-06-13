package com.example.momen.smart_university;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.momen.smart_university.database.DatabaseRoom;

/**
 * Created by Momen on 6/11/2019.
 */

public class GetTableDocFactory extends ViewModelProvider.NewInstanceFactory {

    private final DatabaseRoom mDb;
    private final String doctorName;

    public GetTableDocFactory(DatabaseRoom mDb , String doctorName){
        this.mDb = mDb;
        this.doctorName = doctorName;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new GetTableModel(mDb,doctorName);
    }

}
