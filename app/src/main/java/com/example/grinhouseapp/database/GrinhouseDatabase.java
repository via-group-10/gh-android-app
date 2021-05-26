package com.example.grinhouseapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.grinhouseapp.model.Account;
import com.example.grinhouseapp.model.Measurement;

@Database(entities = {Account.class, Measurement.class}, version = 11)
public abstract class GrinhouseDatabase extends RoomDatabase {

    private static GrinhouseDatabase instance;
    public abstract AccountsDAO accountsDAO();
    public abstract MeasurementsDAO measurementsDAO();

    public static synchronized GrinhouseDatabase getInstance(Context context)
    {
        if(instance == null)
        {
            instance = Room.databaseBuilder(context, GrinhouseDatabase.class, "grinhouse_database")
                    .fallbackToDestructiveMigration().build();
        }
        return instance;
    }
}
