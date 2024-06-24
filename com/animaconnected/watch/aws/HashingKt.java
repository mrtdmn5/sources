package com.animaconnected.watch.aws;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import okio.ByteString;

/* compiled from: Hashing.kt */
/* loaded from: classes3.dex */
public final class HashingKt {
    public static final String hash(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return toByteString(value).digest$okio("SHA-256").hex();
    }

    public static final byte[] hmacSha256(byte[] key, String data) throws Exception {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        ByteString byteString = toByteString(data);
        ByteString byteString2 = ByteString.EMPTY;
        ByteString of$default = ByteString.Companion.of$default(key);
        byteString.getClass();
        return byteString.hmac$okio(of$default).toByteArray();
    }

    private static final ByteString toByteString(String str) {
        ByteString byteString = ByteString.EMPTY;
        return ByteString.Companion.of$default(StringsKt__StringsJVMKt.encodeToByteArray(str));
    }

    public static final byte[] hmacSha256(String key, String data) throws Exception {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(data, "data");
        return hmacSha256(StringsKt__StringsJVMKt.encodeToByteArray(key), data);
    }
}
