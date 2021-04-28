package com.example.grinhouseapp.webservices;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
