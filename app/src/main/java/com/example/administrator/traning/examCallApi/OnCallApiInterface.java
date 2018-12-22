package com.example.administrator.traning.examCallApi;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface OnCallApiInterface {
    @POST("hodela/add_produce/")
    Call<Object> add_produce(@Body Product product);

    @GET("hodela/list_produce/")
    Call<ListProduce> list_produce();

    @FormUrlEncoded
    @POST("hodela/update_produce/")
//    Call<Object> update_produce(@Body Product product);
    Call<Object> update_produce(@Field("_id") String _id, @Field("produce") String produce, @Field("price") String price );
}
