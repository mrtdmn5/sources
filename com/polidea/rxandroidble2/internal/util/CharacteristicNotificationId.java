package com.polidea.rxandroidble2.internal.util;

import android.util.Pair;
import java.util.UUID;

/* loaded from: classes3.dex */
public class CharacteristicNotificationId extends Pair<UUID, Integer> {
    public CharacteristicNotificationId(UUID r1, Integer num) {
        super(r1, num);
    }

    @Override // android.util.Pair
    public String toString() {
        return "CharacteristicNotificationId{UUID=" + ((UUID) ((Pair) this).first).toString() + ", instanceId=" + ((Integer) ((Pair) this).second).toString() + '}';
    }
}
