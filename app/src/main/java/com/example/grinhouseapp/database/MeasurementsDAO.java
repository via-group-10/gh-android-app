package com.example.grinhouseapp.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.grinhouseapp.model.Measurement;
import com.example.grinhouseapp.model.MeasurementType;

import java.util.List;

@Dao
public interface MeasurementsDAO {
    @Insert(onConflict = (OnConflictStrategy.REPLACE))
    void insert(Measurement measurement);

    @Query("SELECT * FROM measurements_table ORDER BY measurementTypeEnum, measurementDateTimeLong DESC")
    LiveData<List<Measurement>> getAllTypeMeasurements();
}