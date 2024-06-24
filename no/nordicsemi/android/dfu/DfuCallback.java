package no.nordicsemi.android.dfu;

import android.bluetooth.BluetoothGattCallback;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public interface DfuCallback extends DfuController {
    DfuGattCallback getGattCallback();

    void onBondStateChanged(int r1);

    /* loaded from: classes4.dex */
    public static class DfuGattCallback extends BluetoothGattCallback {
        public void onDisconnected() {
        }
    }
}
