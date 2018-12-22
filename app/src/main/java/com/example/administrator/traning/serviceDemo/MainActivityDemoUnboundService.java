package com.example.administrator.traning.serviceDemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.administrator.traning.R;

public class MainActivityDemoUnboundService extends AppCompatActivity {
    Button btnPlay ;
    Button btnStop;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_unbound_service);
        btnPlay = (Button) findViewById(R.id.button_play);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //use intent call service
                Intent intent = new Intent(MainActivityDemoUnboundService.this, DemoUnboundSercive.class);
                startService(intent);
            }
        });

        btnStop = (Button) findViewById(R.id.button_stop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityDemoUnboundService.this, DemoUnboundSercive.class);
                stopService(intent);
            }
        });
    }


}
