package androidx.compose.ui.text;

import android.graphics.Path;
import android.graphics.RectF;
import android.text.Layout;
import android.text.TextUtils;
import androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.ValidatingOffsetMapping$$ExternalSyntheticOutline0;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.android.LayoutIntrinsics;
import androidx.compose.ui.text.android.TextAndroidCanvas;
import androidx.compose.ui.text.android.TextLayout;
import androidx.compose.ui.text.android.TextLayoutKt;
import androidx.compose.ui.text.android.selection.WordBoundary;
import androidx.compose.ui.text.android.selection.WordIterator;
import androidx.compose.ui.text.platform.AndroidParagraphHelper_androidKt;
import androidx.compose.ui.text.platform.AndroidParagraphHelper_androidKt$NoopSpan$1;
import androidx.compose.ui.text.platform.AndroidParagraphIntrinsics;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Constraints;
import java.text.BreakIterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidParagraph.android.kt */
/* loaded from: classes.dex */
public final class AndroidParagraph implements Paragraph {
    public final CharSequence charSequence;
    public final long constraints;
    public final TextLayout layout;
    public final int maxLines;
    public final AndroidParagraphIntrinsics paragraphIntrinsics;
    public final List<Rect> placeholderRects;
    public final Lazy wordBoundary$delegate;

