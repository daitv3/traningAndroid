package com.example.administrator.traning.salon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.administrator.traning.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainAcRegisterUserSalon extends AppCompatActivity {

    EditText edt_fName;
    EditText edt_lName;
    EditText edt_phone;
    EditText edt_email;
    EditText edt_password;
    EditText edt_gender;
    Button btn_regist;
    RadioButton rd_male;
    RadioButton rd_fmale;

    Retrofit retrofit;
    OnCallApiInterface onCallApiInterface;
    public static String BASE_URL="http://45.77.27.89:8088/api/";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_register_user_salon);
        edt_fName = (EditText) findViewById(R.id.regist_fname_salon);
        edt_lName = (EditText) findViewById(R.id.regist_lname_salon);
        edt_phone = (EditText) findViewById(R.id.regist_phone_num_salon);
        edt_email = (EditText) findViewById(R.id.regist_email_salon);
        edt_password = (EditText) findViewById(R.id.regist_pass_salon);
        edt_gender = (EditText) findViewById(R.id.regist_gender_salon);
        btn_regist = (Button) findViewById(R.id.btn_regist_user_salon);
        rd_fmale = (RadioButton) findViewById(R.id.rd_fmale);
        rd_male = (RadioButton) findViewById(R.id.rd_male);


        //validate data input



        btn_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set var local store data input
                final String fName = edt_fName.getText().toString();
                final String lName = edt_lName.getText().toString();
                final String email = edt_email.getText().toString();
                final String phone = edt_phone.getText().toString();
                final String password = edt_password.getText().toString();
                String gender = edt_gender.getText().toString();

                if(rd_fmale.isChecked()){
                    gender = rd_fmale.getText().toString();
                }else if(rd_male.isChecked()){
                    gender = rd_male.getText().toString();
                }
                //set data input to Obj user salon
                final UserSalon userSalon = new UserSalon();
                userSalon.setFirst_name(fName);
                userSalon.setLast_name(lName);
                userSalon.setEmail(email);
                userSalon.setPass(password);
                userSalon.setGender(gender);
                userSalon.setPhone_number(phone);


                //call api regist user salon
                retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create()) .build();
                onCallApiInterface = retrofit.create(OnCallApiInterface.class);

                onCallApiInterface.register_users_salon(userSalon).enqueue(new Callback<Object>() {
                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response) {
                        if(response.isSuccessful()){
                            Intent  intent = new Intent(MainAcRegisterUserSalon.this, MainLoginSalon.class);
                            intent.putExtra("email", userSalon.getEmail());
                            setResult(1,intent);
                            finish();
                        }else{
                            Toast.makeText(MainAcRegisterUserSalon.this,"register error",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {
                        Toast.makeText(MainAcRegisterUserSalon.this,"register failed",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


    }
}
