package com.example.administrator.traning.appfinal;

public class LstUsers {
    private String Email;
    private String GroupName;
    private String UserName;
    private String UserPhone;

    public LstUsers(String email, String groupName, String userName, String userPhone) {
        Email = email;
        GroupName = groupName;
        UserName = userName;
        UserPhone = userPhone;
    }

    public LstUsers(){}

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String groupName) {
        GroupName = groupName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserPhone() {
        return UserPhone;
    }

    public void setUserPhone(String userPhone) {
        UserPhone = userPhone;
    }
}
