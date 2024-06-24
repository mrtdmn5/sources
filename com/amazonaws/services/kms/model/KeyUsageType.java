package com.amazonaws.services.kms.model;

import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum KeyUsageType {
    SIGN_VERIFY("SIGN_VERIFY"),
    ENCRYPT_DECRYPT("ENCRYPT_DECRYPT"),
    GENERATE_VERIFY_MAC("GENERATE_VERIFY_MAC");

    private static final Map<String, KeyUsageType> enumMap;
    private String value;

    static {
        KeyUsageType keyUsageType = SIGN_VERIFY;
        KeyUsageType keyUsageType2 = ENCRYPT_DECRYPT;
        KeyUsageType keyUsageType3 = GENERATE_VERIFY_MAC;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("SIGN_VERIFY", keyUsageType);
        hashMap.put("ENCRYPT_DECRYPT", keyUsageType2);
        hashMap.put("GENERATE_VERIFY_MAC", keyUsageType3);
    }

    KeyUsageType(String str) {
        this.value = str;
    }

    public static KeyUsageType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, KeyUsageType> map = enumMap;
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
