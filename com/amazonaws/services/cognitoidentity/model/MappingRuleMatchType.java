package com.amazonaws.services.cognitoidentity.model;

import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum MappingRuleMatchType {
    Equals("Equals"),
    Contains("Contains"),
    StartsWith("StartsWith"),
    NotEqual("NotEqual");

    private static final Map<String, MappingRuleMatchType> enumMap;
    private String value;

    static {
        MappingRuleMatchType mappingRuleMatchType = Equals;
        MappingRuleMatchType mappingRuleMatchType2 = Contains;
        MappingRuleMatchType mappingRuleMatchType3 = StartsWith;
        MappingRuleMatchType mappingRuleMatchType4 = NotEqual;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("Equals", mappingRuleMatchType);
        hashMap.put("Contains", mappingRuleMatchType2);
        hashMap.put("StartsWith", mappingRuleMatchType3);
        hashMap.put("NotEqual", mappingRuleMatchType4);
    }

    MappingRuleMatchType(String str) {
        this.value = str;
    }

    public static MappingRuleMatchType fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, MappingRuleMatchType> map = enumMap;
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
