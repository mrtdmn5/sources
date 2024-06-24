package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothDevice;

/* loaded from: classes4.dex */
class DfuDefaultDeviceSelector implements DfuDeviceSelector {
    @Override // no.nordicsemi.android.dfu.DfuDeviceSelector
    public boolean matches(BluetoothDevice bluetoothDevice, int r2, byte[] bArr, String str, String str2) {
        if (!str.equals(bluetoothDevice.getAddress()) && !str2.equals(bluetoothDevice.getAddress())) {
            return false;
        }
        return true;
    }
}
