package com.example.momen.smart_university;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.momen.smart_university.database.DatabaseRoom;

import java.util.List;

/**
 * Created by Momen on 6/11/2019.
 */

public class GetTableStudentFactory extends ViewModelProvider.NewInstanceFactory {

    private final DatabaseRoom mDb;
    private final List<String> subjects;

    public GetTableStudentFactory(DatabaseRoom mDb , List<String> subjects){
        this.mDb = mDb;
        this.subjects = subjects;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new GetTableModelStu(mDb,subjects);
    }

}

