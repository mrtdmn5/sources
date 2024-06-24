package com.animaconnected.watch.display;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: WatchAppInterfaces.kt */
/* loaded from: classes3.dex */
public final class FlashString extends WatchString {
    private final String string;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlashString(String string) {
        super(null);
        byte[] encodeToByteArray;
        boolean z;
        byte[] encodeToByteArray2;
        Intrinsics.checkNotNullParameter(string, "string");
        this.string = string;
        String string2 = getString();
        Charset charset = Charsets.UTF_8;
        if (Intrinsics.areEqual(charset, charset)) {
            encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(string2);
        } else {
            CharsetEncoder newEncoder = charset.newEncoder();
            Intrinsics.checkNotNullExpressionValue(newEncoder, "charset.newEncoder()");
            encodeToByteArray = CharsetJVMKt.encodeToByteArray(newEncoder, string2, string2.length());
        }
        if (encodeToByteArray.length < 79) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            StringBuilder sb = new StringBuilder("Strings stored in watch flash must be less than 79 characters \"");
            sb.append(getString());
            sb.append("\" (length = ");
            sb.append(getString().length());
            sb.append(", byteArraySize = ");
            String string3 = getString();
            if (Intrinsics.areEqual(charset, charset)) {
                encodeToByteArray2 = StringsKt__StringsJVMKt.encodeToByteArray(string3);
            } else {
                CharsetEncoder newEncoder2 = charset.newEncoder();
                Intrinsics.checkNotNullExpressionValue(newEncoder2, "charset.newEncoder()");
                encodeToByteArray2 = CharsetJVMKt.encodeToByteArray(newEncoder2, string3, string3.length());
            }
            throw new IllegalArgumentException(AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, encodeToByteArray2.length, ')').toString());
        }
    }

    public static /* synthetic */ FlashString copy$default(FlashString flashString, String str, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            str = flashString.string;
        }
        return flashString.copy(str);
    }

    public final String component1() {
        return this.string;
    }

    public final FlashString copy(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return new FlashString(string);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof FlashString) && Intrinsics.areEqual(this.string, ((FlashString) obj).string)) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.watch.display.WatchString
    public String getString() {
        return this.string;
    }

    public int hashCode() {
        return this.string.hashCode();
    }

    public String toString() {
        return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("FlashString(string="), this.string, ')');
    }
}
