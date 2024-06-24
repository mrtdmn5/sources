package com.animaconnected.bluetooth.gatt;

import java.util.UUID;

/* loaded from: classes.dex */
public interface DeviceListener {
    void onCharacteristicChanged(UUID r1, UUID r2, byte[] bArr);

    void onConnected();

    void onDisconnected();
}