    /* compiled from: AndroidParagraph.android.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[ResolvedTextDirection.values().length];
            try {
                r0[ResolvedTextDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[ResolvedTextDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x028c A[LOOP:1: B:123:0x028a->B:124:0x028c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01d1  */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r0v41 */
    /* JADX WARN: Type inference failed for: r0v42, types: [java.lang.CharSequence, android.text.Spannable] */
    /* JADX WARN: Type inference failed for: r0v44 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AndroidParagraph(androidx.compose.ui.text.platform.AndroidParagraphIntrinsics r25, int r26, boolean r27, long r28) {
        /*
            Method dump skipped, instructions count: 915
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.AndroidParagraph.<init>(androidx.compose.ui.text.platform.AndroidParagraphIntrinsics, int, boolean, long):void");
    }

    public final TextLayout constructTextLayout(int r18, int r19, TextUtils.TruncateAt truncateAt, int r21, int r22, int r23, int r24, int r25) {
        boolean z;
        PlatformParagraphStyle platformParagraphStyle;
        CharSequence charSequence = this.charSequence;
        float width = getWidth();
        AndroidParagraphIntrinsics androidParagraphIntrinsics = this.paragraphIntrinsics;
        AndroidTextPaint androidTextPaint = androidParagraphIntrinsics.textPaint;
        int r7 = androidParagraphIntrinsics.textDirectionHeuristic;
        LayoutIntrinsics layoutIntrinsics = androidParagraphIntrinsics.layoutIntrinsics;
        AndroidParagraphHelper_androidKt$NoopSpan$1 androidParagraphHelper_androidKt$NoopSpan$1 = AndroidParagraphHelper_androidKt.NoopSpan;
        TextStyle textStyle = androidParagraphIntrinsics.style;
        Intrinsics.checkNotNullParameter(textStyle, "<this>");
        PlatformTextStyle platformTextStyle = textStyle.platformStyle;
        if (platformTextStyle != null && (platformParagraphStyle = platformTextStyle.paragraphStyle) != null) {
            z = platformParagraphStyle.includeFontPadding;
        } else {
            z = true;
        }
        return new TextLayout(charSequence, width, androidTextPaint, r18, truncateAt, r7, z, r21, r23, r24, r25, r22, r19, layoutIntrinsics);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public final ResolvedTextDirection getBidiRunDirection(int r2) {
        if (this.layout.layout.isRtlCharAt(r2)) {
            return ResolvedTextDirection.Rtl;
        }
        return ResolvedTextDirection.Ltr;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public final Rect getBoundingBox(int r9) {
        boolean z;
        float secondaryHorizontal;
        float secondaryHorizontal2;
        float primaryHorizontal;
        float primaryHorizontal2;
        TextLayout textLayout = this.layout;
        int lineForOffset = textLayout.getLineForOffset(r9);
        float lineTop = textLayout.getLineTop(lineForOffset);
        float lineBottom = textLayout.getLineBottom(lineForOffset);
        Layout layout = textLayout.layout;
        if (layout.getParagraphDirection(lineForOffset) == 1) {
            z = true;
        } else {
            z = false;
        }
        boolean isRtlCharAt = layout.isRtlCharAt(r9);
        if (z && !isRtlCharAt) {
            secondaryHorizontal = textLayout.getPrimaryHorizontal(r9, false);
            secondaryHorizontal2 = textLayout.getPrimaryHorizontal(r9 + 1, true);
        } else {
            if (z && isRtlCharAt) {
                primaryHorizontal = textLayout.getSecondaryHorizontal(r9, false);
                primaryHorizontal2 = textLayout.getSecondaryHorizontal(r9 + 1, true);
            } else if (isRtlCharAt) {
                primaryHorizontal = textLayout.getPrimaryHorizontal(r9, false);
                primaryHorizontal2 = textLayout.getPrimaryHorizontal(r9 + 1, true);
            } else {
                secondaryHorizontal = textLayout.getSecondaryHorizontal(r9, false);
                secondaryHorizontal2 = textLayout.getSecondaryHorizontal(r9 + 1, true);
            }
            float f = primaryHorizontal;
            secondaryHorizontal = primaryHorizontal2;
            secondaryHorizontal2 = f;
        }
        RectF rectF = new RectF(secondaryHorizontal, lineTop, secondaryHorizontal2, lineBottom);
        return new Rect(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public final Rect getCursorRect(int r5) {
        boolean z;
        CharSequence charSequence = this.charSequence;
        if (r5 >= 0 && r5 <= charSequence.length()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            TextLayout textLayout = this.layout;
            float primaryHorizontal = textLayout.getPrimaryHorizontal(r5, false);
            int lineForOffset = textLayout.getLineForOffset(r5);
            return new Rect(primaryHorizontal, textLayout.getLineTop(lineForOffset), primaryHorizontal, textLayout.getLineBottom(lineForOffset));
        }
        StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("offset(", r5, ") is out of bounds (0,");
        m.append(charSequence.length());
        throw new AssertionError(m.toString());
    }

    @Override // androidx.compose.ui.text.Paragraph
    public final float getFirstBaseline() {
        return this.layout.getLineBaseline(0);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public final float getHeight() {
        return this.layout.getHeight();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public final float getHorizontalPosition(int r3, boolean z) {
        TextLayout textLayout = this.layout;
        if (z) {
            return textLayout.getPrimaryHorizontal(r3, false);
        }
        return textLayout.getSecondaryHorizontal(r3, false);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public final float getLastBaseline() {
        return this.layout.getLineBaseline(r0.lineCount - 1);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public final float getLineBottom(int r2) {
        return this.layout.getLineBottom(r2);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public final int getLineEnd(int r2, boolean z) {
        TextLayout textLayout = this.layout;
        if (z) {
            Layout layout = textLayout.layout;
            if (layout.getEllipsisStart(r2) == 0) {
                return layout.getLineVisibleEnd(r2);
            }
            return layout.getEllipsisStart(r2) + layout.getLineStart(r2);
        }
        Layout layout2 = textLayout.layout;
        if (layout2.getEllipsisStart(r2) == 0) {
            return layout2.getLineEnd(r2);
        }
        return layout2.getText().length();
    }

    @Override // androidx.compose.ui.text.Paragraph
    public final int getLineForOffset(int r2) {
        return this.layout.getLineForOffset(r2);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public final int getLineForVerticalPosition(float f) {
        TextLayout textLayout = this.layout;
        return textLayout.layout.getLineForVertical(((int) f) - textLayout.topPadding);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public final float getLineLeft(int r4) {
        float f;
        TextLayout textLayout = this.layout;
        float lineLeft = textLayout.layout.getLineLeft(r4);
        if (r4 == textLayout.lineCount - 1) {
            f = textLayout.leftPadding;
        } else {
            f = 0.0f;
        }
        return lineLeft + f;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public final float getLineRight(int r4) {
        float f;
        TextLayout textLayout = this.layout;
        float lineRight = textLayout.layout.getLineRight(r4);
        if (r4 == textLayout.lineCount - 1) {
            f = textLayout.rightPadding;
        } else {
            f = 0.0f;
        }
        return lineRight + f;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public final int getLineStart(int r2) {
        return this.layout.layout.getLineStart(r2);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public final float getLineTop(int r2) {
        return this.layout.getLineTop(r2);
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: getOffsetForPosition-k-4lQ0M */
    public final int mo507getOffsetForPositionk4lQ0M(long j) {
        float f;
        int m260getYimpl = (int) Offset.m260getYimpl(j);
        TextLayout textLayout = this.layout;
        int lineForVertical = textLayout.layout.getLineForVertical(m260getYimpl - textLayout.topPadding);
        float m259getXimpl = Offset.m259getXimpl(j);
        float f2 = -1;
        if (lineForVertical == textLayout.lineCount - 1) {
            f = textLayout.leftPadding + textLayout.rightPadding;
        } else {
            f = 0.0f;
        }
        return textLayout.layout.getOffsetForHorizontal(lineForVertical, (f * f2) + m259getXimpl);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public final ResolvedTextDirection getParagraphDirection(int r2) {
        TextLayout textLayout = this.layout;
        if (textLayout.layout.getParagraphDirection(textLayout.getLineForOffset(r2)) == 1) {
            return ResolvedTextDirection.Ltr;
        }
        return ResolvedTextDirection.Rtl;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public final AndroidPath getPathForRange(int r6, int r7) {
        boolean z;
        if (r6 >= 0 && r6 <= r7) {
            z = true;
        } else {
            z = false;
        }
        CharSequence charSequence = this.charSequence;
        if (z && r7 <= charSequence.length()) {
            Path path = new Path();
            TextLayout textLayout = this.layout;
            textLayout.getClass();
            textLayout.layout.getSelectionPath(r6, r7, path);
            int r62 = textLayout.topPadding;
            if (r62 != 0 && !path.isEmpty()) {
                path.offset(0.0f, r62);
            }
            return new AndroidPath(path);
        }
        StringBuilder m = ValidatingOffsetMapping$$ExternalSyntheticOutline0.m("Start(", r6, ") or End(", r7, ") is out of Range(0..");
        m.append(charSequence.length());
        m.append("), or start > end!");
        throw new AssertionError(m.toString());
    }

    @Override // androidx.compose.ui.text.Paragraph
    public final List<Rect> getPlaceholderRects() {
        return this.placeholderRects;
    }

    @Override // androidx.compose.ui.text.Paragraph
    public final float getWidth() {
        return Constraints.m565getMaxWidthimpl(this.constraints);
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: getWordBoundary--jx7JFs */
    public final long mo508getWordBoundaryjx7JFs(int r9) {
        int r2;
        int preceding;
        int r1;
        int following;
        boolean z;
        boolean z2;
        Lazy lazy = this.wordBoundary$delegate;
        WordIterator wordIterator = ((WordBoundary) lazy.getValue()).wordIterator;
        wordIterator.checkOffsetIsValid(r9);
        boolean isOnPunctuation = wordIterator.isOnPunctuation(wordIterator.iterator.preceding(r9));
        BreakIterator breakIterator = wordIterator.iterator;
        if (isOnPunctuation) {
            wordIterator.checkOffsetIsValid(r9);
            r2 = r9;
            while (r2 != -1) {
                if (wordIterator.isOnPunctuation(r2) && !wordIterator.isAfterPunctuation(r2)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    break;
                }
                wordIterator.checkOffsetIsValid(r2);
                r2 = breakIterator.preceding(r2);
            }
        } else {
            wordIterator.checkOffsetIsValid(r9);
            if (wordIterator.isOnLetterOrDigit(r9)) {
                if (breakIterator.isBoundary(r9) && !wordIterator.isAfterLetterOrDigit(r9)) {
                    r2 = r9;
                } else {
                    preceding = breakIterator.preceding(r9);
                    r2 = preceding;
                }
            } else if (wordIterator.isAfterLetterOrDigit(r9)) {
                preceding = breakIterator.preceding(r9);
                r2 = preceding;
            } else {
                r2 = -1;
            }
        }
        if (r2 == -1) {
            r2 = r9;
        }
        WordIterator wordIterator2 = ((WordBoundary) lazy.getValue()).wordIterator;
        wordIterator2.checkOffsetIsValid(r9);
        boolean isAfterPunctuation = wordIterator2.isAfterPunctuation(wordIterator2.iterator.following(r9));
        BreakIterator breakIterator2 = wordIterator2.iterator;
        if (isAfterPunctuation) {
            wordIterator2.checkOffsetIsValid(r9);
            r1 = r9;
            while (r1 != -1) {
                if (!wordIterator2.isOnPunctuation(r1) && wordIterator2.isAfterPunctuation(r1)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    break;
                }
                wordIterator2.checkOffsetIsValid(r1);
                r1 = breakIterator2.following(r1);
            }
        } else {
            wordIterator2.checkOffsetIsValid(r9);
            if (wordIterator2.isAfterLetterOrDigit(r9)) {
                if (breakIterator2.isBoundary(r9) && !wordIterator2.isOnLetterOrDigit(r9)) {
                    r1 = r9;
                } else {
                    following = breakIterator2.following(r9);
                    r1 = following;
                }
            } else if (wordIterator2.isOnLetterOrDigit(r9)) {
                following = breakIterator2.following(r9);
                r1 = following;
            } else {
                r1 = -1;
            }
        }
        if (r1 != -1) {
            r9 = r1;
        }
        return TextRangeKt.TextRange(r2, r9);
    }

    @Override // androidx.compose.ui.text.Paragraph
    public final boolean isLineEllipsized(int r2) {
        return TextLayoutKt.isLineEllipsized(this.layout.layout, r2);
    }

    public final void paint(Canvas canvas) {
        android.graphics.Canvas canvas2 = AndroidCanvas_androidKt.EmptyCanvas;
        Intrinsics.checkNotNullParameter(canvas, "<this>");
        android.graphics.Canvas canvas3 = ((AndroidCanvas) canvas).internalCanvas;
        TextLayout textLayout = this.layout;
        if (textLayout.didExceedMaxLines) {
            canvas3.save();
            canvas3.clipRect(0.0f, 0.0f, getWidth(), getHeight());
        }
        textLayout.getClass();
        Intrinsics.checkNotNullParameter(canvas3, "canvas");
        if (canvas3.getClipBounds(textLayout.rect)) {
            int r1 = textLayout.topPadding;
            if (r1 != 0) {
                canvas3.translate(0.0f, r1);
            }
            TextAndroidCanvas textAndroidCanvas = TextLayoutKt.SharedTextAndroidCanvas;
            textAndroidCanvas.getClass();
            textAndroidCanvas.nativeCanvas = canvas3;
            textLayout.layout.draw(textAndroidCanvas);
            if (r1 != 0) {
                canvas3.translate(0.0f, (-1) * r1);
            }
        }
        if (textLayout.didExceedMaxLines) {
            canvas3.restore();
        }
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: paint-LG529CI */
    public final void mo509paintLG529CI(Canvas canvas, long j, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int r12) {
        boolean z;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        AndroidParagraphIntrinsics androidParagraphIntrinsics = this.paragraphIntrinsics;
        AndroidTextPaint androidTextPaint = androidParagraphIntrinsics.textPaint;
        int r2 = androidTextPaint.composePaint._blendMode;
        androidTextPaint.getClass();
        if (j != Color.Unspecified) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            AndroidPaint androidPaint = androidTextPaint.composePaint;
            androidPaint.mo298setColor8_81llA(j);
            androidPaint.setShader(null);
        }
        androidTextPaint.setShadow(shadow);
        androidTextPaint.setTextDecoration(textDecoration);
        androidTextPaint.setDrawStyle(drawStyle);
        androidTextPaint.composePaint.mo297setBlendModes9anfk8(r12);
        paint(canvas);
        androidParagraphIntrinsics.textPaint.composePaint.mo297setBlendModes9anfk8(r2);
    }

    @Override // androidx.compose.ui.text.Paragraph
    /* renamed from: paint-hn5TExg */
    public final void mo510painthn5TExg(Canvas canvas, Brush brush, float f, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int r12) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        AndroidParagraphIntrinsics androidParagraphIntrinsics = this.paragraphIntrinsics;
        AndroidTextPaint androidTextPaint = androidParagraphIntrinsics.textPaint;
        int r2 = androidTextPaint.composePaint._blendMode;
        androidTextPaint.m547setBrush12SF9DM(brush, SizeKt.Size(getWidth(), getHeight()), f);
        androidTextPaint.setShadow(shadow);
        androidTextPaint.setTextDecoration(textDecoration);
        androidTextPaint.setDrawStyle(drawStyle);
        androidTextPaint.composePaint.mo297setBlendModes9anfk8(r12);
        paint(canvas);
        androidParagraphIntrinsics.textPaint.composePaint.mo297setBlendModes9anfk8(r2);
    }
}
