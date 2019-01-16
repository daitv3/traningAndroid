package com.example.administrator.traning.appfinal;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface OnCallApiInterface {
    @POST("rest/Login")
    Call<Fn_Longin_Output> doLogin(@Body Fn_UserInfo userInfo);
}
