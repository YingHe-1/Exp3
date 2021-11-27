package com.example.exp3;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {
    private DemoService.MyBinder mBinder = null;
    private ServiceConnection sc = new ServiceConnection()
    {
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i("2020b32043", "=========service connected========");
            if(null != service)
            {
                mBinder = (DemoService.MyBinder)service;
            }
        }

        public void onServiceDisconnected(ComponentName name) {
            Log.i("2020b32043", "=========service disconnected========");
        }
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
    }
    private void initWidget()
    {
        Button btnStart = findViewById(R.id.bind);
        Button btnGetMsg = findViewById(R.id.getmsg);
        Button btnStop  = findViewById(R.id.unbind);
        btnStart.setOnClickListener(this);
        btnGetMsg.setOnClickListener(this);
        btnStop.setOnClickListener(this);
    }
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.bind:
            {
                Intent intent = new Intent(MainActivity.this, DemoService.class);
                bindService(intent, sc, Service.BIND_AUTO_CREATE);
                break;
            }
            case R.id.getmsg:
            {
                if(null != mBinder)
                {
                    Log.i("2020b32043", mBinder.getMsg());
                }
                break;
            }
            case R.id.unbind:
            {
                unbindService(sc);
                break;
            }
            default:
                break;
        }
    }
}
