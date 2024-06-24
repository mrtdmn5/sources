package com.amplifyframework.auth.cognito.helpers;

import android.util.Base64;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CognitoDeviceHelper.kt */
/* loaded from: classes.dex */
public final class CognitoDeviceHelper {
    public static final CognitoDeviceHelper INSTANCE = new CognitoDeviceHelper();
    public static final int SALT_LENGTH_BITS = 128;

    private CognitoDeviceHelper() {
    }

    public final Map<String, String> generateVerificationParameters(String deviceKey, String deviceGroup) {
        Intrinsics.checkNotNullParameter(deviceKey, "deviceKey");
        Intrinsics.checkNotNullParameter(deviceGroup, "deviceGroup");
        String str = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(str, "randomUUID().toString()");
        BigInteger bigInteger = new BigInteger(128, new SecureRandom());
        SRPHelper sRPHelper = new SRPHelper(str);
        sRPHelper.setUserPoolParams(deviceKey, deviceGroup);
        BigInteger computePasswordVerifier$aws_auth_cognito_release = sRPHelper.computePasswordVerifier$aws_auth_cognito_release(bigInteger);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String encodeToString = Base64.encodeToString(bigInteger.toByteArray(), 2);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(salt.toBy…roid.util.Base64.NO_WRAP)");
        linkedHashMap.put("salt", encodeToString);
        String encodeToString2 = Base64.encodeToString(computePasswordVerifier$aws_auth_cognito_release.toByteArray(), 2);
        Intrinsics.checkNotNullExpressionValue(encodeToString2, "encodeToString(verifier.…roid.util.Base64.NO_WRAP)");
        linkedHashMap.put("verifier", encodeToString2);
        linkedHashMap.put("secret", str);
        return linkedHashMap;
    }
}
