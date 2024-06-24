package com.animaconnected.bluetooth.dfu;

import android.net.Uri;
import com.animaconnected.bluetooth.gatt.GattDevice;

/* loaded from: classes.dex */
public abstract class BaseFotaController {
    public abstract void cancelFota();

    public abstract void onConnIntChange(int r1);

    public abstract void performFota();

    public abstract void setFotaSlowMode(boolean z);

    public abstract void start(GattDevice gattDevice, Uri uri, boolean z, FotaProgressListener fotaProgressListener);
}
