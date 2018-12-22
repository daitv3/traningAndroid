package com.example.administrator.traning.broadcastRecevier;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

public class MyBroadcastIntentService extends IntentService {

    public MyBroadcastIntentService(String name) {
        super(name);
    }

    public MyBroadcastIntentService(){
        super("Service1");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }
}
