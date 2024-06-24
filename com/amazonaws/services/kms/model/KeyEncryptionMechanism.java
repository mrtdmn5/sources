package com.amazonaws.services.kms.model;

import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum KeyEncryptionMechanism {
    RSAES_OAEP_SHA_256("RSAES_OAEP_SHA_256");

    private static final Map<String, KeyEncryptionMechanism> enumMap;
    private String value;

    static {
        KeyEncryptionMechanism keyEncryptionMechanism = RSAES_OAEP_SHA_256;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("RSAES_OAEP_SHA_256", keyEncryptionMechanism);
    }

    KeyEncryptionMechanism(String str) {
        this.value = str;
    }

    public static KeyEncryptionMechanism fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, KeyEncryptionMechanism> map = enumMap;
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
