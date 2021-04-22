package com.example.grinhouseapp.webservices;

public class MeasurementResponse {
    private float value;
    private String unit;
    //private Date measurementDateTime;
    private int type;

    public Measurement getMeasurement()
    {
        return new Measurement(value, unit, /*measurementDateTime,*/ type);
    }
}
