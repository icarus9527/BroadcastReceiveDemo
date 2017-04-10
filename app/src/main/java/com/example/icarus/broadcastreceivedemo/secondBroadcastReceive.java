package com.example.icarus.broadcastreceivedemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class secondBroadcastReceive extends BroadcastReceiver {
    public secondBroadcastReceive() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"This is secondBroadcast",Toast.LENGTH_SHORT).show();
        //用于截断这条广播被其他接收器接收
        abortBroadcast();
    }
}
