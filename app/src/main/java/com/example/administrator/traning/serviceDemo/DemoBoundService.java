package com.example.administrator.traning.serviceDemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class DemoBoundService extends Service {

    public IBinder binder = new LocalBoundService();

    public class LocalBoundService extends Binder{
        public DemoBoundService getService(){
            return DemoBoundService.this;
        }
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    public String  printNumber(String num){
        return num;
    }
}
