package com.polidea.rxandroidble2.exceptions;

/* loaded from: classes3.dex */
public class BleCannotSetCharacteristicNotificationException extends BleException {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BleCannotSetCharacteristicNotificationException(android.bluetooth.BluetoothGattCharacteristic r3, int r4, java.lang.Throwable r5) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 1
            if (r4 == r1) goto L17
            r1 = 2
            if (r4 == r1) goto L14
            r1 = 3
            if (r4 == r1) goto L11
            java.lang.String r1 = "Unknown error"
            goto L19
        L11:
            java.lang.String r1 = "Cannot write client characteristic config descriptor"
            goto L19
        L14:
            java.lang.String r1 = "Cannot find client characteristic config descriptor"
            goto L19
        L17:
            java.lang.String r1 = "Cannot set local notification"
        L19:
            r0.append(r1)
            java.lang.String r1 = " (code "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r4 = ") with characteristic UUID "
            r0.append(r4)
            java.util.UUID r3 = r3.getUuid()
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r2.<init>(r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.polidea.rxandroidble2.exceptions.BleCannotSetCharacteristicNotificationException.<init>(android.bluetooth.BluetoothGattCharacteristic, int, java.lang.Throwable):void");
    }
}
