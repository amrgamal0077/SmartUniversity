package com.example.momen.smart_university.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

/**
 * Created by Momen on 6/11/2019.
 */

@Database(entities = {TableEntry.class},version = 1,exportSchema = false)
public abstract class DatabaseRoom extends RoomDatabase {

    private static final Object LOCK = new Object();
    private static final String DATABASE_NAME = "table_db";
    private static DatabaseRoom sInstance;

    public static DatabaseRoom getsInstance(Context context){

        if(sInstance == null){
            synchronized (LOCK){
                sInstance = Room.databaseBuilder(context.getApplicationContext(),DatabaseRoom.class,DatabaseRoom.DATABASE_NAME)
                        .build();
            }
        }
        return sInstance;
    }

    public abstract TableDio tableDio();
}
