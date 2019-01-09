package com.example.administrator.traning.salon;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface OnCallApiInterface {


    @GET("hodela/list_salon/")
    Call<ListSalon> list_salon();

    @POST("hodela/login_authenticate/")
    Call<UserSalon> do_login_authenticate(@Body UserSalon userSalon);

    @POST("hodela/register_users/")
    Call<Object> register_users_salon(@Body UserSalon userSalon);

    
    @POST("hodela/list_salon_token/:id/")
    Call<Object> list_salon_token(String token);
}
