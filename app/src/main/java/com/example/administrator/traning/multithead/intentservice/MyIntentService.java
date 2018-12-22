package com.example.administrator.traning.multithead.intentservice;

import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyIntentService extends IntentService {

    public MyIntentService(){
        super("MyService");
    }
    public MyIntentService(String name) {
        super(name);
    }

    @Override
    public void onStart(@Nullable Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override
    protected void onHandleIntent( Intent intent) {
        int num = intent.getIntExtra("num1",0)+ intent.getIntExtra("num2",0);
        Log.d("summ", "onHandleIntent: "+num);

        Intent intent1 = new Intent();
        intent1.putExtra("summ",num);
        intent1.setAction("training.intent.SUM2NUM");
        sendBroadcast(intent1);
    }


}
class  MyReceiver extends BroadcastReceiver{
    GetDataSum getDataSum;
    public MyReceiver(){};
    public MyReceiver(GetDataSum getDataSum) {
        this.getDataSum = getDataSum;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        getDataSum.getData(context,intent.getIntExtra("summ",0));
    }

    interface GetDataSum{
        void getData(Context context, Integer data);
    }
}