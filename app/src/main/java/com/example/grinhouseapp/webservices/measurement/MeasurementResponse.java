package com.example.grinhouseapp.webservices.measurement;

import com.example.grinhouseapp.model.Measurement;
import com.example.grinhouseapp.model.MeasurementType;

import java.sql.Timestamp;

public class MeasurementResponse {

    private int measurementId;
    private float measurementValue;
    private Timestamp measurementDateTime;
    private int greenhouseId;
    private MeasurementType measurementTypeEnum;

    public Measurement getMeasurement()
    {
        return new Measurement(measurementId, measurementValue, measurementDateTime, greenhouseId, measurementTypeEnum);
    }
}
