package androidx.compose.ui.text.input;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.AnnotatedString;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: EditCommand.kt */
/* loaded from: classes.dex */
public final class CommitTextCommand implements EditCommand {
    public final AnnotatedString annotatedString;
    public final int newCursorPosition;

    public CommitTextCommand(AnnotatedString annotatedString, int r3) {
        Intrinsics.checkNotNullParameter(annotatedString, "annotatedString");
        this.annotatedString = annotatedString;
        this.newCursorPosition = r3;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public final void applyTo(EditingBuffer buffer) {
        boolean z;
        int length;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int r0 = buffer.compositionStart;
        if (r0 != -1) {
            z = true;
        } else {
            z = false;
        }
        AnnotatedString annotatedString = this.annotatedString;
        if (z) {
            buffer.replace$ui_text_release(r0, buffer.compositionEnd, annotatedString.text);
        } else {
            buffer.replace$ui_text_release(buffer.selectionStart, buffer.selectionEnd, annotatedString.text);
        }
        int r02 = buffer.selectionStart;
        int r3 = buffer.selectionEnd;
        if (r02 != r3) {
            r3 = -1;
        }
        int r03 = this.newCursorPosition;
        int r32 = r3 + r03;
        if (r03 > 0) {
            length = r32 - 1;
        } else {
            length = r32 - annotatedString.text.length();
        }
        int coerceIn = RangesKt___RangesKt.coerceIn(length, 0, buffer.getLength$ui_text_release());
        buffer.setSelection$ui_text_release(coerceIn, coerceIn);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommitTextCommand)) {
            return false;
        }
        CommitTextCommand commitTextCommand = (CommitTextCommand) obj;
        if (Intrinsics.areEqual(this.annotatedString.text, commitTextCommand.annotatedString.text) && this.newCursorPosition == commitTextCommand.newCursorPosition) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.annotatedString.text.hashCode() * 31) + this.newCursorPosition;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CommitTextCommand(text='");
        sb.append(this.annotatedString.text);
        sb.append("', newCursorPosition=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.newCursorPosition, ')');
    }

    public CommitTextCommand(String str, int r5) {
        this(new AnnotatedString(str, null, 6), r5);
    }
}
