package com.amazonaws.services.kms.model;

import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum MultiRegionKeyType {
    PRIMARY("PRIMARY"),
    REPLICA("REPLICA");

    private static final Map<String, MultiRegionKeyType> enumMap;
    private String value;

    static {
        MultiRegionKeyType multiRegionKeyType = PRIMARY;
        MultiRegionKeyType multiRegionKeyType2 = REPLICA;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("PRIMARY", multiRegionKeyType);
        hashMap.put("REPLICA", multiRegionKeyType2);
    }

    MultiRegionKeyType(String str) {
        this.value = str;
    }

    public static MultiRegionKeyType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, MultiRegionKeyType> map = enumMap;
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
