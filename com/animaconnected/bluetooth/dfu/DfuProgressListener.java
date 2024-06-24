package com.animaconnected.bluetooth.dfu;

/* loaded from: classes.dex */
public interface DfuProgressListener {
    void onError(Throwable th);

    void onProgressChanged(int r1);

    void onSuccess();
}
