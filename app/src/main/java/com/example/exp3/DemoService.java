package com.example.exp3;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class DemoService extends Service {
    private String strMsg = "this is a message from DemoService !";

    private MyBinder mBinder = new MyBinder();

    public class MyBinder extends Binder
    {
        public String getMsg()
        {
            return strMsg;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("2020b32043", "onBind()");
        return mBinder;
    }
    @Override
    public void onCreate() {
        Log.i("2020b32043", "onCreate()");
        super.onCreate();
    }
    @Override
    public void onDestroy() {
        Log.i("2020b32043", "onDestroy()");
        super.onDestroy();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("2020b32043", "onStartCommand()");
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("2020b32043", "onUnbind()");
        return super.onUnbind(intent);
    }
}
