package com.example.icarus.broadcastreceivedemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class LocalBroadcastReceive extends BroadcastReceiver {
    public LocalBroadcastReceive() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"this is localReceive",Toast.LENGTH_SHORT).show();
    }
}
