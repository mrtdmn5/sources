package com.amazonaws.services.cognitoidentity.model;

import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum ErrorCode {
    AccessDenied("AccessDenied"),
    InternalServerError("InternalServerError");

    private static final Map<String, ErrorCode> enumMap;
    private String value;

    static {
        ErrorCode errorCode = AccessDenied;
        ErrorCode errorCode2 = InternalServerError;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("AccessDenied", errorCode);
        hashMap.put("InternalServerError", errorCode2);
    }

    ErrorCode(String str) {
        this.value = str;
    }

    public static ErrorCode fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, ErrorCode> map = enumMap;
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
