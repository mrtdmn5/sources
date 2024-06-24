package com.animaconnected.watch.strings;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StringsExtensions.kt */
/* loaded from: classes3.dex */
public final class Static extends KeyString {
    private final String text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Static(String text) {
        super(null);
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
    }

    public static /* synthetic */ Static copy$default(Static r0, String str, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            str = r0.text;
        }
        return r0.copy(str);
    }

    public final String component1() {
        return this.text;
    }

    public final Static copy(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new Static(text);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Static) && Intrinsics.areEqual(this.text, ((Static) obj).text)) {
            return true;
        }
        return false;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return this.text.hashCode();
    }

    public String toString() {
        return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("Static(text="), this.text, ')');
    }
}
