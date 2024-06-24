package com.animaconnected.secondo.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.animaconnected.secondo.provider.ProviderFactory;

/* loaded from: classes.dex */
public class TimeChangedReceiver extends BroadcastReceiver {
    public static final String HOME_TIMEZONE_CHANGED_INTENT = "com.animaconnected.intent.action.HOME_TIMEZONE_CHANGED_INTENT";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.TIMEZONE_CHANGED") || intent.getAction().equals("android.intent.action.TIME_SET")) {
            ProviderFactory.getWatch().setDeviceTime();
        }
        if (intent.getAction().equals("android.intent.action.TIMEZONE_CHANGED")) {
            Intent intent2 = new Intent();
            intent2.setAction(HOME_TIMEZONE_CHANGED_INTENT);
            context.sendBroadcast(intent2);
        }
    }
}
