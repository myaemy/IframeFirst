package com.example.aemy.iframeyong.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Aemy on 2016/6/12.
 */
public class NetCheckedUtils {
    /**
     * 是否能上网
     *
     * @param context
     * @return 是否能上网
     */
    public static  boolean hasConnectedNetwork(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService("connectivity");
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
