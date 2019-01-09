package com.example.administrator.traning.pulltorefresh;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface OnApiInterface {

    @GET("hodela/list_salon/{page}")
    Call<ListSalon> getListSalons(@Path("page") int page);


}
