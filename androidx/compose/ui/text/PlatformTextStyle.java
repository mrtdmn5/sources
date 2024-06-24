package androidx.compose.ui.text;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidTextStyle.android.kt */
/* loaded from: classes.dex */
public final class PlatformTextStyle {
    public final PlatformParagraphStyle paragraphStyle;
    public final PlatformSpanStyle spanStyle;

    public PlatformTextStyle(PlatformSpanStyle platformSpanStyle, PlatformParagraphStyle platformParagraphStyle) {
        this.spanStyle = platformSpanStyle;
        this.paragraphStyle = platformParagraphStyle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlatformTextStyle)) {
            return false;
        }
        PlatformTextStyle platformTextStyle = (PlatformTextStyle) obj;
        if (Intrinsics.areEqual(this.paragraphStyle, platformTextStyle.paragraphStyle) && Intrinsics.areEqual(this.spanStyle, platformTextStyle.spanStyle)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r1;
        int r0 = 0;
        PlatformSpanStyle platformSpanStyle = this.spanStyle;
        if (platformSpanStyle != null) {
            r1 = platformSpanStyle.hashCode();
        } else {
            r1 = 0;
        }
        int r12 = r1 * 31;
        PlatformParagraphStyle platformParagraphStyle = this.paragraphStyle;
        if (platformParagraphStyle != null) {
            r0 = platformParagraphStyle.hashCode();
        }
        return r12 + r0;
    }

    public final String toString() {
        return "PlatformTextStyle(spanStyle=" + this.spanStyle + ", paragraphSyle=" + this.paragraphStyle + ')';
    }
}
