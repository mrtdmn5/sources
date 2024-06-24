package com.polidea.rxandroidble2.internal.util;

import com.polidea.rxandroidble2.internal.RxBleLog;

/* loaded from: classes3.dex */
public final class CharacteristicPropertiesParser {
    public final int propertyBroadcast = 1;
    public final int propertyRead = 2;
    public final int propertyWriteNoResponse = 4;
    public final int propertyWrite = 8;
    public final int propertyNotify = 16;
    public final int propertyIndicate = 32;
    public final int propertySignedWrite = 64;
    public final int[] possibleProperties = {1, 2, 4, 8, 16, 32, 64};

    public final String propertiesIntToString(int r11) {
        boolean z;
        String str;
        StringBuilder sb = new StringBuilder("[ ");
        for (int r5 : this.possibleProperties) {
            if ((r11 & r5) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (r5 == this.propertyRead) {
                    str = "READ";
                } else if (r5 == this.propertyWrite) {
                    str = "WRITE";
                } else if (r5 == this.propertyWriteNoResponse) {
                    str = "WRITE_NO_RESPONSE";
                } else if (r5 == this.propertySignedWrite) {
                    str = "SIGNED_WRITE";
                } else if (r5 == this.propertyIndicate) {
                    str = "INDICATE";
                } else if (r5 == this.propertyBroadcast) {
                    str = "BROADCAST";
                } else if (r5 == this.propertyNotify) {
                    str = "NOTIFY";
                } else if (r5 == 0) {
                    str = "";
                } else {
                    RxBleLog.throwShade(6, null, "Unknown property specified (%d)", Integer.valueOf(r5));
                    str = "UNKNOWN (" + r5 + " -> check android.bluetooth.BluetoothGattCharacteristic)";
                }
                sb.append(str);
                sb.append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
