package com.animaconnected.bluetooth.dfu;

import java.util.List;

/* loaded from: classes.dex */
public interface FotaProgressListener {
    void onClosing();

    void onError(String str);

    void onPerformFotaCompleted();

    void onPerformFotaError(byte b);

    void onProgressChanged(List<Byte> list);

    void onReadyToPerformFota();
}
