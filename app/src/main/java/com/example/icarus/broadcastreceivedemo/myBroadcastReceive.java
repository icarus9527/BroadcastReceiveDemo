package com.example.icarus.broadcastreceivedemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by icarus9527 on 2017/4/8.
 */

public class myBroadcastReceive extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getStringExtra("data")!=null){
            Toast.makeText(context,intent.getStringExtra("data"),Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"this is myBroadcast",Toast.LENGTH_SHORT).show();
        }

    }
}
