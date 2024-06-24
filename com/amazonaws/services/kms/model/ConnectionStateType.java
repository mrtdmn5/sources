package com.amazonaws.services.kms.model;

import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum ConnectionStateType {
    CONNECTED("CONNECTED"),
    CONNECTING("CONNECTING"),
    FAILED("FAILED"),
    DISCONNECTED("DISCONNECTED"),
    DISCONNECTING("DISCONNECTING");

    private static final Map<String, ConnectionStateType> enumMap;
    private String value;

    static {
        ConnectionStateType connectionStateType = CONNECTED;
        ConnectionStateType connectionStateType2 = CONNECTING;
        ConnectionStateType connectionStateType3 = FAILED;
        ConnectionStateType connectionStateType4 = DISCONNECTED;
        ConnectionStateType connectionStateType5 = DISCONNECTING;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("CONNECTED", connectionStateType);
        hashMap.put("CONNECTING", connectionStateType2);
        hashMap.put("FAILED", connectionStateType3);
        hashMap.put("DISCONNECTED", connectionStateType4);
        hashMap.put("DISCONNECTING", connectionStateType5);
    }

    ConnectionStateType(String str) {
        this.value = str;
    }

    public static ConnectionStateType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, ConnectionStateType> map = enumMap;
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
