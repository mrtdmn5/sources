package com.animaconnected.bluetooth.dfu;

import android.net.Uri;
import com.animaconnected.bluetooth.gatt.GattDevice;

/* loaded from: classes.dex */
public interface BaseDfuController {
    void start(GattDevice gattDevice, Uri uri, DfuProgressListener dfuProgressListener);
}
