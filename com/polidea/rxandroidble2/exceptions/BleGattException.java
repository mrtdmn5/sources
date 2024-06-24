package com.polidea.rxandroidble2.exceptions;

/* loaded from: classes3.dex */
public class BleGattException extends BleException {
    public final BleGattOperationType bleGattOperationType;
    public final int status;

    public BleGattException() {
        throw null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BleGattException(android.bluetooth.BluetoothGatt r8, int r9, com.polidea.rxandroidble2.exceptions.BleGattOperationType r10) {
        /*
            r7 = this;
            r0 = -1
            if (r9 != r0) goto L25
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            if (r8 == 0) goto L17
            android.bluetooth.BluetoothDevice r1 = r8.getDevice()
            if (r1 == 0) goto L17
            android.bluetooth.BluetoothDevice r8 = r8.getDevice()
            java.lang.String r8 = r8.getAddress()
            goto L18
        L17:
            r8 = 0
        L18:
            r1 = 0
            r0[r1] = r8
            r8 = 1
            r0[r8] = r10
            java.lang.String r8 = "GATT exception from MAC address %s, with type %s"
            java.lang.String r8 = java.lang.String.format(r8, r0)
            goto L4f
        L25:
            java.util.Map<java.lang.Integer, java.lang.String> r0 = com.polidea.rxandroidble2.utils.GattStatusParser.GATT_STATUS
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L35
            java.lang.String r0 = "UNKNOWN"
        L35:
            r3 = r0
            java.lang.String r1 = com.polidea.rxandroidble2.internal.logger.LoggerUtil.commonMacMessage(r8)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r9)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r9)
            java.lang.String r6 = "https://cs.android.com/android/platform/superproject/+/master:packages/modules/Bluetooth/system/stack/include/gatt_api.h"
            r4 = r10
            java.lang.Object[] r8 = new java.lang.Object[]{r1, r2, r3, r4, r5, r6}
            java.lang.String r0 = "GATT exception from %s, status %d (%s), type %s. (Look up status 0x%02x here %s)"
            java.lang.String r8 = java.lang.String.format(r0, r8)
        L4f:
            r7.<init>(r8)
            r7.status = r9
            r7.bleGattOperationType = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.polidea.rxandroidble2.exceptions.BleGattException.<init>(android.bluetooth.BluetoothGatt, int, com.polidea.rxandroidble2.exceptions.BleGattOperationType):void");
    }
}
