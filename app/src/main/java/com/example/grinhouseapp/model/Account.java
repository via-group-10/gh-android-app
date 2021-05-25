package com.example.grinhouseapp.model;

public class Account {
    private int greenhouseId;
    private String greenhouseName;
    private String loginName;
    private String loginPassword;

    public Account(int greenhouseId, String greenhouseName, String loginName, String loginPassword) {
        this.greenhouseId = greenhouseId;
        this.greenhouseName = greenhouseName;
        this.loginName = loginName;
        this.loginPassword = loginPassword;
    }

    public int getGreenhouseId() {
        return greenhouseId;
    }

    public String getGreenhouseName() {
        return greenhouseName;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }
}
