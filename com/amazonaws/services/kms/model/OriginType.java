package com.amazonaws.services.kms.model;

import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum OriginType {
    AWS_KMS("AWS_KMS"),
    EXTERNAL("EXTERNAL"),
    AWS_CLOUDHSM("AWS_CLOUDHSM"),
    EXTERNAL_KEY_STORE("EXTERNAL_KEY_STORE");

    private static final Map<String, OriginType> enumMap;
    private String value;

    static {
        OriginType originType = AWS_KMS;
        OriginType originType2 = EXTERNAL;
        OriginType originType3 = AWS_CLOUDHSM;
        OriginType originType4 = EXTERNAL_KEY_STORE;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("AWS_KMS", originType);
        hashMap.put("EXTERNAL", originType2);
        hashMap.put("AWS_CLOUDHSM", originType3);
        hashMap.put("EXTERNAL_KEY_STORE", originType4);
    }

    OriginType(String str) {
        this.value = str;
    }

    public static OriginType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, OriginType> map = enumMap;
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
