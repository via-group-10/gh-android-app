package com.example.grinhouseapp.model;
import java.sql.Timestamp;

public class HumidifierState {

    private int humidifierId;
    private boolean humidifierOn;
    private boolean dehumidifierOn;
    private Timestamp stateDateTime;
    private int greenhouseId;

    public HumidifierState(int humidifierId, boolean humidifierOn, boolean dehumidifierOn, Timestamp stateDateTime, int greenhouseId)
    {
        this.humidifierId = humidifierId;
        this.humidifierOn = humidifierOn;
        this.dehumidifierOn = dehumidifierOn;
        this.stateDateTime = stateDateTime;
        this.greenhouseId = greenhouseId;
    }

    public int getGreenhouseId() {
        return greenhouseId;
    }


    public boolean dehumidifierOn() {
        return dehumidifierOn;
    }

    public boolean humidifierOn() {
        return humidifierOn;
    }

    public void setGreenhouseId(int greenhouseId) {
        this.greenhouseId = greenhouseId;
    }
}