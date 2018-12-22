package com.example.administrator.traning.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.traning.R;

public class MainFragmentDay2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_fragment_day2);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_parent_day2,new FragmentDay201()).commit();
    }


}
