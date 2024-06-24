package com.animaconnected.bluetooth.util;

/* loaded from: classes.dex */
public interface Callback<T> {
    void onError(Throwable th);

    void onSuccess(T t);
}
