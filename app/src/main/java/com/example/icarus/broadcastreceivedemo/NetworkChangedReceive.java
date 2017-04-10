package com.example.icarus.broadcastreceivedemo;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telecom.Connection;
import android.widget.Toast;

/**
 * Created by icarus9527 on 2017/4/8.
 */

public class NetworkChangedReceive extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //ConnectivityManager是专门用来管理网络连接的系统服务类
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo info = connectivityManager.getActiveNetworkInfo();

        if (info != null && info.isAvailable()){
            Toast.makeText(context,"Network is available",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Network is unavailable", Toast.LENGTH_SHORT).show();
        }
    }
}
