package com.example.administrator.traning.appfinal;

public class Fn_Longin_Output {
    private float errorCode;
    private boolean ForceUpdate;
    private String MapKeyName;
    private String MapKeyPass;
    private String Message;
    private float ResultCode;
    private String SessionID;
    private boolean UpdateAvailable;
    private String Url = null;
    Fn_UserInfo UserInfo;
    private String token;

    public Fn_Longin_Output(float errorCode, boolean forceUpdate, String mapKeyName, String mapKeyPass, String message, float resultCode, String sessionID, boolean updateAvailable, String url, Fn_UserInfo userInfo, String token) {
        this.errorCode = errorCode;
        ForceUpdate = forceUpdate;
        MapKeyName = mapKeyName;
        MapKeyPass = mapKeyPass;
        Message = message;
        ResultCode = resultCode;
        SessionID = sessionID;
        UpdateAvailable = updateAvailable;
        Url = url;
        UserInfo = userInfo;
        this.token = token;
    }

    public Fn_Longin_Output(){}

    public Fn_Longin_Output(Fn_UserInfo userInfo) {
        UserInfo = userInfo;
    }

    public Fn_Longin_Output(Fn_UserInfo userInfo, String token) {
        UserInfo = userInfo;
        this.token = token;
    }

    public float getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(float errorCode) {
        this.errorCode = errorCode;
    }

    public boolean isForceUpdate() {
        return ForceUpdate;
    }

    public void setForceUpdate(boolean forceUpdate) {
        ForceUpdate = forceUpdate;
    }

    public String getMapKeyName() {
        return MapKeyName;
    }

    public void setMapKeyName(String mapKeyName) {
        MapKeyName = mapKeyName;
    }

    public String getMapKeyPass() {
        return MapKeyPass;
    }

    public void setMapKeyPass(String mapKeyPass) {
        MapKeyPass = mapKeyPass;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public float getResultCode() {
        return ResultCode;
    }

    public void setResultCode(float resultCode) {
        ResultCode = resultCode;
    }

    public String getSessionID() {
        return SessionID;
    }

    public void setSessionID(String sessionID) {
        SessionID = sessionID;
    }

    public boolean isUpdateAvailable() {
        return UpdateAvailable;
    }

    public void setUpdateAvailable(boolean updateAvailable) {
        UpdateAvailable = updateAvailable;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public Fn_UserInfo getUserInfo() {
        return UserInfo;
    }

    public void setUserInfo(Fn_UserInfo userInfo) {
        UserInfo = userInfo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
