package androidx.compose.ui.text.input;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import androidx.compose.ui.text.AnnotatedString;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: EditCommand.kt */
/* loaded from: classes.dex */
public final class SetComposingTextCommand implements EditCommand {
    public final AnnotatedString annotatedString;
    public final int newCursorPosition;

    public SetComposingTextCommand(String str, int r5) {
        this.annotatedString = new AnnotatedString(str, null, 6);
        this.newCursorPosition = r5;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public final void applyTo(EditingBuffer buffer) {
        boolean z;
        boolean z2;
        int length;
        boolean z3;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int r0 = buffer.compositionStart;
        int r3 = -1;
        if (r0 != -1) {
            z = true;
        } else {
            z = false;
        }
        AnnotatedString annotatedString = this.annotatedString;
        if (z) {
            buffer.replace$ui_text_release(r0, buffer.compositionEnd, annotatedString.text);
            String str = annotatedString.text;
            if (str.length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                buffer.setComposition$ui_text_release(r0, str.length() + r0);
            }
        } else {
            int r02 = buffer.selectionStart;
            buffer.replace$ui_text_release(r02, buffer.selectionEnd, annotatedString.text);
            String str2 = annotatedString.text;
            if (str2.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                buffer.setComposition$ui_text_release(r02, str2.length() + r02);
            }
        }
        int r03 = buffer.selectionStart;
        int r4 = buffer.selectionEnd;
        if (r03 == r4) {
            r3 = r4;
        }
        int r04 = this.newCursorPosition;
        int r32 = r3 + r04;
        if (r04 > 0) {
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
        if (!(obj instanceof SetComposingTextCommand)) {
            return false;
        }
        SetComposingTextCommand setComposingTextCommand = (SetComposingTextCommand) obj;
        if (Intrinsics.areEqual(this.annotatedString.text, setComposingTextCommand.annotatedString.text) && this.newCursorPosition == setComposingTextCommand.newCursorPosition) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.annotatedString.text.hashCode() * 31) + this.newCursorPosition;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SetComposingTextCommand(text='");
        sb.append(this.annotatedString.text);
        sb.append("', newCursorPosition=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.newCursorPosition, ')');
    }
}
