package com.amazonaws.services.kms.model;

import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum KeyManagerType {
    AWS("AWS"),
    CUSTOMER("CUSTOMER");

    private static final Map<String, KeyManagerType> enumMap;
    private String value;

    static {
        KeyManagerType keyManagerType = AWS;
        KeyManagerType keyManagerType2 = CUSTOMER;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("AWS", keyManagerType);
        hashMap.put("CUSTOMER", keyManagerType2);
    }

    KeyManagerType(String str) {
        this.value = str;
    }

    public static KeyManagerType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, KeyManagerType> map = enumMap;
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
