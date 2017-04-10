package com.example.icarus.broadcastreceivedemo;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn1,btn2,btn3,btn4;

    private LocalBroadcastReceive localBroadcastReceive;
    private LocalBroadcastManager localBroadcastManager;

    private NetworkChangedReceive networkChangedReceive;
    private IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.main_btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentFilter = new IntentFilter();
                //addAction的值为发出的广播，这样，注册的广播接收器接收到这条广播后就会执行onReceive的内容
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                networkChangedReceive = new NetworkChangedReceive();
                registerReceiver(networkChangedReceive,intentFilter);
                Toast.makeText(MainActivity.this,"BroadcastReceive has register",Toast.LENGTH_SHORT).show();
            }
        });

        btn2 = (Button) findViewById(R.id.main_btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //通过sendBroadcast方法将带有action信息的intent广播出去，注册了相同action的广播接收者就会收到该信息并执行onReceive方法
                //因为广播是通过intent进行传递的，所以还可以在intent中携带数据传递给广播接收者
                Intent intent = new Intent("com.example.icarus.broadcastreceivedemo.MYBROADCASTRECEIVE");
                intent.putExtra("data","成功接收广播信息");
                sendBroadcast(intent);
            }
        });

        btn3 = (Button) findViewById(R.id.main_btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //有序广播，广播接收器异步接收的广播方式，就是一个广播接收后，
                //处理完才能让下一个接收，接收器也可以阻断接收的广播，使后面的接收器无法再接收这条广播
                Intent intent = new Intent("com.example.icarus.broadcastreceivedemo.MYBROADCASTRECEIVE");
                //第一个是intent对象，第二个是与权限相关的字符串
                //接收器优先等级在注册信息里注册，数字越大，优先级越大
                sendOrderedBroadcast(intent,null);
            }
        });

        btn4 = (Button) findViewById(R.id.main_btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //本地广播是无法通过静态注册的方式来接收的
                //本地广播只能在应用程序的内部进行传递
                localBroadcastManager = LocalBroadcastManager.getInstance(MainActivity.this);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.example.icarus.broadcastreceivedemo.LOCAL_BROADCASTRECEIVE");
                localBroadcastReceive = new LocalBroadcastReceive();
                localBroadcastManager.registerReceiver(localBroadcastReceive,intentFilter);
                Intent intent = new Intent("com.example.icarus.broadcastreceivedemo.LOCAL_BROADCASTRECEIVE");
                localBroadcastManager.sendBroadcast(intent);
            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //动态注册的广播接收者必须取消注册，否则activity无法被真正关闭，将一直占用内存
        unregisterReceiver(networkChangedReceive);
        localBroadcastManager.unregisterReceiver(localBroadcastReceive);
    }
}
