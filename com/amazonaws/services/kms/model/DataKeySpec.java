package com.amazonaws.services.kms.model;

import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum DataKeySpec {
    AES_256("AES_256"),
    AES_128("AES_128");

    private static final Map<String, DataKeySpec> enumMap;
    private String value;

    static {
        DataKeySpec dataKeySpec = AES_256;
        DataKeySpec dataKeySpec2 = AES_128;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("AES_256", dataKeySpec);
        hashMap.put("AES_128", dataKeySpec2);
    }

    DataKeySpec(String str) {
        this.value = str;
    }

    public static DataKeySpec fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, DataKeySpec> map = enumMap;
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
