package com.example.administrator.traning.serviceDemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.traning.R;

public class MainActivityBoundService extends AppCompatActivity {

    DemoBoundService demoBoundService;
    boolean flagConnect = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_demo_bound_service);
        Button btnWeather = findViewById(R.id.button_weather);
        final TextView textView = findViewById(R.id.text_weather);
        final EditText editText = findViewById(R.id.text_input_location);
        btnWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(demoBoundService.printNumber(editText.getText().toString()));
            }
        });
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //
            DemoBoundService.LocalBoundService localBoundService = (DemoBoundService.LocalBoundService) service;
            demoBoundService = localBoundService.getService();
            flagConnect = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            flagConnect = false;
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, DemoBoundService.class);
        this.bindService(intent, serviceConnection ,BIND_AUTO_CREATE);
        Log.d("start1", "onStart: Ok");
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(flagConnect ){

            this.unbindService(serviceConnection);
            flagConnect = false;
            Log.d("stop1", "onStop: stopOK");
        }
        Log.d("stop1", "onStopAc: stopAcOK");
    }




}
