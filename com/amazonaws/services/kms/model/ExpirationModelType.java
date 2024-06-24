package com.amazonaws.services.kms.model;

import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum ExpirationModelType {
    KEY_MATERIAL_EXPIRES("KEY_MATERIAL_EXPIRES"),
    KEY_MATERIAL_DOES_NOT_EXPIRE("KEY_MATERIAL_DOES_NOT_EXPIRE");

    private static final Map<String, ExpirationModelType> enumMap;
    private String value;

    static {
        ExpirationModelType expirationModelType = KEY_MATERIAL_EXPIRES;
        ExpirationModelType expirationModelType2 = KEY_MATERIAL_DOES_NOT_EXPIRE;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("KEY_MATERIAL_EXPIRES", expirationModelType);
        hashMap.put("KEY_MATERIAL_DOES_NOT_EXPIRE", expirationModelType2);
    }

    ExpirationModelType(String str) {
        this.value = str;
    }

    public static ExpirationModelType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, ExpirationModelType> map = enumMap;
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
