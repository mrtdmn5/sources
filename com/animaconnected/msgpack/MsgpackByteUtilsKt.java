package com.animaconnected.msgpack;

import io.ktor.utils.io.charsets.CharsetJVMKt;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.InputArraysKt;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: MsgpackByteUtils.kt */
/* loaded from: classes.dex */
public final class MsgpackByteUtilsKt {
    public static final byte[] bytes(Object... data) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(data, "data");
        ArrayList arrayList = new ArrayList(data.length);
        for (Object obj : data) {
            if (obj instanceof Byte) {
                bArr = new byte[]{((Number) obj).byteValue()};
            } else if (obj instanceof Integer) {
                bArr = new byte[]{(byte) ((Number) obj).intValue()};
            } else if (obj instanceof String) {
                String str = (String) obj;
                Charset charset = Charsets.UTF_8;
                if (Intrinsics.areEqual(charset, charset)) {
                    bArr = StringsKt__StringsJVMKt.encodeToByteArray(str);
                } else {
                    CharsetEncoder newEncoder = charset.newEncoder();
                    Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
                    bArr = CharsetJVMKt.encodeToByteArray(newEncoder, str, str.length());
                }
            } else {
                bArr = new byte[0];
            }
            arrayList.add(bArr);
        }
        byte[] bArr2 = new byte[0];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bArr2 = ArraysKt___ArraysJvmKt.plus(bArr2, (byte[]) it.next());
        }
        return bArr2;
    }

    public static final byte[] readExactNBytes(Input input, int r5) {
        Intrinsics.checkNotNullParameter(input, "<this>");
        byte[] bArr = new byte[r5];
        int r1 = 0;
        while (r1 < r5) {
            int readAvailable = InputArraysKt.readAvailable(input, bArr, r1, r5 - r1);
            if (readAvailable != -1) {
                r1 += readAvailable;
            } else {
                throw new Exception("Unexpected EOF");
            }
        }
        return bArr;
    }
}
