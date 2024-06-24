package com.animaconnected.bluetooth.device;

import android.content.Context;
import com.polidea.rxandroidble2.DaggerClientComponent$ClientComponentImpl;
import com.polidea.rxandroidble2.RxBleClient;

/* loaded from: classes.dex */
public class ClientProvider {
    private static RxBleClient sClient;

    public static RxBleClient getClient(Context context) {
        if (sClient == null) {
            Context applicationContext = context.getApplicationContext();
            applicationContext.getClass();
            sClient = new DaggerClientComponent$ClientComponentImpl(applicationContext).bindRxBleClientProvider.get();
        }
        return sClient;
    }
}
