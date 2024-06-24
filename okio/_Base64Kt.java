package okio;

import okio.ByteString;

/* compiled from: -Base64.kt */
/* loaded from: classes4.dex */
public final class _Base64Kt {
    public static final byte[] BASE64;

    static {
        ByteString byteString = ByteString.EMPTY;
        BASE64 = ByteString.Companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").data;
        ByteString.Companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_");
    }
}
