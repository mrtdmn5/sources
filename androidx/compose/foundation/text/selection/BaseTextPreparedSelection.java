package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.StringHelpers_androidKt;
import androidx.compose.foundation.text.selection.BaseTextPreparedSelection;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import io.ktor.http.content.NullBody;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextPreparedSelection.kt */
/* loaded from: classes.dex */
public abstract class BaseTextPreparedSelection<T extends BaseTextPreparedSelection<T>> {
    public final AnnotatedString annotatedString;
    public final TextLayoutResult layoutResult;
    public final OffsetMapping offsetMapping;
    public final long originalSelection;
    public final AnnotatedString originalText;
    public long selection;
    public final TextPreparedSelectionState state;

    public BaseTextPreparedSelection(AnnotatedString originalText, long j, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, TextPreparedSelectionState state) {
        Intrinsics.checkNotNullParameter(originalText, "originalText");
        Intrinsics.checkNotNullParameter(offsetMapping, "offsetMapping");
        Intrinsics.checkNotNullParameter(state, "state");
        this.originalText = originalText;
        this.originalSelection = j;
        this.layoutResult = textLayoutResult;
        this.offsetMapping = offsetMapping;
        this.state = state;
        this.selection = j;
        this.annotatedString = originalText;
    }

    public final Integer getLineEndByOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            int m524getMaximpl = TextRange.m524getMaximpl(this.selection);
            OffsetMapping offsetMapping = this.offsetMapping;
            return Integer.valueOf(offsetMapping.transformedToOriginal(textLayoutResult.getLineEnd(textLayoutResult.getLineForOffset(offsetMapping.originalToTransformed(m524getMaximpl)), true)));
        }
        return null;
    }

    public final Integer getLineStartByOffset() {
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            int m525getMinimpl = TextRange.m525getMinimpl(this.selection);
            OffsetMapping offsetMapping = this.offsetMapping;
            return Integer.valueOf(offsetMapping.transformedToOriginal(textLayoutResult.getLineStart(textLayoutResult.getLineForOffset(offsetMapping.originalToTransformed(m525getMinimpl)))));
        }
        return null;
    }

    public final Integer getNextWordOffset() {
        int length;
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            int transformedEndOffset = transformedEndOffset();
            while (true) {
                AnnotatedString annotatedString = this.originalText;
                if (transformedEndOffset >= annotatedString.length()) {
                    length = annotatedString.length();
                    break;
                }
                int length2 = this.annotatedString.text.length() - 1;
                if (transformedEndOffset <= length2) {
                    length2 = transformedEndOffset;
                }
                long m520getWordBoundaryjx7JFs = textLayoutResult.m520getWordBoundaryjx7JFs(length2);
                if (TextRange.m523getEndimpl(m520getWordBoundaryjx7JFs) <= transformedEndOffset) {
                    transformedEndOffset++;
                } else {
                    length = this.offsetMapping.transformedToOriginal(TextRange.m523getEndimpl(m520getWordBoundaryjx7JFs));
                    break;
                }
            }
            return Integer.valueOf(length);
        }
        return null;
    }

    public final Integer getPreviousWordOffset() {
        int r0;
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            int transformedEndOffset = transformedEndOffset();
            while (true) {
                if (transformedEndOffset <= 0) {
                    r0 = 0;
                    break;
                }
                int length = this.annotatedString.text.length() - 1;
                if (transformedEndOffset <= length) {
                    length = transformedEndOffset;
                }
                int m520getWordBoundaryjx7JFs = (int) (textLayoutResult.m520getWordBoundaryjx7JFs(length) >> 32);
                if (m520getWordBoundaryjx7JFs >= transformedEndOffset) {
                    transformedEndOffset--;
                } else {
                    r0 = this.offsetMapping.transformedToOriginal(m520getWordBoundaryjx7JFs);
                    break;
                }
            }
            return Integer.valueOf(r0);
        }
        return null;
    }

    public final boolean isLtr() {
        ResolvedTextDirection resolvedTextDirection;
        TextLayoutResult textLayoutResult = this.layoutResult;
        if (textLayoutResult != null) {
            resolvedTextDirection = textLayoutResult.getParagraphDirection(transformedEndOffset());
        } else {
            resolvedTextDirection = null;
        }
        if (resolvedTextDirection != ResolvedTextDirection.Rtl) {
            return true;
        }
        return false;
    }

    public final int jumpByLinesOffset(TextLayoutResult textLayoutResult, int r7) {
        int transformedEndOffset = transformedEndOffset();
        TextPreparedSelectionState textPreparedSelectionState = this.state;
        if (textPreparedSelectionState.cachedX == null) {
            textPreparedSelectionState.cachedX = Float.valueOf(textLayoutResult.getCursorRect(transformedEndOffset).left);
        }
        int lineForOffset = textLayoutResult.getLineForOffset(transformedEndOffset) + r7;
        if (lineForOffset < 0) {
            return 0;
        }
        if (lineForOffset >= textLayoutResult.multiParagraph.lineCount) {
            return this.annotatedString.text.length();
        }
        float lineBottom = textLayoutResult.getLineBottom(lineForOffset) - 1;
        Float f = textPreparedSelectionState.cachedX;
        Intrinsics.checkNotNull(f);
        float floatValue = f.floatValue();
        if ((isLtr() && floatValue >= textLayoutResult.getLineRight(lineForOffset)) || (!isLtr() && floatValue <= textLayoutResult.getLineLeft(lineForOffset))) {
            return textLayoutResult.getLineEnd(lineForOffset, true);
        }
        return this.offsetMapping.transformedToOriginal(textLayoutResult.m519getOffsetForPositionk4lQ0M(OffsetKt.Offset(f.floatValue(), lineBottom)));
    }

    public final void moveCursorLeft() {
        boolean z;
        this.state.cachedX = null;
        if (this.annotatedString.text.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (isLtr()) {
                moveCursorPrev();
            } else {
                moveCursorNext();
            }
        }
    }

    public final void moveCursorLeftByWord() {
        boolean z;
        this.state.cachedX = null;
        if (this.annotatedString.text.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (isLtr()) {
                moveCursorPrevByWord();
            } else {
                moveCursorNextByWord();
            }
        }
    }

    public final void moveCursorNext() {
        boolean z;
        this.state.cachedX = null;
        AnnotatedString annotatedString = this.annotatedString;
        if (annotatedString.text.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int findFollowingBreak = StringHelpers_androidKt.findFollowingBreak(TextRange.m523getEndimpl(this.selection), annotatedString.text);
            if (findFollowingBreak != -1) {
                setSelection(findFollowingBreak, findFollowingBreak);
            }
        }
    }

    public final void moveCursorNextByParagraph() {
        boolean z;
        this.state.cachedX = null;
        AnnotatedString annotatedString = this.annotatedString;
        if (annotatedString.text.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int findParagraphEnd = NullBody.findParagraphEnd(TextRange.m524getMaximpl(this.selection), annotatedString.text);
            setSelection(findParagraphEnd, findParagraphEnd);
        }
    }

    public final void moveCursorNextByWord() {
        boolean z;
        Integer nextWordOffset;
        this.state.cachedX = null;
        if (this.annotatedString.text.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z && (nextWordOffset = getNextWordOffset()) != null) {
            int intValue = nextWordOffset.intValue();
            setSelection(intValue, intValue);
        }
    }

    public final void moveCursorPrev() {
        boolean z;
        this.state.cachedX = null;
        AnnotatedString annotatedString = this.annotatedString;
        if (annotatedString.text.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int findPrecedingBreak = StringHelpers_androidKt.findPrecedingBreak(TextRange.m523getEndimpl(this.selection), annotatedString.text);
            if (findPrecedingBreak != -1) {
                setSelection(findPrecedingBreak, findPrecedingBreak);
            }
        }
    }

    public final void moveCursorPrevByParagraph() {
        boolean z;
        this.state.cachedX = null;
        AnnotatedString annotatedString = this.annotatedString;
        int r2 = 0;
        if (annotatedString.text.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int m525getMinimpl = TextRange.m525getMinimpl(this.selection);
            String str = annotatedString.text;
            Intrinsics.checkNotNullParameter(str, "<this>");
            int r1 = m525getMinimpl - 1;
            while (true) {
                if (r1 <= 0) {
                    break;
                }
                int r3 = r1 - 1;
                if (str.charAt(r3) == '\n') {
                    r2 = r1;
                    break;
                }
                r1 = r3;
            }
            setSelection(r2, r2);
        }
    }

    public final void moveCursorPrevByWord() {
        boolean z;
        Integer previousWordOffset;
        this.state.cachedX = null;
        if (this.annotatedString.text.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z && (previousWordOffset = getPreviousWordOffset()) != null) {
            int intValue = previousWordOffset.intValue();
            setSelection(intValue, intValue);
        }
    }

    public final void moveCursorRight() {
        boolean z;
        this.state.cachedX = null;
        if (this.annotatedString.text.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (isLtr()) {
                moveCursorNext();
            } else {
                moveCursorPrev();
            }
        }
    }

    public final void moveCursorRightByWord() {
        boolean z;
        this.state.cachedX = null;
        if (this.annotatedString.text.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (isLtr()) {
                moveCursorNextByWord();
            } else {
                moveCursorPrevByWord();
            }
        }
    }

    public final void moveCursorToEnd() {
        boolean z;
        this.state.cachedX = null;
        AnnotatedString annotatedString = this.annotatedString;
        if (annotatedString.text.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int length = annotatedString.text.length();
            setSelection(length, length);
        }
    }

    public final void moveCursorToLineEnd() {
        boolean z;
        Integer lineEndByOffset;
        this.state.cachedX = null;
        if (this.annotatedString.text.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z && (lineEndByOffset = getLineEndByOffset()) != null) {
            int intValue = lineEndByOffset.intValue();
            setSelection(intValue, intValue);
        }
    }

    public final void moveCursorToLineLeftSide() {
        boolean z;
        this.state.cachedX = null;
        if (this.annotatedString.text.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (isLtr()) {
                moveCursorToLineStart();
            } else {
                moveCursorToLineEnd();
            }
        }
    }

    public final void moveCursorToLineRightSide() {
        boolean z;
        this.state.cachedX = null;
        if (this.annotatedString.text.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (isLtr()) {
                moveCursorToLineEnd();
            } else {
                moveCursorToLineStart();
            }
        }
    }

    public final void moveCursorToLineStart() {
        boolean z;
        Integer lineStartByOffset;
        this.state.cachedX = null;
        if (this.annotatedString.text.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z && (lineStartByOffset = getLineStartByOffset()) != null) {
            int intValue = lineStartByOffset.intValue();
            setSelection(intValue, intValue);
        }
    }

    public final void selectMovement() {
        boolean z;
        if (this.annotatedString.text.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int r0 = TextRange.$r8$clinit;
            this.selection = TextRangeKt.TextRange((int) (this.originalSelection >> 32), TextRange.m523getEndimpl(this.selection));
        }
    }

    public final void setSelection(int r1, int r2) {
        this.selection = TextRangeKt.TextRange(r1, r2);
    }

    public final int transformedEndOffset() {
        return this.offsetMapping.originalToTransformed(TextRange.m523getEndimpl(this.selection));
    }
}
