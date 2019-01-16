package com.example.administrator.traning.appfinal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.traning.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main_Fn_Login  extends AppCompatActivity {
    public static String BASE_URL="http://203.190.173.22:9005/MobileService.svc/";
    EditText input_user;
    EditText input_password;

    CheckBox checkBox_save_login;
    Button btn_login;
    TextView txt_forgot_pass;
    Retrofit retrofit;
    OnCallApiInterface onCallApiInterface;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_fn_login);

        PackageInfo info = null;
        try {
            PackageManager manager = this.getPackageManager();
            info = manager.getPackageInfo(
                    this.getPackageName(), 0);
            String version = info.versionName;
            int versionCode = info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }




        input_user = (EditText) findViewById(R.id.input_fn_user);
        input_password = (EditText) findViewById(R.id.input_fn_password);
        checkBox_save_login = (CheckBox) findViewById(R.id.fn_cb_save_login);
        btn_login = (Button) findViewById(R.id.fn_btn_login);
        txt_forgot_pass = (TextView)findViewById(R.id.txt_quen_pass);

        //do login
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fn_UserInfo  userInfo = new Fn_UserInfo();
                userInfo.setUsername(input_user.getText().toString());
                userInfo.setPassword(input_password.getText().toString());
                userInfo.setClientVersion("4.0");
                userInfo.setTypeClient("1");

                do_login(userInfo);
            }
        });

        txt_forgot_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }

    void do_login(Fn_UserInfo userInfo){
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) .build();
        onCallApiInterface = retrofit.create(OnCallApiInterface.class);
        onCallApiInterface.doLogin(userInfo).enqueue(new Callback<Fn_Longin_Output>() {
            @Override
            public void onResponse(Call<Fn_Longin_Output> call, Response<Fn_Longin_Output> response) {
                if(response.isSuccessful()) {
                    if(response.body().UserInfo != null) {
                        String token = response.body().getToken();

                        //save token
                        //store token
                        final SharedPreferences sharedPreferences = getSharedPreferences("token_fn", MODE_PRIVATE);
                        final SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("token_fn", token);
                        editor.commit();

                        final SharedPreferences sharedPreferences_checkbox = getSharedPreferences("save_login_fn", MODE_PRIVATE);
                        final SharedPreferences.Editor editor_checkbox = sharedPreferences_checkbox.edit();
                        if (checkBox_save_login.isChecked()) {

                            editor_checkbox.putString("checkbox_save_user", "1");
                            editor_checkbox.commit();
                        } else {
                            editor_checkbox.putString("checkbox_save_user", "0");
                            editor_checkbox.commit();
                        }

                        //go to home page
                        Intent intent = new Intent(Main_Fn_Login.this, Main_fn_Home.class);
                        intent.putExtra("token", token);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(Main_Fn_Login.this,"Login information is incorrect",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(Main_Fn_Login.this,"login Failed",Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<Fn_Longin_Output> call, Throwable t) {
                Toast.makeText(Main_Fn_Login.this,"login Error",Toast.LENGTH_LONG).show();
            }
        });
    }
}
