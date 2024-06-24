package com.amazonaws.services.kms.model;

import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum DataKeyPairSpec {
    RSA_2048("RSA_2048"),
    RSA_3072("RSA_3072"),
    RSA_4096("RSA_4096"),
    ECC_NIST_P256("ECC_NIST_P256"),
    ECC_NIST_P384("ECC_NIST_P384"),
    ECC_NIST_P521("ECC_NIST_P521"),
    ECC_SECG_P256K1("ECC_SECG_P256K1"),
    SM2("SM2");

    private static final Map<String, DataKeyPairSpec> enumMap;
    private String value;

    static {
        DataKeyPairSpec dataKeyPairSpec = RSA_2048;
        DataKeyPairSpec dataKeyPairSpec2 = RSA_3072;
        DataKeyPairSpec dataKeyPairSpec3 = RSA_4096;
        DataKeyPairSpec dataKeyPairSpec4 = ECC_NIST_P256;
        DataKeyPairSpec dataKeyPairSpec5 = ECC_NIST_P384;
        DataKeyPairSpec dataKeyPairSpec6 = ECC_NIST_P521;
        DataKeyPairSpec dataKeyPairSpec7 = ECC_SECG_P256K1;
        DataKeyPairSpec dataKeyPairSpec8 = SM2;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("RSA_2048", dataKeyPairSpec);
        hashMap.put("RSA_3072", dataKeyPairSpec2);
        hashMap.put("RSA_4096", dataKeyPairSpec3);
        hashMap.put("ECC_NIST_P256", dataKeyPairSpec4);
        hashMap.put("ECC_NIST_P384", dataKeyPairSpec5);
        hashMap.put("ECC_NIST_P521", dataKeyPairSpec6);
        hashMap.put("ECC_SECG_P256K1", dataKeyPairSpec7);
        hashMap.put("SM2", dataKeyPairSpec8);
    }

    DataKeyPairSpec(String str) {
        this.value = str;
    }

    public static DataKeyPairSpec fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, DataKeyPairSpec> map = enumMap;
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
