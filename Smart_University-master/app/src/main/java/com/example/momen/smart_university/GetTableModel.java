package com.example.momen.smart_university;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.momen.smart_university.database.DatabaseRoom;
import com.example.momen.smart_university.database.TableEntry;

import java.util.List;

/**
 * Created by Momen on 6/11/2019.
 */

public class GetTableModel extends ViewModel {
    LiveData<List<TableEntry>> dataDoc;

    public GetTableModel(DatabaseRoom room, String doctorName){
        dataDoc = room.tableDio().getTableDoctor(doctorName);
    }


    public LiveData<List<TableEntry>> getTableDoc(){
        return dataDoc;
    }
}
