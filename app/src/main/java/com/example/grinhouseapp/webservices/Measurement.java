package com.example.grinhouseapp.webservices;

import java.util.Date;

public class Measurement {

    private final float value;
    private final String unit;
    //private final Date measurementDateTime;
    private final int type;

    public Measurement(float value, String unit, /*Date measurementDateTime,*/ int type) {
        this.value = value;
        this.unit = unit;
        //this.measurementDateTime = measurementDateTime;
        this.type = type;
    }

    public float getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    /*public Date getMeasurementDateTime() {
        return measurementDateTime;
    }*/

    public int getType() {
        return type;
    }
}
