package com.example.administrator.traning.pulltorefresh;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.traning.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainPullToRefresh extends AppCompatActivity implements MyAdapter.OnDeleteListener{

    final String BASE_URL = "http://45.77.27.89:8088/api/";

    Retrofit retrofit;

    OnApiInterface myRetrofitAPI;


    RecyclerView mRecyclerView;
    MyAdapter mAdapter;

    TextView txtName;

    SwipeRefreshLayout swipeRefresh;
    ProgressBar mProgress;

    ArrayList<Salon> arrayList = new ArrayList<>();
    int page=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_pull_to_refresh);


        txtName = (TextView)findViewById(R.id.activity_main_name);

        mRecyclerView = (RecyclerView)findViewById(R.id.activity_man_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mProgress = (ProgressBar)findViewById(R.id.progress);
        //  arrayList.addAll(setData(0));

        mAdapter = new MyAdapter(this, arrayList, this);
        mRecyclerView.setAdapter(mAdapter);

        retrofit = new Retrofit.Builder() .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) .build();

        myRetrofitAPI = retrofit.create(OnApiInterface.class);

        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipelayout);

        loadSalon(0);

        loadMore();

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 0;
                loadSalon(page);
                loadMore();
                swipeRefresh.setRefreshing(false);
            }
        });

    }

    @Override
    public void onDelete(String data) {
        txtName.setText(data);
    }

    void loadSalon(final int page){
        if(page != 0){
            mProgress.setVisibility(View.VISIBLE);

        }
        myRetrofitAPI.getListSalons(page).enqueue(new Callback<ListSalon>() {
            @Override
            public void onResponse(Call<ListSalon> call, Response<ListSalon> response) {
                mProgress.setVisibility(View.GONE);
                if(response.isSuccessful()) {
                    if(response.body()!=null){
                        if(page==0){
                            arrayList.clear();

                        }
                        arrayList.addAll(response.body().data);
                        mAdapter.notifyDataSetChanged();
                    }

                }else{
                    Toast.makeText(MainPullToRefresh.this, "error",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ListSalon> call, Throwable t) {
                mProgress.setVisibility(View.GONE);
                Toast.makeText(MainPullToRefresh.this, "failed",Toast.LENGTH_SHORT).show();
            }
        });


    }

    void loadMore(){
        mRecyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener((LinearLayoutManager)mRecyclerView.getLayoutManager()) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                loadSalon(page);
            }
        });
    }
}
