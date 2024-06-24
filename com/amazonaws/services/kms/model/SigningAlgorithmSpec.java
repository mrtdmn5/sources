package com.amazonaws.services.kms.model;

import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum SigningAlgorithmSpec {
    RSASSA_PSS_SHA_256("RSASSA_PSS_SHA_256"),
    RSASSA_PSS_SHA_384("RSASSA_PSS_SHA_384"),
    RSASSA_PSS_SHA_512("RSASSA_PSS_SHA_512"),
    RSASSA_PKCS1_V1_5_SHA_256("RSASSA_PKCS1_V1_5_SHA_256"),
    RSASSA_PKCS1_V1_5_SHA_384("RSASSA_PKCS1_V1_5_SHA_384"),
    RSASSA_PKCS1_V1_5_SHA_512("RSASSA_PKCS1_V1_5_SHA_512"),
    ECDSA_SHA_256("ECDSA_SHA_256"),
    ECDSA_SHA_384("ECDSA_SHA_384"),
    ECDSA_SHA_512("ECDSA_SHA_512"),
    SM2DSA("SM2DSA");

    private static final Map<String, SigningAlgorithmSpec> enumMap;
    private String value;

    static {
        SigningAlgorithmSpec signingAlgorithmSpec = RSASSA_PSS_SHA_256;
        SigningAlgorithmSpec signingAlgorithmSpec2 = RSASSA_PSS_SHA_384;
        SigningAlgorithmSpec signingAlgorithmSpec3 = RSASSA_PSS_SHA_512;
        SigningAlgorithmSpec signingAlgorithmSpec4 = RSASSA_PKCS1_V1_5_SHA_256;
        SigningAlgorithmSpec signingAlgorithmSpec5 = RSASSA_PKCS1_V1_5_SHA_384;
        SigningAlgorithmSpec signingAlgorithmSpec6 = RSASSA_PKCS1_V1_5_SHA_512;
        SigningAlgorithmSpec signingAlgorithmSpec7 = ECDSA_SHA_256;
        SigningAlgorithmSpec signingAlgorithmSpec8 = ECDSA_SHA_384;
        SigningAlgorithmSpec signingAlgorithmSpec9 = ECDSA_SHA_512;
        SigningAlgorithmSpec signingAlgorithmSpec10 = SM2DSA;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("RSASSA_PSS_SHA_256", signingAlgorithmSpec);
        hashMap.put("RSASSA_PSS_SHA_384", signingAlgorithmSpec2);
        hashMap.put("RSASSA_PSS_SHA_512", signingAlgorithmSpec3);
        hashMap.put("RSASSA_PKCS1_V1_5_SHA_256", signingAlgorithmSpec4);
        hashMap.put("RSASSA_PKCS1_V1_5_SHA_384", signingAlgorithmSpec5);
        hashMap.put("RSASSA_PKCS1_V1_5_SHA_512", signingAlgorithmSpec6);
        hashMap.put("ECDSA_SHA_256", signingAlgorithmSpec7);
        hashMap.put("ECDSA_SHA_384", signingAlgorithmSpec8);
        hashMap.put("ECDSA_SHA_512", signingAlgorithmSpec9);
        hashMap.put("SM2DSA", signingAlgorithmSpec10);
    }

    SigningAlgorithmSpec(String str) {
        this.value = str;
    }

    public static SigningAlgorithmSpec fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, SigningAlgorithmSpec> map = enumMap;
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
