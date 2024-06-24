package androidx.compose.ui.text.font;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: FontFamily.kt */
/* loaded from: classes.dex */
public final class LoadedFontFamily extends FontFamily {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoadedFontFamily)) {
            return false;
        }
        ((LoadedFontFamily) obj).getClass();
        if (Intrinsics.areEqual((Object) null, (Object) null)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "LoadedFontFamily(typeface=null)";
    }
}
