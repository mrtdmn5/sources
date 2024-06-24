package com.animaconnected.bluetooth.device;

import java.util.List;

/* loaded from: classes.dex */
public interface DeviceFotaListener {
    void onFotaError(String str);

    void onFotaProgress(List<Byte> list);

    void onPerformFotaCompleted();

    void onPerformFotaError(byte b);

    void onReadyToPerformFota();
}
