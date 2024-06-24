package com.polidea.rxandroidble2.internal.util;

import android.util.Pair;
import java.util.Arrays;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class CharacteristicChangedEvent extends CharacteristicNotificationId {
    public final byte[] data;

    public CharacteristicChangedEvent(UUID r1, Integer num, byte[] bArr) {
        super(r1, num);
        this.data = bArr;
    }

    @Override // android.util.Pair
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CharacteristicChangedEvent)) {
            if ((obj instanceof CharacteristicNotificationId) && super.equals(obj)) {
                return true;
            }
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        return Arrays.equals(this.data, ((CharacteristicChangedEvent) obj).data);
    }

    @Override // android.util.Pair
    public final int hashCode() {
        return Arrays.hashCode(this.data) + (super.hashCode() * 31);
    }

    @Override // com.polidea.rxandroidble2.internal.util.CharacteristicNotificationId, android.util.Pair
    public final String toString() {
        return "CharacteristicChangedEvent{UUID=" + ((UUID) ((Pair) this).first).toString() + ", instanceId=" + ((Integer) ((Pair) this).second).toString() + ", data=" + Arrays.toString(this.data) + '}';
    }
}
