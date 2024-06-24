package com.animaconnected.watch.display;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchAppInterfaces.kt */
/* loaded from: classes3.dex */
public final class RamString extends WatchString {
    private final String string;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RamString(String string) {
        super(null);
        Intrinsics.checkNotNullParameter(string, "string");
        this.string = string;
    }

    public static /* synthetic */ RamString copy$default(RamString ramString, String str, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            str = ramString.string;
        }
        return ramString.copy(str);
    }

    public final String component1() {
        return this.string;
    }

    public final RamString copy(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return new RamString(string);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof RamString) && Intrinsics.areEqual(this.string, ((RamString) obj).string)) {
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
        return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("RamString(string="), this.string, ')');
    }
}
