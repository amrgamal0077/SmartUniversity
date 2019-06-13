package com.example.momen.smart_university.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Momen on 6/11/2019.
 */
@Dao
public interface TableDio {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSubject(TableEntry movieEntry );

    @Query("SELECT * FROM table_entry WHERE doc_name = :docName")
    LiveData<List<TableEntry>> getTableDoctor(String docName);

    @Query("SELECT * FROM table_entry WHERE sub_name IN (:subjects)")
    LiveData<List<TableEntry>> getTableStudent(List<String> subjects);

}
