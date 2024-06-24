package com.amazonaws.services.kms.model;

import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum CustomKeyStoreType {
    AWS_CLOUDHSM("AWS_CLOUDHSM"),
    EXTERNAL_KEY_STORE("EXTERNAL_KEY_STORE");

    private static final Map<String, CustomKeyStoreType> enumMap;
    private String value;

    static {
        CustomKeyStoreType customKeyStoreType = AWS_CLOUDHSM;
        CustomKeyStoreType customKeyStoreType2 = EXTERNAL_KEY_STORE;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("AWS_CLOUDHSM", customKeyStoreType);
        hashMap.put("EXTERNAL_KEY_STORE", customKeyStoreType2);
    }

    CustomKeyStoreType(String str) {
        this.value = str;
    }

    public static CustomKeyStoreType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, CustomKeyStoreType> map = enumMap;
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
