package com.amplifyframework.auth.cognito.asf;

import android.util.Base64;
import android.util.Log;
import com.animaconnected.firebase.AnalyticsConstants;
import java.nio.charset.Charset;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: SignatureGenerator.kt */
/* loaded from: classes.dex */
public final class SignatureGenerator {
    private static final String HMAC_SHA_256 = "HmacSHA256";
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "SignatureGenerator";

    /* compiled from: SignatureGenerator.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getSignature(String str, String str2, String str3) {
            SignatureGenerator$Companion$$ExternalSyntheticOutline0.m(str, "data", str2, "secret", str3, AnalyticsConstants.KEY_VERSION);
            try {
                Mac mac = Mac.getInstance(SignatureGenerator.HMAC_SHA_256);
                Charset charset = Charsets.UTF_8;
                byte[] bytes = str2.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                mac.init(new SecretKeySpec(bytes, SignatureGenerator.HMAC_SHA_256));
                byte[] bytes2 = str3.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
                mac.update(bytes2);
                byte[] bytes3 = str.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes3, "this as java.lang.String).getBytes(charset)");
                byte[] encode = Base64.encode(mac.doFinal(bytes3), 2);
                Intrinsics.checkNotNullExpressionValue(encode, "encode(signature, Base64.NO_WRAP)");
                return new String(encode, charset);
            } catch (Exception e) {
                Log.w(SignatureGenerator.TAG, "Exception while completing context data signature", e);
                return "";
            }
        }

        private Companion() {
        }
    }

    public static final String getSignature(String str, String str2, String str3) {
        return Companion.getSignature(str, str2, str3);
    }
}
