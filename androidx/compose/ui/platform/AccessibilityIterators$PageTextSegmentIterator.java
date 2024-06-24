package androidx.compose.ui.platform;

import android.graphics.Rect;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: AccessibilityIterators.android.kt */
/* loaded from: classes.dex */
public final class AccessibilityIterators$PageTextSegmentIterator extends AccessibilityIterators$AbstractTextSegmentIterator {
    public static AccessibilityIterators$PageTextSegmentIterator pageInstance;
    public TextLayoutResult layoutResult;
    public SemanticsNode node;
    public static final ResolvedTextDirection DirectionStart = ResolvedTextDirection.Rtl;
    public static final ResolvedTextDirection DirectionEnd = ResolvedTextDirection.Ltr;

    public AccessibilityIterators$PageTextSegmentIterator() {
        new Rect();
    }

    @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
    public final int[] following(int r6) {
        int r0;
        if (getText().length() <= 0 || r6 >= getText().length()) {
            return null;
        }
        try {
            SemanticsNode semanticsNode = this.node;
            if (semanticsNode != null) {
                androidx.compose.ui.geometry.Rect boundsInRoot = semanticsNode.getBoundsInRoot();
                int roundToInt = MathKt__MathJVMKt.roundToInt(boundsInRoot.bottom - boundsInRoot.top);
                if (r6 <= 0) {
                    r6 = 0;
                }
                TextLayoutResult textLayoutResult = this.layoutResult;
                if (textLayoutResult != null) {
                    int lineForOffset = textLayoutResult.getLineForOffset(r6);
                    TextLayoutResult textLayoutResult2 = this.layoutResult;
                    if (textLayoutResult2 != null) {
                        float lineTop = textLayoutResult2.getLineTop(lineForOffset) + roundToInt;
                        TextLayoutResult textLayoutResult3 = this.layoutResult;
                        if (textLayoutResult3 != null) {
                            if (lineTop < textLayoutResult3.getLineTop(textLayoutResult3.multiParagraph.lineCount - 1)) {
                                TextLayoutResult textLayoutResult4 = this.layoutResult;
                                if (textLayoutResult4 != null) {
                                    r0 = textLayoutResult4.getLineForVerticalPosition(lineTop);
                                } else {
                                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                                    throw null;
                                }
                            } else {
                                TextLayoutResult textLayoutResult5 = this.layoutResult;
                                if (textLayoutResult5 != null) {
                                    r0 = textLayoutResult5.multiParagraph.lineCount;
                                } else {
                                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                                    throw null;
                                }
                            }
                            return getRange(r6, getLineEdgeIndex(r0 - 1, DirectionEnd) + 1);
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
            Intrinsics.throwUninitializedPropertyAccessException("node");
            throw null;
        } catch (IllegalStateException unused) {
            return null;
        }
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
    public final int[] preceding(int r6) {
        int r0;
        if (getText().length() <= 0 || r6 <= 0) {
            return null;
        }
        try {
            SemanticsNode semanticsNode = this.node;
            if (semanticsNode != null) {
                androidx.compose.ui.geometry.Rect boundsInRoot = semanticsNode.getBoundsInRoot();
                int roundToInt = MathKt__MathJVMKt.roundToInt(boundsInRoot.bottom - boundsInRoot.top);
                int length = getText().length();
                if (length <= r6) {
                    r6 = length;
                }
                TextLayoutResult textLayoutResult = this.layoutResult;
                if (textLayoutResult != null) {
                    int lineForOffset = textLayoutResult.getLineForOffset(r6);
                    TextLayoutResult textLayoutResult2 = this.layoutResult;
                    if (textLayoutResult2 != null) {
                        float lineTop = textLayoutResult2.getLineTop(lineForOffset) - roundToInt;
                        if (lineTop > 0.0f) {
                            TextLayoutResult textLayoutResult3 = this.layoutResult;
                            if (textLayoutResult3 != null) {
                                r0 = textLayoutResult3.getLineForVerticalPosition(lineTop);
                            } else {
                                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                                throw null;
                            }
                        } else {
                            r0 = 0;
                        }
                        if (r6 == getText().length() && r0 < lineForOffset) {
                            r0++;
                        }
                        return getRange(getLineEdgeIndex(r0, DirectionStart), r6);
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("node");
            throw null;
        } catch (IllegalStateException unused) {
            return null;
        }
    }
}
