package com.example.administrator.traning.serviceDemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;

public class DemoUnboundSercive extends Service {
    ArrayList<Integer> a;
    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        a = new ArrayList<>();
        for(int i = 0; i< 5;i++){
            a.add(i);
        }
        Log.d("startsv1", "onStartCommand: 123");
//        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.)
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Integer x = a.size();
        Log.d("startsv", "onStartCommand: 123"+x.toString());
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("huy", "onDestroy: Huy");
        super.onDestroy();

    }
}
