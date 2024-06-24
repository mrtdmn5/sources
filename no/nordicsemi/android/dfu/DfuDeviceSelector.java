package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothDevice;

/* loaded from: classes4.dex */
public interface DfuDeviceSelector {
    boolean matches(BluetoothDevice bluetoothDevice, int r2, byte[] bArr, String str, String str2);
}
