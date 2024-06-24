package com.animaconnected.secondo.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.animaconnected.secondo.provider.ProviderFactory;

/* loaded from: classes.dex */
public class RestartReceiver extends BroadcastReceiver {
    private static final String TAG = "RestartReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        String str2 = TAG;
        if (("Starting device service. Received " + intent) != null) {
            str = intent.getAction();
        } else {
            str = null;
        }
        Log.d(str2, str);
        ProviderFactory.getWatch();
    }
}
