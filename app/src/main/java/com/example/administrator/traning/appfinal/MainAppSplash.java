package com.example.administrator.traning.appfinal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.traning.R;

public class MainAppSplash extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_fn_splass);
      //  viewPager = (ViewPager) findViewById(R.id.fn_view_pager);
       // tabLayout = (TabLayout) findViewById(R.id.tab_layout_fn_home);

        final SharedPreferences sharedPreferences = getSharedPreferences("save_login_fn", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        final SharedPreferences sharedPreferences_token = getSharedPreferences("token_fn", MODE_PRIVATE);
        final SharedPreferences.Editor editor_token = sharedPreferences_token.edit();
        String token = sharedPreferences_token.getString("token_fn","");
        String message = sharedPreferences.getString("checkbox_save_user","0");
        if("1".equals(message) && !"".equals(token)){
            Intent intent = new Intent(MainAppSplash.this,Main_fn_Home.class);
            intent.putExtra("token",token);
            startActivity(intent);
            finish();
        }else {
            Intent intent = new Intent(MainAppSplash.this,Main_Fn_Login.class);
            startActivity(intent);
            finish();
        }
    }


}
