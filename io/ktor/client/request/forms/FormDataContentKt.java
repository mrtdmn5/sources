package io.ktor.client.request.forms;

import io.ktor.utils.io.charsets.CharsetJVMKt;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: FormDataContent.kt */
/* loaded from: classes3.dex */
public final class FormDataContentKt {
    public static final byte[] RN_BYTES;

    static {
        byte[] encodeToByteArray;
        Charset charset = Charsets.UTF_8;
        if (Intrinsics.areEqual(charset, charset)) {
            encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray("\r\n");
        } else {
            CharsetEncoder newEncoder = charset.newEncoder();
            Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
            encodeToByteArray = CharsetJVMKt.encodeToByteArray(newEncoder, "\r\n", 2);
        }
        RN_BYTES = encodeToByteArray;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x010f -> B:18:0x0111). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object access$copyTo(io.ktor.utils.io.core.Input r17, io.ktor.utils.io.ByteWriteChannel r18, kotlin.coroutines.Continuation r19) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.request.forms.FormDataContentKt.access$copyTo(io.ktor.utils.io.core.Input, io.ktor.utils.io.ByteWriteChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
