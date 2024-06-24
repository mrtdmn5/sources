package com.animaconnected.watch.device;

import com.animaconnected.info.DeviceType;
import com.animaconnected.info.FirmwareVariant;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: DeviceWriter.kt */
/* loaded from: classes3.dex */
public interface WatchBackend {
    Map<DeviceInfo, String> getDeviceInfo();

    String getDeviceName();

    FirmwareVariant getFirmwareVariant();

    String getIdentifier();

    DeviceType getWatchType();

    void onEventHandlerReady(EventHandler eventHandler);

    Object read(byte[] bArr, Continuation<? super byte[]> continuation);

    Object write(byte[] bArr, Continuation<? super Unit> continuation);
}
