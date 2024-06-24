package com.animaconnected.dfu.fota;

import android.bluetooth.BluetoothGattDescriptor;
import com.animaconnected.bluetooth.gatt.GattDevice;
import com.animaconnected.bluetooth.util.Callback;
import com.animaconnected.dfu.fota.utils.FotaConstants;
import com.animaconnected.dfu.fota.utils.FotaUtilities;
import com.animaconnected.info.ByteUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FotaCommands {
    private final GattDevice mDevice;

    public FotaCommands(GattDevice gattDevice) {
        this.mDevice = gattDevice;
    }

    private void write(byte[] bArr) {
        write(bArr, null);
    }

    public void sendInitPackage(int r4, long j) {
        byte[] bArr = new byte[9];
        bArr[0] = 2;
        ByteUtils.encodeUInt32LE(r4, bArr, 1);
        ByteUtils.encodeUInt32LE(j, bArr, 5);
        write(bArr);
    }

    public void sendPageData(byte[] bArr, Callback<Void> callback) {
        write(FotaUtilities.addtoArray(new byte[]{4}, bArr), callback);
    }

    public void sendPageEnd() {
        write(new byte[]{5});
    }

    public void sendPageStart(long j, int r6, long j2) {
        byte[] bArr = new byte[8];
        bArr[0] = 3;
        bArr[1] = (byte) j;
        ByteUtils.encodeUInt16LE(r6, bArr, 2);
        ByteUtils.encodeUInt32LE(j2, bArr, 4);
        write(bArr);
    }

    public void sendPerformFota() {
        write(new byte[]{6});
    }

    public void sendStatus() {
        write(new byte[]{1});
    }

    public void sendVerifyFota() {
        write(new byte[]{7});
    }

    public void setNotificationsForTX() {
        if (this.mDevice.isConnected()) {
            this.mDevice.setNotification(FotaConstants.FOTA_SERVICE, FotaConstants.FOTA_TX_CHARACTERISTIC, BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
        }
    }

    private void write(byte[] bArr, Callback<Void> callback) {
        if (this.mDevice.isConnected()) {
            this.mDevice.write(FotaConstants.FOTA_SERVICE, FotaConstants.FOTA_RX_CHARACTERISTIC, bArr, callback);
        } else if (callback != null) {
            callback.onError(new RuntimeException("Not connected"));
        }
    }
}
