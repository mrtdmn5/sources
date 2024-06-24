package com.amazonaws.services.kms.model;

import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum MacAlgorithmSpec {
    HMAC_SHA_224("HMAC_SHA_224"),
    HMAC_SHA_256("HMAC_SHA_256"),
    HMAC_SHA_384("HMAC_SHA_384"),
    HMAC_SHA_512("HMAC_SHA_512");

    private static final Map<String, MacAlgorithmSpec> enumMap;
    private String value;

    static {
        MacAlgorithmSpec macAlgorithmSpec = HMAC_SHA_224;
        MacAlgorithmSpec macAlgorithmSpec2 = HMAC_SHA_256;
        MacAlgorithmSpec macAlgorithmSpec3 = HMAC_SHA_384;
        MacAlgorithmSpec macAlgorithmSpec4 = HMAC_SHA_512;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("HMAC_SHA_224", macAlgorithmSpec);
        hashMap.put("HMAC_SHA_256", macAlgorithmSpec2);
        hashMap.put("HMAC_SHA_384", macAlgorithmSpec3);
        hashMap.put("HMAC_SHA_512", macAlgorithmSpec4);
    }

    MacAlgorithmSpec(String str) {
        this.value = str;
    }

    public static MacAlgorithmSpec fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, MacAlgorithmSpec> map = enumMap;
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
