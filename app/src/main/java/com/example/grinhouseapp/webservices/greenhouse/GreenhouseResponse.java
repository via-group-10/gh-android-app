package com.example.grinhouseapp.webservices.greenhouse;

import com.example.grinhouseapp.model.Account;
import com.example.grinhouseapp.model.Measurement;

public class GreenhouseResponse {
    private int greenhouseId;
    private String greenhouseName;
    private String loginName;
    private String loginPassword;

    public GreenhouseResponse(int greenhouseId, String greenhouseName, String loginName, String loginPassword) {
        this.greenhouseId = greenhouseId;
        this.greenhouseName = greenhouseName;
        this.loginName = loginName;
        this.loginPassword = loginPassword;
    }

    public Account getAccount()
    {
        return new Account(greenhouseId, greenhouseName, loginName, loginPassword);
    }
}
