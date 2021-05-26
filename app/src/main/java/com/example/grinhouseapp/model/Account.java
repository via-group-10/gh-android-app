package com.example.grinhouseapp.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "account_table")
public class Account {
    private int greenhouseId;
    @PrimaryKey
    @NonNull
    private String greenhouseName;
    private String loginName;
    private String loginPassword;

    public Account(int greenhouseId, @NotNull String greenhouseName, String loginName, String loginPassword) {
        this.greenhouseId = greenhouseId;
        this.greenhouseName = greenhouseName;
        this.loginName = loginName;
        this.loginPassword = loginPassword;
    }

    public int getGreenhouseId() {
        return greenhouseId;
    }

    public void setGreenhouseId(int greenhouseId) {
        this.greenhouseId = greenhouseId;
    }

    public String getGreenhouseName() {
        return greenhouseName;
    }

    public void setGreenhouseName(String greenhouseName) {
        this.greenhouseName = greenhouseName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    @Override
    public String toString() {
        return "Account{" +
                "greenhouseId=" + greenhouseId +
                ", greenhouseName='" + greenhouseName + '\'' +
                ", loginName='" + loginName + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                '}';
    }
}
