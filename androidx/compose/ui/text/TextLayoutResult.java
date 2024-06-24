package androidx.compose.ui.text;

import androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0;
import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import androidx.compose.animation.Scale$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.ValidatingOffsetMapping$$ExternalSyntheticOutline0;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.IntSize;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: TextLayoutResult.kt */
/* loaded from: classes.dex */
public final class TextLayoutResult {
    public final float firstBaseline;
    public final float lastBaseline;
    public final TextLayoutInput layoutInput;
    public final MultiParagraph multiParagraph;
    public final ArrayList placeholderRects;
    public final long size;

    public TextLayoutResult(TextLayoutInput textLayoutInput, MultiParagraph multiParagraph, long j) {
        float firstBaseline;
        Intrinsics.checkNotNullParameter(multiParagraph, "multiParagraph");
        this.layoutInput = textLayoutInput;
        this.multiParagraph = multiParagraph;
        this.size = j;
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        float f = 0.0f;
        if (arrayList.isEmpty()) {
            firstBaseline = 0.0f;
        } else {
            firstBaseline = ((ParagraphInfo) arrayList.get(0)).paragraph.getFirstBaseline();
        }
        this.firstBaseline = firstBaseline;
        if (!arrayList.isEmpty()) {
            ParagraphInfo paragraphInfo = (ParagraphInfo) CollectionsKt___CollectionsKt.last(arrayList);
            f = paragraphInfo.top + paragraphInfo.paragraph.getLastBaseline();
        }
        this.lastBaseline = f;
        this.placeholderRects = multiParagraph.placeholderRects;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextLayoutResult)) {
            return false;
        }
        TextLayoutResult textLayoutResult = (TextLayoutResult) obj;
        if (!Intrinsics.areEqual(this.layoutInput, textLayoutResult.layoutInput) || !Intrinsics.areEqual(this.multiParagraph, textLayoutResult.multiParagraph) || !IntSize.m592equalsimpl0(this.size, textLayoutResult.size)) {
            return false;
        }
        if (this.firstBaseline == textLayoutResult.firstBaseline) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        if (this.lastBaseline == textLayoutResult.lastBaseline) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 && Intrinsics.areEqual(this.placeholderRects, textLayoutResult.placeholderRects)) {
            return true;
        }
        return false;
    }

    public final ResolvedTextDirection getBidiRunDirection(int r3) {
        int findParagraphByIndex;
        MultiParagraph multiParagraph = this.multiParagraph;
        multiParagraph.requireIndexInRangeInclusiveEnd(r3);
        int length = multiParagraph.intrinsics.annotatedString.length();
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        if (r3 == length) {
            findParagraphByIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
        } else {
            findParagraphByIndex = MultiParagraphKt.findParagraphByIndex(r3, arrayList);
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(findParagraphByIndex);
        return paragraphInfo.paragraph.getBidiRunDirection(paragraphInfo.toLocalIndex(r3));
    }

    public final Rect getBoundingBox(int r4) {
        boolean z;
        MultiParagraph multiParagraph = this.multiParagraph;
        MultiParagraphIntrinsics multiParagraphIntrinsics = multiParagraph.intrinsics;
        if (r4 >= 0 && r4 < multiParagraphIntrinsics.annotatedString.text.length()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            ArrayList arrayList = multiParagraph.paragraphInfoList;
            ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(MultiParagraphKt.findParagraphByIndex(r4, arrayList));
            return paragraphInfo.toGlobal(paragraphInfo.paragraph.getBoundingBox(paragraphInfo.toLocalIndex(r4)));
        }
        StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("offset(", r4, ") is out of bounds [0, ");
        m.append(multiParagraphIntrinsics.annotatedString.length());
        m.append(')');
        throw new IllegalArgumentException(m.toString().toString());
    }

    public final Rect getCursorRect(int r3) {
        int findParagraphByIndex;
        MultiParagraph multiParagraph = this.multiParagraph;
        multiParagraph.requireIndexInRangeInclusiveEnd(r3);
        int length = multiParagraph.intrinsics.annotatedString.length();
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        if (r3 == length) {
            findParagraphByIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
        } else {
            findParagraphByIndex = MultiParagraphKt.findParagraphByIndex(r3, arrayList);
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(findParagraphByIndex);
        return paragraphInfo.toGlobal(paragraphInfo.paragraph.getCursorRect(paragraphInfo.toLocalIndex(r3)));
    }

    public final boolean getHasVisualOverflow() {
        boolean z;
        boolean z2;
        float f = (int) (this.size >> 32);
        MultiParagraph multiParagraph = this.multiParagraph;
        if (f < multiParagraph.width) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return true;
        }
        if (!multiParagraph.didExceedMaxLines && IntSize.m593getHeightimpl(r0) >= multiParagraph.height) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            return true;
        }
        return false;
    }

    public final float getLineBottom(int r4) {
        MultiParagraph multiParagraph = this.multiParagraph;
        multiParagraph.requireLineIndexInRange(r4);
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(MultiParagraphKt.findParagraphByLineIndex(r4, arrayList));
        return paragraphInfo.paragraph.getLineBottom(r4 - paragraphInfo.startLineIndex) + paragraphInfo.top;
    }

    public final int getLineEnd(int r4, boolean z) {
        MultiParagraph multiParagraph = this.multiParagraph;
        multiParagraph.requireLineIndexInRange(r4);
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(MultiParagraphKt.findParagraphByLineIndex(r4, arrayList));
        return paragraphInfo.paragraph.getLineEnd(r4 - paragraphInfo.startLineIndex, z) + paragraphInfo.startIndex;
    }

    public final int getLineForOffset(int r3) {
        int findParagraphByIndex;
        MultiParagraph multiParagraph = this.multiParagraph;
        int length = multiParagraph.intrinsics.annotatedString.length();
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        if (r3 >= length) {
            findParagraphByIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
        } else if (r3 < 0) {
            findParagraphByIndex = 0;
        } else {
            findParagraphByIndex = MultiParagraphKt.findParagraphByIndex(r3, arrayList);
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(findParagraphByIndex);
        return paragraphInfo.paragraph.getLineForOffset(paragraphInfo.toLocalIndex(r3)) + paragraphInfo.startLineIndex;
    }

    public final int getLineForVerticalPosition(float f) {
        int findParagraphByY;
        MultiParagraph multiParagraph = this.multiParagraph;
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        if (f <= 0.0f) {
            findParagraphByY = 0;
        } else if (f >= multiParagraph.height) {
            findParagraphByY = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
        } else {
            findParagraphByY = MultiParagraphKt.findParagraphByY(arrayList, f);
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(findParagraphByY);
        int r1 = paragraphInfo.endIndex;
        int r2 = paragraphInfo.startIndex;
        if (r1 - r2 == 0) {
            return Math.max(0, r2 - 1);
        }
        return paragraphInfo.paragraph.getLineForVerticalPosition(f - paragraphInfo.top) + paragraphInfo.startLineIndex;
    }

    public final float getLineLeft(int r3) {
        MultiParagraph multiParagraph = this.multiParagraph;
        multiParagraph.requireLineIndexInRange(r3);
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(MultiParagraphKt.findParagraphByLineIndex(r3, arrayList));
        return paragraphInfo.paragraph.getLineLeft(r3 - paragraphInfo.startLineIndex);
    }

    public final float getLineRight(int r3) {
        MultiParagraph multiParagraph = this.multiParagraph;
        multiParagraph.requireLineIndexInRange(r3);
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(MultiParagraphKt.findParagraphByLineIndex(r3, arrayList));
        return paragraphInfo.paragraph.getLineRight(r3 - paragraphInfo.startLineIndex);
    }

    public final int getLineStart(int r4) {
        MultiParagraph multiParagraph = this.multiParagraph;
        multiParagraph.requireLineIndexInRange(r4);
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(MultiParagraphKt.findParagraphByLineIndex(r4, arrayList));
        return paragraphInfo.paragraph.getLineStart(r4 - paragraphInfo.startLineIndex) + paragraphInfo.startIndex;
    }

    public final float getLineTop(int r4) {
        MultiParagraph multiParagraph = this.multiParagraph;
        multiParagraph.requireLineIndexInRange(r4);
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(MultiParagraphKt.findParagraphByLineIndex(r4, arrayList));
        return paragraphInfo.paragraph.getLineTop(r4 - paragraphInfo.startLineIndex) + paragraphInfo.top;
    }

    /* renamed from: getOffsetForPosition-k-4lQ0M */
    public final int m519getOffsetForPositionk4lQ0M(long j) {
        int findParagraphByY;
        MultiParagraph multiParagraph = this.multiParagraph;
        multiParagraph.getClass();
        float m260getYimpl = Offset.m260getYimpl(j);
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        if (m260getYimpl <= 0.0f) {
            findParagraphByY = 0;
        } else if (Offset.m260getYimpl(j) >= multiParagraph.height) {
            findParagraphByY = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
        } else {
            findParagraphByY = MultiParagraphKt.findParagraphByY(arrayList, Offset.m260getYimpl(j));
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(findParagraphByY);
        int r1 = paragraphInfo.endIndex;
        int r2 = paragraphInfo.startIndex;
        if (r1 - r2 == 0) {
            return Math.max(0, r2 - 1);
        }
        return paragraphInfo.paragraph.mo507getOffsetForPositionk4lQ0M(OffsetKt.Offset(Offset.m259getXimpl(j), Offset.m260getYimpl(j) - paragraphInfo.top)) + r2;
    }

    public final ResolvedTextDirection getParagraphDirection(int r3) {
        int findParagraphByIndex;
        MultiParagraph multiParagraph = this.multiParagraph;
        multiParagraph.requireIndexInRangeInclusiveEnd(r3);
        int length = multiParagraph.intrinsics.annotatedString.length();
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        if (r3 == length) {
            findParagraphByIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
        } else {
            findParagraphByIndex = MultiParagraphKt.findParagraphByIndex(r3, arrayList);
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(findParagraphByIndex);
        return paragraphInfo.paragraph.getParagraphDirection(paragraphInfo.toLocalIndex(r3));
    }

    public final AndroidPath getPathForRange(int r9, int r10) {
        boolean z;
        MultiParagraph multiParagraph = this.multiParagraph;
        multiParagraph.getClass();
        boolean z2 = true;
        if (r9 >= 0 && r9 <= r10) {
            z = true;
        } else {
            z = false;
        }
        MultiParagraphIntrinsics multiParagraphIntrinsics = multiParagraph.intrinsics;
        if (!z || r10 > multiParagraphIntrinsics.annotatedString.text.length()) {
            z2 = false;
        }
        if (z2) {
            if (r9 == r10) {
                return OnTimeoutKt.Path();
            }
            ArrayList arrayList = multiParagraph.paragraphInfoList;
            AndroidPath Path = OnTimeoutKt.Path();
            int size = arrayList.size();
            for (int findParagraphByIndex = MultiParagraphKt.findParagraphByIndex(r9, arrayList); findParagraphByIndex < size; findParagraphByIndex++) {
                ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(findParagraphByIndex);
                int r5 = paragraphInfo.startIndex;
                if (r5 >= r10) {
                    break;
                }
                if (r5 != paragraphInfo.endIndex) {
                    AndroidPath pathForRange = paragraphInfo.paragraph.getPathForRange(paragraphInfo.toLocalIndex(r9), paragraphInfo.toLocalIndex(r10));
                    Intrinsics.checkNotNullParameter(pathForRange, "<this>");
                    pathForRange.m307translatek4lQ0M(OffsetKt.Offset(0.0f, paragraphInfo.top));
                    Path.m303addPathUv8p0NA(pathForRange, Offset.Zero);
                }
            }
            return Path;
        }
        StringBuilder m = ValidatingOffsetMapping$$ExternalSyntheticOutline0.m("Start(", r9, ") or End(", r10, ") is out of range [0..");
        m.append(multiParagraphIntrinsics.annotatedString.text.length());
        m.append("), or start > end!");
        throw new IllegalArgumentException(m.toString().toString());
    }

    /* renamed from: getWordBoundary--jx7JFs */
    public final long m520getWordBoundaryjx7JFs(int r6) {
        int findParagraphByIndex;
        MultiParagraph multiParagraph = this.multiParagraph;
        multiParagraph.requireIndexInRangeInclusiveEnd(r6);
        int length = multiParagraph.intrinsics.annotatedString.length();
        ArrayList arrayList = multiParagraph.paragraphInfoList;
        if (r6 == length) {
            findParagraphByIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
        } else {
            findParagraphByIndex = MultiParagraphKt.findParagraphByIndex(r6, arrayList);
        }
        ParagraphInfo paragraphInfo = (ParagraphInfo) arrayList.get(findParagraphByIndex);
        long mo508getWordBoundaryjx7JFs = paragraphInfo.paragraph.mo508getWordBoundaryjx7JFs(paragraphInfo.toLocalIndex(r6));
        int r62 = TextRange.$r8$clinit;
        int r0 = paragraphInfo.startIndex;
        return TextRangeKt.TextRange(((int) (mo508getWordBoundaryjx7JFs >> 32)) + r0, TextRange.m523getEndimpl(mo508getWordBoundaryjx7JFs) + r0);
    }

    public final int hashCode() {
        return this.placeholderRects.hashCode() + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.lastBaseline, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.firstBaseline, Scale$$ExternalSyntheticOutline0.m(this.size, (this.multiParagraph.hashCode() + (this.layoutInput.hashCode() * 31)) * 31, 31), 31), 31);
    }

    public final String toString() {
        return "TextLayoutResult(layoutInput=" + this.layoutInput + ", multiParagraph=" + this.multiParagraph + ", size=" + ((Object) IntSize.m594toStringimpl(this.size)) + ", firstBaseline=" + this.firstBaseline + ", lastBaseline=" + this.lastBaseline + ", placeholderRects=" + this.placeholderRects + ')';
    }
}
