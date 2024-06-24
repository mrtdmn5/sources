package com.amazonaws.services.kms.model;

import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum GrantOperation {
    Decrypt("Decrypt"),
    Encrypt("Encrypt"),
    GenerateDataKey("GenerateDataKey"),
    GenerateDataKeyWithoutPlaintext("GenerateDataKeyWithoutPlaintext"),
    ReEncryptFrom("ReEncryptFrom"),
    ReEncryptTo("ReEncryptTo"),
    Sign("Sign"),
    Verify("Verify"),
    GetPublicKey("GetPublicKey"),
    CreateGrant("CreateGrant"),
    RetireGrant("RetireGrant"),
    DescribeKey("DescribeKey"),
    GenerateDataKeyPair("GenerateDataKeyPair"),
    GenerateDataKeyPairWithoutPlaintext("GenerateDataKeyPairWithoutPlaintext"),
    GenerateMac("GenerateMac"),
    VerifyMac("VerifyMac");

    private static final Map<String, GrantOperation> enumMap;
    private String value;

    static {
        GrantOperation grantOperation = Decrypt;
        GrantOperation grantOperation2 = Encrypt;
        GrantOperation grantOperation3 = GenerateDataKey;
        GrantOperation grantOperation4 = GenerateDataKeyWithoutPlaintext;
        GrantOperation grantOperation5 = ReEncryptFrom;
        GrantOperation grantOperation6 = ReEncryptTo;
        GrantOperation grantOperation7 = Sign;
        GrantOperation grantOperation8 = Verify;
        GrantOperation grantOperation9 = GetPublicKey;
        GrantOperation grantOperation10 = CreateGrant;
        GrantOperation grantOperation11 = RetireGrant;
        GrantOperation grantOperation12 = DescribeKey;
        GrantOperation grantOperation13 = GenerateDataKeyPair;
        GrantOperation grantOperation14 = GenerateDataKeyPairWithoutPlaintext;
        GrantOperation grantOperation15 = GenerateMac;
        GrantOperation grantOperation16 = VerifyMac;
        HashMap hashMap = new HashMap();
        enumMap = hashMap;
        hashMap.put("Decrypt", grantOperation);
        hashMap.put("Encrypt", grantOperation2);
        hashMap.put("GenerateDataKey", grantOperation3);
        hashMap.put("GenerateDataKeyWithoutPlaintext", grantOperation4);
        hashMap.put("ReEncryptFrom", grantOperation5);
        hashMap.put("ReEncryptTo", grantOperation6);
        hashMap.put("Sign", grantOperation7);
        hashMap.put("Verify", grantOperation8);
        hashMap.put("GetPublicKey", grantOperation9);
        hashMap.put("CreateGrant", grantOperation10);
        hashMap.put("RetireGrant", grantOperation11);
        hashMap.put("DescribeKey", grantOperation12);
        hashMap.put("GenerateDataKeyPair", grantOperation13);
        hashMap.put("GenerateDataKeyPairWithoutPlaintext", grantOperation14);
        hashMap.put("GenerateMac", grantOperation15);
        hashMap.put("VerifyMac", grantOperation16);
    }

    GrantOperation(String str) {
        this.value = str;
    }

    public static GrantOperation fromValue(String str) {
        if (str != null && !str.isEmpty()) {
            Map<String, GrantOperation> map = enumMap;
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
