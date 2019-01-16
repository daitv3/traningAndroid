package com.example.administrator.traning.appfinal;

public class Fn_UserInfo {
    private String AmCode;
    private String Email;
    private String Fullname;
    private float GroupID;
    private float IsGroupRoot;
    private float IsNewTenant;
    private float IsSupper;
    private float ManagementId;
    private float ParentId;
    private float TenantId;
    private String TimeZone;
    private float Type;
    private float UserID;
    private String UserPhoneNumber;
    private float UserType;
    private String Username;
    private float isNew;
    private String TypeClient;
    private String ClientVersion;
    private String Password;

    public Fn_UserInfo(String amCode, String email, String fullname, float groupID, float isGroupRoot, float isNewTenant, float isSupper, float managementId, float parentId, float tenantId, String timeZone, float type, float userID, String userPhoneNumber, float userType, String username, float isNew) {
        AmCode = amCode;
        Email = email;
        Fullname = fullname;
        GroupID = groupID;
        IsGroupRoot = isGroupRoot;
        IsNewTenant = isNewTenant;
        IsSupper = isSupper;
        ManagementId = managementId;
        ParentId = parentId;
        TenantId = tenantId;
        TimeZone = timeZone;
        Type = type;
        UserID = userID;
        UserPhoneNumber = userPhoneNumber;
        UserType = userType;
        Username = username;
        this.isNew = isNew;

    }

    public Fn_UserInfo(String username, String typeClient, String clientVersion, String password) {
        Username = username;
        TypeClient = typeClient;
        ClientVersion = clientVersion;
        Password = password;
    }

    public Fn_UserInfo() {
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getTypeClient() {
        return TypeClient;
    }


    public void setTypeClient(String typeClient) {
        TypeClient = typeClient;
    }

    public String getClientVersion() {
        return ClientVersion;
    }

    public void setClientVersion(String clientVersion) {
        ClientVersion = clientVersion;
    }

    public String getAmCode() {
        return AmCode;
    }

    public void setAmCode(String amCode) {
        AmCode = amCode;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public float getGroupID() {
        return GroupID;
    }

    public void setGroupID(float groupID) {
        GroupID = groupID;
    }

    public float getIsGroupRoot() {
        return IsGroupRoot;
    }

    public void setIsGroupRoot(float isGroupRoot) {
        IsGroupRoot = isGroupRoot;
    }

    public float getIsNewTenant() {
        return IsNewTenant;
    }

    public void setIsNewTenant(float isNewTenant) {
        IsNewTenant = isNewTenant;
    }

    public float getIsSupper() {
        return IsSupper;
    }

    public void setIsSupper(float isSupper) {
        IsSupper = isSupper;
    }

    public float getManagementId() {
        return ManagementId;
    }

    public void setManagementId(float managementId) {
        ManagementId = managementId;
    }

    public float getParentId() {
        return ParentId;
    }

    public void setParentId(float parentId) {
        ParentId = parentId;
    }

    public float getTenantId() {
        return TenantId;
    }

    public void setTenantId(float tenantId) {
        TenantId = tenantId;
    }

    public String getTimeZone() {
        return TimeZone;
    }

    public void setTimeZone(String timeZone) {
        TimeZone = timeZone;
    }

    public float getType() {
        return Type;
    }

    public void setType(float type) {
        Type = type;
    }

    public float getUserID() {
        return UserID;
    }

    public void setUserID(float userID) {
        UserID = userID;
    }

    public String getUserPhoneNumber() {
        return UserPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        UserPhoneNumber = userPhoneNumber;
    }

    public float getUserType() {
        return UserType;
    }

    public void setUserType(float userType) {
        UserType = userType;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public float getIsNew() {
        return isNew;
    }

    public void setIsNew(float isNew) {
        this.isNew = isNew;
    }
}
