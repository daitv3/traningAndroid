package com.example.administrator.traning.recyclerviews;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.example.administrator.traning.R;

public class AddNewItem extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nv);
        if(getIntent() != null){
             final TextView textView = (TextView)findViewById(R.id.txt_name);
             textView.setText(getIntent().getStringExtra("name"));
        }
    }
}
