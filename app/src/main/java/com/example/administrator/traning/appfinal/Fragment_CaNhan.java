package com.example.administrator.traning.appfinal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.traning.R;
import com.example.administrator.traning.salon.Output_User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fragment_CaNhan extends Fragment {

    Item_Home item_home;
    public static String BASE_URL="http://203.190.173.22:9005/MobileService.svc/";
    Retrofit retrofit;
    RecyclerView recyclerView;
    OnCallApiInterface onCallApiInterface;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);
//        View view = inflater.inflate(R.layout.fragment_fn_canhan, null);
//        return view;
       final View view = inflater.inflate(R.layout.fragment_fn_canhan, null);
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) .build();

        onCallApiInterface = retrofit.create(OnCallApiInterface.class);
        Param_User param_user =  new Param_User("",Main_fn_Home.Token,"1");
        onCallApiInterface.getUserByUsername(param_user).enqueue(new Callback<Output_User>() {
            @Override
            public void onResponse(Call<Output_User> call, Response<Output_User> response) {
                if(response.isSuccessful()) {

                    item_home = new Item_Home(response.body());
                    recyclerView = (RecyclerView) view.findViewById(R.id.recy_item_ca_nhan);
                    TextView textView = (TextView) view.findViewById(R.id.fn_size_user) ;
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                    recyclerView.setAdapter(item_home);
                    textView.setText(response.body().getListUsers().getCount());
                    Integer integer = response.body().getListUsers().getLstUsers().size();
                    textView.setText(integer.toString());
                }else{
                    Toast.makeText(getContext(),"NG",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Output_User> call, Throwable t) {
                Toast.makeText(getContext(),"Faild",Toast.LENGTH_LONG).show();
            }
        });





// code

        return view;
    }

    class Param_User{
        String Username;
        String token;
        String Page;
        public Param_User(){}

        public Param_User(String username, String token, String page) {
            Username = username;
            this.token = token;
            Page = page;
        }

        public String getUsername() {
            return Username;
        }

        public void setUsername(String username) {
            Username = username;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getPage() {
            return Page;
        }

        public void setPage(String page) {
            Page = page;
        }
    }
}
