package com.example.grinhouseapp.webservices;

import java.sql.Timestamp;
import java.util.Date;

public class Measurement {

    private int measurementId;
    private float measuredValue;
    private Timestamp measurementDateTime;
    private int greenhouseId;
    private MeasurementType measurementTypeEnum;


    public Measurement(int measurementId, float measuredValue, Timestamp measurementDateTime, int greenhouseId, MeasurementType measurementTypeEnum)
    {
        this.measurementId = measurementId;
        this.measuredValue = measuredValue;
        this.measurementDateTime = measurementDateTime;
        this.greenhouseId = greenhouseId;
        this.measurementTypeEnum = measurementTypeEnum;
    }

    public Measurement()
    {

    }

    public int getGreenhouseId()
    {
        return greenhouseId;
    }

    public float getMeasurementValue()
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

    public void setMeasurementDateTime(Timestamp measurementDateTime)
    {
        this.measurementDateTime = measurementDateTime;
    }

    public void setMeasurementId(int measurementId)
    {
        this.measurementId = measurementId;
    }

    public void setMeasurementTypeEnum(MeasurementType measurementTypeEnum)
    {
        this.measurementTypeEnum = measurementTypeEnum;
    }

    public void setMeasurementValue(float measurementValue)
    {
        this.measuredValue = measurementValue;
    }
}
