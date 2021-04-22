package com.example.grinhouseapp.webservices;

import java.time.LocalDateTime;

public class Measurement {

    private float value;
    private String unit;
    private LocalDateTime measurementDateTime;
    private MeasurementType type;

    public Measurement(float value, String unit, LocalDateTime measurementDateTime, MeasurementType type) {
        this.value = value;
        this.unit = unit;
        this.measurementDateTime = measurementDateTime;
        this.type = type;
    }

    public float getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    public LocalDateTime getMeasurementDateTime() {
        return measurementDateTime;
    }

    public MeasurementType getType() {
        return type;
    }
}
