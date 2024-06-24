package io.ktor.serialization.kotlinx.json;

import io.ktor.utils.io.charsets.CharsetJVMKt;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: KotlinxSerializationJsonExtensions.kt */
/* loaded from: classes3.dex */
public final class JsonArraySymbols {
    public final byte[] beginArray;
    public final byte[] endArray;
    public final byte[] objectSeparator;

    public JsonArraySymbols(Charset charset) {
        byte[] encodeToByteArray;
        byte[] encodeToByteArray2;
        byte[] encodeToByteArray3;
        Intrinsics.checkNotNullParameter(charset, "charset");
        Charset charset2 = Charsets.UTF_8;
        if (Intrinsics.areEqual(charset, charset2)) {
            encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray("[");
        } else {
            CharsetEncoder newEncoder = charset.newEncoder();
            Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
            encodeToByteArray = CharsetJVMKt.encodeToByteArray(newEncoder, "[", 1);
        }
        this.beginArray = encodeToByteArray;
        if (Intrinsics.areEqual(charset, charset2)) {
            encodeToByteArray2 = StringsKt__StringsJVMKt.encodeToByteArray("]");
        } else {
            CharsetEncoder newEncoder2 = charset.newEncoder();
            Intrinsics.checkNotNullExpressionValue(newEncoder2, "charset.newEncoder()");
            encodeToByteArray2 = CharsetJVMKt.encodeToByteArray(newEncoder2, "]", 1);
        }
        this.endArray = encodeToByteArray2;
        if (Intrinsics.areEqual(charset, charset2)) {
            encodeToByteArray3 = StringsKt__StringsJVMKt.encodeToByteArray(",");
        } else {
            CharsetEncoder newEncoder3 = charset.newEncoder();
            Intrinsics.checkNotNullExpressionValue(newEncoder3, "charset.newEncoder()");
            encodeToByteArray3 = CharsetJVMKt.encodeToByteArray(newEncoder3, ",", 1);
        }
        this.objectSeparator = encodeToByteArray3;
    }
}
