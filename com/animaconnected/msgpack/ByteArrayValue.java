package com.animaconnected.msgpack;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MsgPackValues.kt */
/* loaded from: classes.dex */
public final class ByteArrayValue extends Value {
    private final byte[] byteArray;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteArrayValue(byte[] byteArray) {
        super(null);
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        this.byteArray = byteArray;
    }

    public static /* synthetic */ ByteArrayValue copy$default(ByteArrayValue byteArrayValue, byte[] bArr, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            bArr = byteArrayValue.byteArray;
        }
        return byteArrayValue.copy(bArr);
    }

    public final byte[] component1() {
        return this.byteArray;
    }

    public final ByteArrayValue copy(byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        return new ByteArrayValue(byteArray);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ByteArrayValue.class == obj.getClass()) {
            return Arrays.equals(this.byteArray, ((ByteArrayValue) obj).byteArray);
        }
        return false;
    }

    public final byte[] getByteArray() {
        return this.byteArray;
    }

    public int hashCode() {
        return Arrays.hashCode(this.byteArray);
    }

    public String toString() {
        return "ByteArrayValue(byteArray=" + Arrays.toString(this.byteArray) + ')';
    }
}
