package com.amazonaws.services.kms.model;

import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum WrappingKeySpec {
    RSA_2048("RSA_2048");

    private static final Map<String, WrappingKeySpec> enumMap;
    private String value;

    static {
        WrappingKeySpec wrappingKeySpec = RSA_2048;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("RSA_2048", wrappingKeySpec);
    }

    WrappingKeySpec(String str) {
        this.value = str;
    }

    public static WrappingKeySpec fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, WrappingKeySpec> map = enumMap;
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
