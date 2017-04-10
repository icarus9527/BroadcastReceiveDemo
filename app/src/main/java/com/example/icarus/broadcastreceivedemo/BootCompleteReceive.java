package com.example.icarus.broadcastreceivedemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


//静态注册广播接收者，需要在manifest文件中注册
public class BootCompleteReceive extends BroadcastReceiver {
    public BootCompleteReceive() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Boot Complete",Toast.LENGTH_SHORT).show();
    }
}
