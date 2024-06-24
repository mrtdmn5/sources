package no.nordicsemi.android.dfu;

/* loaded from: classes4.dex */
public interface DfuProgressListener {
    void onDeviceConnected(String str);

    void onDeviceConnecting(String str);

    void onDeviceDisconnected(String str);

    void onDeviceDisconnecting(String str);

    void onDfuAborted(String str);

    void onDfuCompleted(String str);

    void onDfuProcessStarted(String str);

    void onDfuProcessStarting(String str);

    void onEnablingDfuMode(String str);

    void onError(String str, int r2, int r3, String str2);

    void onFirmwareValidating(String str);

    void onProgressChanged(String str, int r2, float f, float f2, int r5, int r6);
}
