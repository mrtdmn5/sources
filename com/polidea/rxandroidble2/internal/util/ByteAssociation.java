package com.polidea.rxandroidble2.internal.util;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticOutline0;
import java.util.Arrays;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class ByteAssociation<T> {
    public final T first;
    public final byte[] second;

    public ByteAssociation(T t, byte[] bArr) {
        this.first = t;
        this.second = bArr;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ByteAssociation)) {
            return false;
        }
        ByteAssociation byteAssociation = (ByteAssociation) obj;
        if (!Arrays.equals(byteAssociation.second, this.second) || !byteAssociation.first.equals(this.first)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.first.hashCode() ^ Arrays.hashCode(this.second);
    }

    public final String toString() {
        String simpleName;
        T t = this.first;
        if (t instanceof BluetoothGattCharacteristic) {
            simpleName = "BluetoothGattCharacteristic(" + ((BluetoothGattCharacteristic) t).getUuid().toString() + ")";
        } else if (t instanceof BluetoothGattDescriptor) {
            simpleName = "BluetoothGattDescriptor(" + ((BluetoothGattDescriptor) t).getUuid().toString() + ")";
        } else if (t instanceof UUID) {
            simpleName = "UUID(" + t.toString() + ")";
        } else {
            simpleName = t.getClass().getSimpleName();
        }
        StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("ByteAssociation[first=", simpleName, ", second=");
        m.append(Arrays.toString(this.second));
        m.append("]");
        return m.toString();
    }
}
