package com.animaconnected.dfu.dfu15;

import android.app.Activity;
import no.nordicsemi.android.dfu.DfuBaseService;

/* loaded from: classes.dex */
public class DfuService extends DfuBaseService {
    @Override // no.nordicsemi.android.dfu.DfuBaseService
    public Class<? extends Activity> getNotificationTarget() {
        return NotificationActivity.class;
    }

    @Override // no.nordicsemi.android.dfu.DfuBaseService
    public boolean isDebug() {
        return false;
    }
}
