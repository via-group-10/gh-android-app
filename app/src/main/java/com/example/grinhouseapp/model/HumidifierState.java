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

    public Timestamp getStateDateTime() {
        return stateDateTime;
    }

    public int getHumidifierId() {
        return humidifierId;
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

    public void setStateDateTime(Timestamp stateDateTime) {
        this.stateDateTime = stateDateTime;
    }

    public void setDehumidifierOn(boolean dehumidifierOn) {
        this.dehumidifierOn = dehumidifierOn;
    }

    public void setHumidifierId(int humidifierId) {
        this.humidifierId = humidifierId;
    }

    public void setHumidifierOn(boolean humidifierOn) {
        this.humidifierOn = humidifierOn;
    }
}