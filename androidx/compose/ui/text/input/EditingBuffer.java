package androidx.compose.ui.text.input;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.HeightInLinesModifierKt$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.room.util.CursorUtil;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EditingBuffer.kt */
/* loaded from: classes.dex */
public final class EditingBuffer {
    public int compositionEnd;
    public int compositionStart;
    public final PartialGapBuffer gapBuffer;
    public int selectionEnd;
    public int selectionStart;

    public EditingBuffer(AnnotatedString text, long j) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.gapBuffer = new PartialGapBuffer(text.text);
        this.selectionStart = TextRange.m525getMinimpl(j);
        this.selectionEnd = TextRange.m524getMaximpl(j);
        this.compositionStart = -1;
        this.compositionEnd = -1;
        int m525getMinimpl = TextRange.m525getMinimpl(j);
        int m524getMaximpl = TextRange.m524getMaximpl(j);
        if (m525getMinimpl >= 0 && m525getMinimpl <= text.length()) {
            if (m524getMaximpl >= 0 && m524getMaximpl <= text.length()) {
                if (m525getMinimpl <= m524getMaximpl) {
                    return;
                } else {
                    throw new IllegalArgumentException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("Do not set reversed range: ", m525getMinimpl, " > ", m524getMaximpl));
                }
            } else {
                StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("end (", m524getMaximpl, ") offset is outside of text region ");
                m.append(text.length());
                throw new IndexOutOfBoundsException(m.toString());
            }
        }
        StringBuilder m2 = SuggestionsAdapter$$ExternalSyntheticOutline0.m("start (", m525getMinimpl, ") offset is outside of text region ");
        m2.append(text.length());
        throw new IndexOutOfBoundsException(m2.toString());
    }

    public final void delete$ui_text_release(int r5, int r6) {
        boolean z;
        long TextRange = TextRangeKt.TextRange(r5, r6);
        this.gapBuffer.replace(r5, r6, "");
        long m611updateRangeAfterDeletepWDy79M = CursorUtil.m611updateRangeAfterDeletepWDy79M(TextRangeKt.TextRange(this.selectionStart, this.selectionEnd), TextRange);
        setSelectionStart(TextRange.m525getMinimpl(m611updateRangeAfterDeletepWDy79M));
        setSelectionEnd(TextRange.m524getMaximpl(m611updateRangeAfterDeletepWDy79M));
        int r52 = this.compositionStart;
        if (r52 != -1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            long m611updateRangeAfterDeletepWDy79M2 = CursorUtil.m611updateRangeAfterDeletepWDy79M(TextRangeKt.TextRange(r52, this.compositionEnd), TextRange);
            if (TextRange.m522getCollapsedimpl(m611updateRangeAfterDeletepWDy79M2)) {
                this.compositionStart = -1;
                this.compositionEnd = -1;
            } else {
                this.compositionStart = TextRange.m525getMinimpl(m611updateRangeAfterDeletepWDy79M2);
                this.compositionEnd = TextRange.m524getMaximpl(m611updateRangeAfterDeletepWDy79M2);
            }
        }
    }

    public final char get$ui_text_release(int r8) {
        PartialGapBuffer partialGapBuffer = this.gapBuffer;
        GapBuffer gapBuffer = partialGapBuffer.buffer;
        if (gapBuffer == null) {
            return partialGapBuffer.text.charAt(r8);
        }
        int r2 = partialGapBuffer.bufStart;
        if (r8 < r2) {
            return partialGapBuffer.text.charAt(r8);
        }
        int r3 = gapBuffer.capacity;
        int r4 = gapBuffer.gapEnd;
        int r5 = gapBuffer.gapStart;
        int r32 = r3 - (r4 - r5);
        if (r8 < r32 + r2) {
            int r82 = r8 - r2;
            if (r82 < r5) {
                return gapBuffer.buffer[r82];
            }
            return gapBuffer.buffer[(r82 - r5) + r4];
        }
        return partialGapBuffer.text.charAt(r8 - ((r32 - partialGapBuffer.bufEnd) + r2));
    }

    /* renamed from: getComposition-MzsxiRA$ui_text_release, reason: not valid java name */
    public final TextRange m541getCompositionMzsxiRA$ui_text_release() {
        boolean z;
        int r0 = this.compositionStart;
        if (r0 != -1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return new TextRange(TextRangeKt.TextRange(r0, this.compositionEnd));
        }
        return null;
    }

    public final int getLength$ui_text_release() {
        return this.gapBuffer.getLength();
    }

    public final void replace$ui_text_release(int r4, int r5, String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        PartialGapBuffer partialGapBuffer = this.gapBuffer;
        if (r4 >= 0 && r4 <= partialGapBuffer.getLength()) {
            if (r5 >= 0 && r5 <= partialGapBuffer.getLength()) {
                if (r4 <= r5) {
                    partialGapBuffer.replace(r4, r5, text);
                    setSelectionStart(text.length() + r4);
                    setSelectionEnd(text.length() + r4);
                    this.compositionStart = -1;
                    this.compositionEnd = -1;
                    return;
                }
                throw new IllegalArgumentException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("Do not set reversed range: ", r4, " > ", r5));
            }
            StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("end (", r5, ") offset is outside of text region ");
            m.append(partialGapBuffer.getLength());
            throw new IndexOutOfBoundsException(m.toString());
        }
        StringBuilder m2 = SuggestionsAdapter$$ExternalSyntheticOutline0.m("start (", r4, ") offset is outside of text region ");
        m2.append(partialGapBuffer.getLength());
        throw new IndexOutOfBoundsException(m2.toString());
    }

    public final void setComposition$ui_text_release(int r4, int r5) {
        PartialGapBuffer partialGapBuffer = this.gapBuffer;
        if (r4 >= 0 && r4 <= partialGapBuffer.getLength()) {
            if (r5 >= 0 && r5 <= partialGapBuffer.getLength()) {
                if (r4 < r5) {
                    this.compositionStart = r4;
                    this.compositionEnd = r5;
                    return;
                }
                throw new IllegalArgumentException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("Do not set reversed or empty range: ", r4, " > ", r5));
            }
            StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("end (", r5, ") offset is outside of text region ");
            m.append(partialGapBuffer.getLength());
            throw new IndexOutOfBoundsException(m.toString());
        }
        StringBuilder m2 = SuggestionsAdapter$$ExternalSyntheticOutline0.m("start (", r4, ") offset is outside of text region ");
        m2.append(partialGapBuffer.getLength());
        throw new IndexOutOfBoundsException(m2.toString());
    }

    public final void setSelection$ui_text_release(int r4, int r5) {
        PartialGapBuffer partialGapBuffer = this.gapBuffer;
        if (r4 >= 0 && r4 <= partialGapBuffer.getLength()) {
            if (r5 >= 0 && r5 <= partialGapBuffer.getLength()) {
                if (r4 <= r5) {
                    setSelectionStart(r4);
                    setSelectionEnd(r5);
                    return;
                }
                throw new IllegalArgumentException(HeightInLinesModifierKt$$ExternalSyntheticOutline0.m("Do not set reversed range: ", r4, " > ", r5));
            }
            StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("end (", r5, ") offset is outside of text region ");
            m.append(partialGapBuffer.getLength());
            throw new IndexOutOfBoundsException(m.toString());
        }
        StringBuilder m2 = SuggestionsAdapter$$ExternalSyntheticOutline0.m("start (", r4, ") offset is outside of text region ");
        m2.append(partialGapBuffer.getLength());
        throw new IndexOutOfBoundsException(m2.toString());
    }

    public final void setSelectionEnd(int r2) {
        boolean z;
        if (r2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.selectionEnd = r2;
            return;
        }
        throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Cannot set selectionEnd to a negative value: ", r2).toString());
    }

    public final void setSelectionStart(int r2) {
        boolean z;
        if (r2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.selectionStart = r2;
            return;
        }
        throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Cannot set selectionStart to a negative value: ", r2).toString());
    }

    public final String toString() {
        return this.gapBuffer.toString();
    }
}
