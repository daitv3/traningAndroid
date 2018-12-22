package com.example.administrator.traning.multithead.intentservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.traning.R;

public class MainActivityIntentServive extends AppCompatActivity implements MyReceiver.GetDataSum{
    EditText num1 ;
    EditText num2;
    TextView sum;
    MyReceiver myReceiver = new MyReceiver(MainActivityIntentServive.this);
    IntentFilter intentFilter = new IntentFilter("training.intent.SUM2NUM");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_intent_service);
        num1 = (EditText) findViewById(R.id.txt_num1);
        num2 = (EditText) findViewById(R.id.txt_num2);
        sum = (TextView) findViewById(R.id.lb_sum);
        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityIntentServive.this,MyIntentService.class);
                intent.putExtra("num1",Integer.parseInt(num1.getText().toString()));
                intent.putExtra("num2",Integer.parseInt(num2.getText().toString()));
                startService(intent);
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
//        registerReceiver(myReceiver,intentFilter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        registerReceiver(myReceiver,intentFilter);
      //  Integer i = data.getIntExtra("summ",0);
      //  sum.setText(i.toString());
    }

    @Override
    protected void onStop() {
        super.onStop();
//        unregisterReceiver(myReceiver);
    }

    @Override
    public void getData(Context context, Integer data) {

        sum.setText(data.toString());
    }

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Integer i = intent.getIntExtra("summ",0);
            sum.setText(i.toString());

        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        //registerReceiver(broadcastReceiver,intentFilter);
        registerReceiver(myReceiver,intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
       // unregisterReceiver(broadcastReceiver);
        unregisterReceiver(myReceiver);

    }
}


