package com.example.administrator.traning.salon;


import retrofit2.Call;
import retrofit2.http.GET;

public interface OnCallApiInterface {


    @GET("hodela/list_salon/")
    Call<ListSalon> list_salon();


}
