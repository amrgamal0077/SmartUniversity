package com.example.momen.smart_university;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.momen.smart_university.database.DatabaseRoom;
import com.example.momen.smart_university.database.TableEntry;

import java.util.List;

/**
 * Created by Momen on 6/11/2019.
 */

public class GetTableModelStu extends ViewModel {
    LiveData<List<TableEntry>> dataStudent;

    public GetTableModelStu(DatabaseRoom room, List<String> subjects){
        dataStudent = room.tableDio().getTableStudent(subjects);
    }


    public LiveData<List<TableEntry>> getTableStudent(){
        return dataStudent;
    }
}
