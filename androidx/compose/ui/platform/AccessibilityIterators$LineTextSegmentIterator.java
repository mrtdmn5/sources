package androidx.compose.ui.platform;

import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccessibilityIterators.android.kt */
/* loaded from: classes.dex */
public final class AccessibilityIterators$LineTextSegmentIterator extends AccessibilityIterators$AbstractTextSegmentIterator {
    public static AccessibilityIterators$LineTextSegmentIterator lineInstance;
    public TextLayoutResult layoutResult;
    public static final ResolvedTextDirection DirectionStart = ResolvedTextDirection.Rtl;
    public static final ResolvedTextDirection DirectionEnd = ResolvedTextDirection.Ltr;

    @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
    public final int[] following(int r6) {
        int r62;
        if (getText().length() <= 0 || r6 >= getText().length()) {
            return null;
        }
        ResolvedTextDirection resolvedTextDirection = DirectionStart;
        if (r6 < 0) {
            TextLayoutResult textLayoutResult = this.layoutResult;
            if (textLayoutResult != null) {
                r62 = textLayoutResult.getLineForOffset(0);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                throw null;
            }
        } else {
            TextLayoutResult textLayoutResult2 = this.layoutResult;
            if (textLayoutResult2 != null) {
                int lineForOffset = textLayoutResult2.getLineForOffset(r6);
                if (getLineEdgeIndex(lineForOffset, resolvedTextDirection) == r6) {
                    r62 = lineForOffset;
                } else {
                    r62 = lineForOffset + 1;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                throw null;
            }
        }
        TextLayoutResult textLayoutResult3 = this.layoutResult;
        if (textLayoutResult3 != null) {
            if (r62 >= textLayoutResult3.multiParagraph.lineCount) {
                return null;
            }
            return getRange(getLineEdgeIndex(r62, resolvedTextDirection), getLineEdgeIndex(r62, DirectionEnd) + 1);
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
        throw null;
    }

    public final int getLineEdgeIndex(int r5, ResolvedTextDirection resolvedTextDirection) {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            int lineStart = textLayoutResult.getLineStart(r5);
            TextLayoutResult textLayoutResult2 = this.layoutResult;
            if (textLayoutResult2 != null) {
                if (resolvedTextDirection != textLayoutResult2.getParagraphDirection(lineStart)) {
                    TextLayoutResult textLayoutResult3 = this.layoutResult;
                    if (textLayoutResult3 != null) {
                        return textLayoutResult3.getLineStart(r5);
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    throw null;
                }
                if (this.layoutResult != null) {
                    return r6.getLineEnd(r5, false) - 1;
                }
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
        throw null;
    }

    @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
    public final int[] preceding(int r5) {
        int r52;
        if (getText().length() <= 0 || r5 <= 0) {
            return null;
        }
        int length = getText().length();
        ResolvedTextDirection resolvedTextDirection = DirectionEnd;
        if (r5 > length) {
            TextLayoutResult textLayoutResult = this.layoutResult;
            if (textLayoutResult != null) {
                r52 = textLayoutResult.getLineForOffset(getText().length());
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                throw null;
            }
        } else {
            TextLayoutResult textLayoutResult2 = this.layoutResult;
            if (textLayoutResult2 != null) {
                int lineForOffset = textLayoutResult2.getLineForOffset(r5);
                if (getLineEdgeIndex(lineForOffset, resolvedTextDirection) + 1 == r5) {
                    r52 = lineForOffset;
                } else {
                    r52 = lineForOffset - 1;
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                throw null;
            }
        }
        if (r52 < 0) {
            return null;
        }
        return getRange(getLineEdgeIndex(r52, DirectionStart), getLineEdgeIndex(r52, resolvedTextDirection) + 1);
    }
}
