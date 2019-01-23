package com.example.administrator.traning.salon;

import com.example.administrator.traning.appfinal.ListUsers;

public class Output_User {
    private float errorCode;
    ListUsers ListUsers;

    public Output_User(float errorCode, com.example.administrator.traning.appfinal.ListUsers listUsers) {
        this.errorCode = errorCode;
        ListUsers = listUsers;
    }

    public Output_User(){}

    public float getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(float errorCode) {
        this.errorCode = errorCode;
    }

    public com.example.administrator.traning.appfinal.ListUsers getListUsers() {
        return ListUsers;
    }

    public void setListUsers(com.example.administrator.traning.appfinal.ListUsers listUsers) {
        ListUsers = listUsers;
    }
}
