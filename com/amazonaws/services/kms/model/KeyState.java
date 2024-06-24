package com.amazonaws.services.kms.model;

import com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum KeyState {
    Creating("Creating"),
    Enabled("Enabled"),
    Disabled(BucketLifecycleConfiguration.DISABLED),
    PendingDeletion("PendingDeletion"),
    PendingImport("PendingImport"),
    PendingReplicaDeletion("PendingReplicaDeletion"),
    Unavailable("Unavailable"),
    Updating("Updating");

    private static final Map<String, KeyState> enumMap;
    private String value;

    static {
        KeyState keyState = Creating;
        KeyState keyState2 = Enabled;
        KeyState keyState3 = Disabled;
        KeyState keyState4 = PendingDeletion;
        KeyState keyState5 = PendingImport;
        KeyState keyState6 = PendingReplicaDeletion;
        KeyState keyState7 = Unavailable;
        KeyState keyState8 = Updating;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("Creating", keyState);
        hashMap.put("Enabled", keyState2);
        hashMap.put(BucketLifecycleConfiguration.DISABLED, keyState3);
        hashMap.put("PendingDeletion", keyState4);
        hashMap.put("PendingImport", keyState5);
        hashMap.put("PendingReplicaDeletion", keyState6);
        hashMap.put("Unavailable", keyState7);
        hashMap.put("Updating", keyState8);
    }

    KeyState(String str) {
        this.value = str;
    }

    public static KeyState fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, KeyState> map = enumMap;
            if (map.containsKey(str)) {
                return map.get(str);
            }
            throw new IllegalArgumentException(zzav$$ExternalSyntheticOutline0.m("Cannot create enum from ", str, " value!"));
        }
        throw new IllegalArgumentException("Value cannot be null or empty!");
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}
