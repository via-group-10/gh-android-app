package com.example.grinhouseapp.webservices;

import java.time.LocalDateTime;

public class MeasurementResponse {
    private float value;
    private String unit;
    private LocalDateTime measurementDateTime;
    private MeasurementType type;

    public Measurement getMeasurement()
    {
        return new Measurement(value, unit, measurementDateTime, type);
    }
}
