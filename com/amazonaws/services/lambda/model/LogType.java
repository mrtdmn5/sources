package com.amazonaws.services.lambda.model;

import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum LogType {
    None("None"),
    Tail("Tail");

    private static final Map<String, LogType> enumMap;
    private String value;

    static {
        LogType logType = None;
        LogType logType2 = Tail;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("None", logType);
        hashMap.put("Tail", logType2);
    }

    LogType(String str) {
        this.value = str;
    }

    public static LogType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, LogType> map = enumMap;
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
