package com.example.administrator.traning.listView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.traning.R;

public class ContentViewDemo extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_listview);
        TextView  t = (TextView) findViewById(R.id.content_list_item);
        if(getIntent()!= null){
            t.setText(getIntent().getStringExtra("text"));
        }
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("x","abc");
                setResult(1,i);
                finish();

            }
        });
    }
}
