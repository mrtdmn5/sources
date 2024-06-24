package com.amplifyframework.auth.cognito.helpers;

import android.util.Base64;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.SecureRandom;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PkceHelper.kt */
/* loaded from: classes.dex */
public final class PkceHelper {
    public static final PkceHelper INSTANCE = new PkceHelper();

    private PkceHelper() {
    }

    public final String encodeBase64(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        Charset forName = Charset.forName("ISO-8859-1");
        Intrinsics.checkNotNullExpressionValue(forName, "forName(\"ISO-8859-1\")");
        byte[] bytes = str.getBytes(forName);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        String encodeToString = Base64.encodeToString(bytes, 3);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(data, Bas…ADDING or Base64.NO_WRAP)");
        return encodeToString;
    }

    public final String generateHash(String data) throws Exception {
        Intrinsics.checkNotNullParameter(data, "data");
        Charset forName = Charset.forName("US-ASCII");
        Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
        byte[] bytes = data.getBytes(forName);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(bytes, 0, bytes.length);
        String encodeToString = Base64.encodeToString(messageDigest.digest(), 11);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "{\n            val bytes …G\n            )\n        }");
        return encodeToString;
    }

    public final String generateRandom() {
        byte[] bArr = new byte[32];
        new SecureRandom().nextBytes(bArr);
        String encodeToString = Base64.encodeToString(bArr, 11);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(\n        …se64.NO_PADDING\n        )");
        return encodeToString;
    }
}
