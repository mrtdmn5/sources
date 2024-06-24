package androidx.compose.ui.text.android;

import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextLayout.kt */
/* loaded from: classes.dex */
public final class TextLayout {
    public final int bottomPadding;
    public final boolean didExceedMaxLines;
    public final boolean fallbackLineSpacing;
    public final boolean includePadding;
    public final boolean isBoringLayout;
    public final int lastLineExtra;
    public final Paint.FontMetricsInt lastLineFontMetrics;
    public final Layout layout;
    public final Lazy layoutHelper$delegate;
    public final float leftPadding;
    public final int lineCount;
    public final LineHeightStyleSpan[] lineHeightSpans;
    public final Rect rect;
    public final float rightPadding;
    public final int topPadding;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01f2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public TextLayout(java.lang.CharSequence r45, float r46, androidx.compose.ui.text.platform.AndroidTextPaint r47, int r48, android.text.TextUtils.TruncateAt r49, int r50, boolean r51, int r52, int r53, int r54, int r55, int r56, int r57, androidx.compose.ui.text.android.LayoutIntrinsics r58) {
        /*
            Method dump skipped, instructions count: 788
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.android.TextLayout.<init>(java.lang.CharSequence, float, androidx.compose.ui.text.platform.AndroidTextPaint, int, android.text.TextUtils$TruncateAt, int, boolean, int, int, int, int, int, int, androidx.compose.ui.text.android.LayoutIntrinsics):void");
    }

    public final int getHeight() {
        int height;
        boolean z = this.didExceedMaxLines;
        Layout layout = this.layout;
        if (z) {
            height = layout.getLineBottom(this.lineCount - 1);
        } else {
            height = layout.getHeight();
        }
        return height + this.topPadding + this.bottomPadding + this.lastLineExtra;
    }

    public final float getLineBaseline(int r3) {
        float lineBaseline;
        Paint.FontMetricsInt fontMetricsInt;
        float f = this.topPadding;
        if (r3 == this.lineCount - 1 && (fontMetricsInt = this.lastLineFontMetrics) != null) {
            lineBaseline = getLineTop(r3) - fontMetricsInt.ascent;
        } else {
            lineBaseline = this.layout.getLineBaseline(r3);
        }
        return f + lineBaseline;
    }

    public final float getLineBottom(int r4) {
        int r42;
        Paint.FontMetricsInt fontMetricsInt;
        int r0 = this.lineCount;
        int r1 = r0 - 1;
        Layout layout = this.layout;
        if (r4 == r1 && (fontMetricsInt = this.lastLineFontMetrics) != null) {
            return layout.getLineBottom(r4 - 1) + fontMetricsInt.bottom;
        }
        float lineBottom = this.topPadding + layout.getLineBottom(r4);
        if (r4 == r0 - 1) {
            r42 = this.bottomPadding;
        } else {
            r42 = 0;
        }
        return lineBottom + r42;
    }

    public final int getLineForOffset(int r2) {
        return this.layout.getLineForOffset(r2);
    }

    public final float getLineTop(int r2) {
        int r22;
        float lineTop = this.layout.getLineTop(r2);
        if (r2 == 0) {
            r22 = 0;
        } else {
            r22 = this.topPadding;
        }
        return lineTop + r22;
    }

    public final float getPrimaryHorizontal(int r3, boolean z) {
        float f;
        float horizontalPosition = ((LayoutHelper) this.layoutHelper$delegate.getValue()).getHorizontalPosition(r3, true, z);
        if (getLineForOffset(r3) == this.lineCount - 1) {
            f = this.leftPadding + this.rightPadding;
        } else {
            f = 0.0f;
        }
        return f + horizontalPosition;
    }

    public final float getSecondaryHorizontal(int r3, boolean z) {
        float f;
        float horizontalPosition = ((LayoutHelper) this.layoutHelper$delegate.getValue()).getHorizontalPosition(r3, false, z);
        if (getLineForOffset(r3) == this.lineCount - 1) {
            f = this.leftPadding + this.rightPadding;
        } else {
            f = 0.0f;
        }
        return f + horizontalPosition;
    }

    public final CharSequence getText() {
        CharSequence text = this.layout.getText();
        Intrinsics.checkNotNullExpressionValue(text, "layout.text");
        return text;
    }
}
