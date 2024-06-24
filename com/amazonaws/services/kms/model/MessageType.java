package com.amazonaws.services.kms.model;

import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum MessageType {
    RAW("RAW"),
    DIGEST("DIGEST");

    private static final Map<String, MessageType> enumMap;
    private String value;

    static {
        MessageType messageType = RAW;
        MessageType messageType2 = DIGEST;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("RAW", messageType);
        hashMap.put("DIGEST", messageType2);
    }

    MessageType(String str) {
        this.value = str;
    }

    public static MessageType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, MessageType> map = enumMap;
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
