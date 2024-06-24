package androidx.compose.ui.text.style;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextMotion.android.kt */
/* loaded from: classes.dex */
public final class TextMotion {
    public final int linearity;
    public final boolean subpixelTextPositioning;
    public static final TextMotion Static = new TextMotion(2, false);
    public static final TextMotion Animated = new TextMotion(1, true);

    public TextMotion(int r1, boolean z) {
        this.linearity = r1;
        this.subpixelTextPositioning = z;
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextMotion)) {
            return false;
        }
        TextMotion textMotion = (TextMotion) obj;
        if (this.linearity == textMotion.linearity) {
            z = true;
        } else {
            z = false;
        }
        if (z && this.subpixelTextPositioning == textMotion.subpixelTextPositioning) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.subpixelTextPositioning) + (Integer.hashCode(this.linearity) * 31);
    }

    public final String toString() {
        if (Intrinsics.areEqual(this, Static)) {
            return "TextMotion.Static";
        }
        if (Intrinsics.areEqual(this, Animated)) {
            return "TextMotion.Animated";
        }
        return "Invalid";
    }
}
