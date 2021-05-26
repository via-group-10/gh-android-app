package com.example.grinhouseapp.model;
import java.sql.Timestamp;


public class CarbonDioxideGeneratorState {

    private int carbonDioxideGeneratorStateId;
    private boolean isCarbonDioxideGeneratorOn;
    private Timestamp stateDateTime;
    private int greenhouseId;

    public CarbonDioxideGeneratorState(int carbonDioxideGeneratorStateId, boolean isCarbonDioxideGeneratorOn,Timestamp stateDateTime, int greenhouseId)
    {
        this.isCarbonDioxideGeneratorOn = isCarbonDioxideGeneratorOn;
        this.carbonDioxideGeneratorStateId = carbonDioxideGeneratorStateId;
        this.stateDateTime = stateDateTime;
        this.greenhouseId = greenhouseId;
    }

    public Timestamp getStateDateTime() {
        return stateDateTime;
    }

    public int getGreenhouseId() {
        return greenhouseId;
    }


    public boolean isCarbonDioxideGeneratorOn() {
        return isCarbonDioxideGeneratorOn;
    }


    public void setGreenhouseId(int greenhouseId) {
        this.greenhouseId = greenhouseId;
    }
}

