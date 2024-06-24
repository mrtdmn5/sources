package com.amplifyframework.auth.cognito.helpers;

import android.util.Base64;
import com.amplifyframework.auth.cognito.exceptions.service.InvalidParameterException;
import com.amplifyframework.auth.exceptions.UnknownException;
import java.nio.charset.Charset;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: AuthHelper.kt */
/* loaded from: classes.dex */
public class AuthHelper {
    public static final Companion Companion = new Companion(null);
    private static final String HMAC_SHA_256 = "HmacSHA256";

    /* compiled from: AuthHelper.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getHMAC_SHA_256() {
            return AuthHelper.HMAC_SHA_256;
        }

        public final String getSecretHash(String str, String str2, String str3) {
            boolean z;
            if (str != null) {
                if (str2 != null) {
                    if (str3 != null && str3.length() != 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        return null;
                    }
                    try {
                        Mac mac = Mac.getInstance(getHMAC_SHA_256());
                        Charset charset = Charsets.UTF_8;
                        byte[] bytes = str3.getBytes(charset);
                        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                        mac.init(new SecretKeySpec(bytes, getHMAC_SHA_256()));
                        byte[] bytes2 = str.getBytes(charset);
                        Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
                        mac.update(bytes2);
                        byte[] bytes3 = str2.getBytes(charset);
                        Intrinsics.checkNotNullExpressionValue(bytes3, "this as java.lang.String).getBytes(charset)");
                        byte[] encode = Base64.encode(mac.doFinal(bytes3), 2);
                        Intrinsics.checkNotNullExpressionValue(encode, "encode(raw, android.util.Base64.NO_WRAP)");
                        return new String(encode, charset);
                    } catch (Exception unused) {
                        throw new UnknownException(null, new Exception("errors in HMAC calculation"), 1, null);
                    }
                }
                throw new InvalidParameterException(new Exception("client ID cannot be null"));
            }
            throw new InvalidParameterException(new Exception("user ID cannot be null"));
        }

        private Companion() {
        }
    }
}
