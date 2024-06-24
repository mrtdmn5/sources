package com.animaconnected.msgpack;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MsgPackValues.kt */
/* loaded from: classes.dex */
public final class StringValue extends Value {
    private final String string;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StringValue(String string) {
        super(null);
        Intrinsics.checkNotNullParameter(string, "string");
        this.string = string;
    }

    public static /* synthetic */ StringValue copy$default(StringValue stringValue, String str, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            str = stringValue.string;
        }
        return stringValue.copy(str);
    }

    public final String component1() {
        return this.string;
    }

    public final StringValue copy(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return new StringValue(string);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof StringValue) && Intrinsics.areEqual(this.string, ((StringValue) obj).string)) {
            return true;
        }
        return false;
    }

    public final String getString() {
        return this.string;
    }

    public int hashCode() {
        return this.string.hashCode();
    }

    public String toString() {
        return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("StringValue(string="), this.string, ')');
    }
}
