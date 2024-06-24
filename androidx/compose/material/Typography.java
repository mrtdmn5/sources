package androidx.compose.material;

import androidx.compose.ui.text.TextStyle;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Typography.kt */
/* loaded from: classes.dex */
public final class Typography {
    public final TextStyle body1;
    public final TextStyle body2;
    public final TextStyle button;
    public final TextStyle caption;
    public final TextStyle h1;
    public final TextStyle h2;
    public final TextStyle h3;
    public final TextStyle h4;
    public final TextStyle h5;
    public final TextStyle h6;
    public final TextStyle overline;
    public final TextStyle subtitle1;
    public final TextStyle subtitle2;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Typography(androidx.compose.ui.text.font.FontListFontFamily r30, androidx.compose.ui.text.TextStyle r31, androidx.compose.ui.text.TextStyle r32, androidx.compose.ui.text.TextStyle r33, androidx.compose.ui.text.TextStyle r34, androidx.compose.ui.text.TextStyle r35, androidx.compose.ui.text.TextStyle r36, androidx.compose.ui.text.TextStyle r37, androidx.compose.ui.text.TextStyle r38, androidx.compose.ui.text.TextStyle r39, int r40) {
        /*
            Method dump skipped, instructions count: 610
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.Typography.<init>(androidx.compose.ui.text.font.FontListFontFamily, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, androidx.compose.ui.text.TextStyle, int):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Typography)) {
            return false;
        }
        Typography typography = (Typography) obj;
        if (Intrinsics.areEqual(this.h1, typography.h1) && Intrinsics.areEqual(this.h2, typography.h2) && Intrinsics.areEqual(this.h3, typography.h3) && Intrinsics.areEqual(this.h4, typography.h4) && Intrinsics.areEqual(this.h5, typography.h5) && Intrinsics.areEqual(this.h6, typography.h6) && Intrinsics.areEqual(this.subtitle1, typography.subtitle1) && Intrinsics.areEqual(this.subtitle2, typography.subtitle2) && Intrinsics.areEqual(this.body1, typography.body1) && Intrinsics.areEqual(this.body2, typography.body2) && Intrinsics.areEqual(this.button, typography.button) && Intrinsics.areEqual(this.caption, typography.caption) && Intrinsics.areEqual(this.overline, typography.overline)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.overline.hashCode() + ((this.caption.hashCode() + ((this.button.hashCode() + ((this.body2.hashCode() + ((this.body1.hashCode() + ((this.subtitle2.hashCode() + ((this.subtitle1.hashCode() + ((this.h6.hashCode() + ((this.h5.hashCode() + ((this.h4.hashCode() + ((this.h3.hashCode() + ((this.h2.hashCode() + (this.h1.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "Typography(h1=" + this.h1 + ", h2=" + this.h2 + ", h3=" + this.h3 + ", h4=" + this.h4 + ", h5=" + this.h5 + ", h6=" + this.h6 + ", subtitle1=" + this.subtitle1 + ", subtitle2=" + this.subtitle2 + ", body1=" + this.body1 + ", body2=" + this.body2 + ", button=" + this.button + ", caption=" + this.caption + ", overline=" + this.overline + ')';
    }

    public Typography(TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13) {
        this.h1 = textStyle;
        this.h2 = textStyle2;
        this.h3 = textStyle3;
        this.h4 = textStyle4;
        this.h5 = textStyle5;
        this.h6 = textStyle6;
        this.subtitle1 = textStyle7;
        this.subtitle2 = textStyle8;
        this.body1 = textStyle9;
        this.body2 = textStyle10;
        this.button = textStyle11;
        this.caption = textStyle12;
        this.overline = textStyle13;
    }
}
