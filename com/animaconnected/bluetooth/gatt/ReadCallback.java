package com.animaconnected.bluetooth.gatt;

/* loaded from: classes.dex */
public interface ReadCallback {
    void onError(Throwable th);

    void onSuccess(byte[] bArr);
}
