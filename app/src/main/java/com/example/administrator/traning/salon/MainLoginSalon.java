package com.example.administrator.traning.salon;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.traning.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainLoginSalon extends AppCompatActivity{
    EditText edt_email_salon;
    EditText edt_password_salon;
    Button btn_login_salon;
    public static String BASE_URL="http://45.77.27.89:8088/api/";
    OnCallApiInterface onCallApiInterface;
    Retrofit retrofit;
    TextView tv_link_register;
    LoginButton tv_link_login_fb;

    CallbackManager mCallbackManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_login_salon);
        edt_email_salon = (EditText) findViewById(R.id.input_email_salon);
        edt_password_salon = (EditText) findViewById(R.id.input_password_salon);
        btn_login_salon = (Button) findViewById(R.id.btn_login_salon);
        tv_link_register = (TextView) findViewById(R.id.link_register_user_salon);
        tv_link_login_fb = (LoginButton ) findViewById(R.id.link_login_fb);

        //check token

        final SharedPreferences sharedPreferences = getSharedPreferences("token_salon", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final String tokenStore = sharedPreferences.getString("token_user1","");
        if(!"".equals(tokenStore)){
            goSalonHomeActivity(tokenStore);
        }
        /*
        if(!"".equals(tokenStore)){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()) .build();

            onCallApiInterface = retrofit.create(OnCallApiInterface.class);
            onCallApiInterface.list_salon_token(tokenStore).enqueue(new Callback<Object>() {
                @Override
                public void onResponse(Call<Object> call, Response<Object> response) {
                    if(response.isSuccessful()){
                        goSalonHomeActivity(tokenStore);
                    }else{
                        Toast.makeText(MainLoginSalon.this,"token Error",Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Object> call, Throwable t) {
                    Toast.makeText(MainLoginSalon.this,"token failed",Toast.LENGTH_LONG).show();
                }
            });

        }
        */
        btn_login_salon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserSalon userSalon = new UserSalon(edt_email_salon.getText().toString(),edt_password_salon.getText().toString());
                getDataSalonUesr(userSalon);

            }
        });

        //link to sign up screen
        tv_link_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainLoginSalon.this,MainAcRegisterUserSalon.class);
                startActivityForResult(intent,1);
            }
        });

        //link to login fb
        mCallbackManager = CallbackManager.Factory.create();
        tv_link_login_fb.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                //store token
                final SharedPreferences sharedPreferences = getSharedPreferences("token_salon", MODE_PRIVATE);
                final SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("token_user_login",loginResult.getAccessToken().getToken());
                editor.commit();
                goSalonHomeActivity(loginResult.getAccessToken().getToken());

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

    private void getDataSalonUesr(UserSalon userSalon){
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) .build();

        onCallApiInterface = retrofit.create(OnCallApiInterface.class);
        onCallApiInterface.do_login_authenticate(userSalon).enqueue(new Callback<UserSalon>() {

            @Override
            public void onResponse(Call<UserSalon> call, Response<UserSalon> response) {
                if(response.isSuccessful()){
                    String token = response.body().getToken();
                    //store token
                    final SharedPreferences sharedPreferences = getSharedPreferences("token_salon", MODE_PRIVATE);
                    final SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("token_user",token);
                    editor.commit();

                    Intent intent = new Intent(MainLoginSalon.this,MainAcSalonHome.class);
                    intent.putExtra("token",token);
                    startActivity(intent);
                    finish();

                }else{
                    Toast.makeText(MainLoginSalon.this,"login Error",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UserSalon> call, Throwable t) {
                Toast.makeText(MainLoginSalon.this,"login failed",Toast.LENGTH_LONG).show();
            }
        });
    }




    private void goSalonHomeActivity( String token){
        Intent intent = new Intent(MainLoginSalon.this,MainAcSalonHome.class);
        intent.putExtra("token",token);

        startActivity(intent);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == 1){
            edt_email_salon.setText(data.getStringExtra("email"));
        }
    }
}
