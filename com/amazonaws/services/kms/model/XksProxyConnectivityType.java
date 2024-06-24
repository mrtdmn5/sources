package com.amazonaws.services.kms.model;

import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum XksProxyConnectivityType {
    PUBLIC_ENDPOINT("PUBLIC_ENDPOINT"),
    VPC_ENDPOINT_SERVICE("VPC_ENDPOINT_SERVICE");

    private static final Map<String, XksProxyConnectivityType> enumMap;
    private String value;

    static {
        XksProxyConnectivityType xksProxyConnectivityType = PUBLIC_ENDPOINT;
        XksProxyConnectivityType xksProxyConnectivityType2 = VPC_ENDPOINT_SERVICE;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("PUBLIC_ENDPOINT", xksProxyConnectivityType);
        hashMap.put("VPC_ENDPOINT_SERVICE", xksProxyConnectivityType2);
    }

    XksProxyConnectivityType(String str) {
        this.value = str;
    }

    public static XksProxyConnectivityType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, XksProxyConnectivityType> map = enumMap;
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
