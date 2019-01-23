package com.example.administrator.traning.appfinal;

import java.util.ArrayList;

public class ListUsers {
    private String Count;
    private ArrayList<LstUsers> LstUsers;

    public ListUsers(String count, ArrayList<com.example.administrator.traning.appfinal.LstUsers> lstUsers) {
        Count = count;
        LstUsers = lstUsers;
    }

    public ListUsers(){}

    public String getCount() {
        return Count;
    }

    public void setCount(String count) {
        Count = count;
    }

    public ArrayList<com.example.administrator.traning.appfinal.LstUsers> getLstUsers() {
        return LstUsers;
    }

    public void setLstUsers(ArrayList<com.example.administrator.traning.appfinal.LstUsers> lstUsers) {
        LstUsers = lstUsers;
    }
}
