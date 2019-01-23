package com.example.administrator.traning.appfinal;

import com.example.administrator.traning.salon.Output_User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface OnCallApiInterface {
    @POST("rest/Login")
    Call<Fn_Longin_Output> doLogin(@Body Fn_UserInfo userInfo);

    @POST("rest/GetUsersByUsername")
    Call<Output_User> getUserByUsername(@Body Fragment_CaNhan.Param_User user);
}
