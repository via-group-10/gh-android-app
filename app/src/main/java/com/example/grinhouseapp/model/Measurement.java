package com.example.grinhouseapp.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.sql.Timestamp;

@Entity(tableName = "measurements_table")
public class Measurement {

    @PrimaryKey
    @NonNull
    private int measurementId;
    private float measuredValue;
    @Ignore
    private Timestamp measurementDateTime;
    private long measurementDateTimeLong;
    private int greenhouseId;
    private MeasurementType measurementTypeEnum;


    @Ignore
    public Measurement(int measurementId, float measuredValue, Timestamp measurementDateTime, int greenhouseId, MeasurementType measurementTypeEnum)
    {
        this.measurementId = measurementId;
        this.measuredValue = measuredValue;
        this.measurementDateTime = measurementDateTime;
        this.greenhouseId = greenhouseId;
        this.measurementTypeEnum = measurementTypeEnum;
    }

    public Measurement(int measurementId, float measuredValue, long measurementDateTimeLong, int greenhouseId, MeasurementType measurementTypeEnum)
    {
        this.measurementId = measurementId;
        this.measuredValue = measuredValue;
        this.measurementDateTimeLong = measurementDateTimeLong;
        this.greenhouseId = greenhouseId;
        this.measurementTypeEnum = measurementTypeEnum;
    }

    @Ignore
    public Measurement()
    {

    }

    public int getGreenhouseId()
    {
        return greenhouseId;
    }

    public float getMeasuredValue()
    {
        return measuredValue;
    }

    public Timestamp getMeasurementDateTime()
    {
        return measurementDateTime;
    }

    public int getMeasurementId()
    {
        return measurementId;
    }

    public MeasurementType getMeasurementTypeEnum()
    {
        return measurementTypeEnum;
    }

    public void setGreenhouseId(int greenhouseId)
    {
        this.greenhouseId = greenhouseId;
    }

    public long getMeasurementDateTimeLong() {
        return measurementDateTimeLong;
    }

    public void setMeasurementDateTimeLong(long measurementDateTimeLong) {
        this.measurementDateTimeLong = measurementDateTimeLong;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "measurementId=" + measurementId +
                ", measuredValue=" + measuredValue +
                ", measurementDateTime=" + measurementDateTime +
                ", measurementDateTimeLong=" + measurementDateTimeLong +
                ", greenhouseId=" + greenhouseId +
                ", measurementTypeEnum=" + measurementTypeEnum +
                '}';
    }
}
