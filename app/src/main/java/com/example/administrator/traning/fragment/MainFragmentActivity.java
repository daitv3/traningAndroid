package com.example.administrator.traning.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.traning.R;

public class MainFragmentActivity extends AppCompatActivity implements Fragment1.OnClickTextViewListener, Fragment2.OnClickTextViewListener1{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_fragment_demo);

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_parent,new Fragment1()).commit();



        Button btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onClickItemListener() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_parent,new Fragment2()).commit();
    }

    @Override
    public void OnClickItemByText(String text) {

    }

    @Override
    public void onClickItemListener1() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_parent,new Fragment1()).commit();
    }
}
