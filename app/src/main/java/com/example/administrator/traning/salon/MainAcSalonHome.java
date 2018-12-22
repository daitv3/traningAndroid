package com.example.administrator.traning.salon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.administrator.traning.R;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainAcSalonHome extends AppCompatActivity implements ListItemSalon.SetOnDetailSalonListener{
    ListItemSalon listItemSalon;
    public static String BASE_URL="http://45.77.27.89:8088/api/";
    Retrofit retrofit;
    OnCallApiInterface onCallApiInterface;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_salon_home);
        /*ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_launcher_background);*/
        getDataSalon();

    }


    private void getDataSalon(){
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) .build();

        onCallApiInterface = retrofit.create(OnCallApiInterface.class);
        onCallApiInterface.list_salon().enqueue(new Callback<ListSalon>() {
            @Override
            public void onResponse(Call<ListSalon> call, Response<ListSalon> response) {
                listItemSalon = new ListItemSalon(response.body(),MainAcSalonHome.this,MainAcSalonHome.this);
                recyclerView = (RecyclerView) findViewById(R.id.list_salon);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainAcSalonHome.this));

                recyclerView.setAdapter(listItemSalon);
            }

            @Override
            public void onFailure(Call<ListSalon> call, Throwable t) {
                Toast.makeText(MainAcSalonHome.this,"Faild",Toast.LENGTH_LONG).show();
            }
        });
    }




    @Override
    public void onClickDetail(Object obj) {
        Salon salon = (Salon) obj;
        Intent intent = new Intent(MainAcSalonHome.this,MainDetailSalon.class);
        intent.putExtra("detail_salon",new Gson().toJson(salon));
        startActivity(intent);

    }
}


