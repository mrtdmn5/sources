package androidx.compose.ui.text;

import androidx.compose.animation.AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0;
import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: MultiParagraph.kt */
/* loaded from: classes.dex */
public final class ParagraphInfo {
    public final float bottom;
    public final int endIndex;
    public final int endLineIndex;
    public final Paragraph paragraph;
    public final int startIndex;
    public final int startLineIndex;
    public final float top;

    public ParagraphInfo(AndroidParagraph androidParagraph, int r2, int r3, int r4, int r5, float f, float f2) {
        this.paragraph = androidParagraph;
        this.startIndex = r2;
        this.endIndex = r3;
        this.startLineIndex = r4;
        this.endLineIndex = r5;
        this.top = f;
        this.bottom = f2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParagraphInfo)) {
            return false;
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) obj;
        if (Intrinsics.areEqual(this.paragraph, paragraphInfo.paragraph) && this.startIndex == paragraphInfo.startIndex && this.endIndex == paragraphInfo.endIndex && this.startLineIndex == paragraphInfo.startLineIndex && this.endLineIndex == paragraphInfo.endLineIndex && Float.compare(this.top, paragraphInfo.top) == 0 && Float.compare(this.bottom, paragraphInfo.bottom) == 0) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Float.hashCode(this.bottom) + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.top, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.endLineIndex, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.startLineIndex, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.endIndex, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.startIndex, this.paragraph.hashCode() * 31, 31), 31), 31), 31), 31);
    }

    public final Rect toGlobal(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "<this>");
        return rect.m270translatek4lQ0M(OffsetKt.Offset(0.0f, this.top));
    }

    public final int toLocalIndex(int r3) {
        int r0 = this.endIndex;
        int r1 = this.startIndex;
        return RangesKt___RangesKt.coerceIn(r3, r1, r0) - r1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ParagraphInfo(paragraph=");
        sb.append(this.paragraph);
        sb.append(", startIndex=");
        sb.append(this.startIndex);
        sb.append(", endIndex=");
        sb.append(this.endIndex);
        sb.append(", startLineIndex=");
        sb.append(this.startLineIndex);
        sb.append(", endLineIndex=");
        sb.append(this.endLineIndex);
        sb.append(", top=");
        sb.append(this.top);
        sb.append(", bottom=");
        return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.bottom, ')');
    }
}
