package com.amazonaws.services.cognitoidentity.model;

import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum AmbiguousRoleResolutionType {
    AuthenticatedRole("AuthenticatedRole"),
    Deny("Deny");

    private static final Map<String, AmbiguousRoleResolutionType> enumMap;
    private String value;

    static {
        AmbiguousRoleResolutionType ambiguousRoleResolutionType = AuthenticatedRole;
        AmbiguousRoleResolutionType ambiguousRoleResolutionType2 = Deny;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("AuthenticatedRole", ambiguousRoleResolutionType);
        hashMap.put("Deny", ambiguousRoleResolutionType2);
    }

    AmbiguousRoleResolutionType(String str) {
        this.value = str;
    }

    public static AmbiguousRoleResolutionType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, AmbiguousRoleResolutionType> map = enumMap;
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
