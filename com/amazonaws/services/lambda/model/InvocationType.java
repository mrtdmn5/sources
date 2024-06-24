package com.amazonaws.services.lambda.model;

import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum InvocationType {
    Event("Event"),
    RequestResponse("RequestResponse"),
    DryRun("DryRun");

    private static final Map<String, InvocationType> enumMap;
    private String value;

    static {
        InvocationType invocationType = Event;
        InvocationType invocationType2 = RequestResponse;
        InvocationType invocationType3 = DryRun;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("Event", invocationType);
        hashMap.put("RequestResponse", invocationType2);
        hashMap.put("DryRun", invocationType3);
    }

    InvocationType(String str) {
        this.value = str;
    }

    public static InvocationType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, InvocationType> map = enumMap;
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
