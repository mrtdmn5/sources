package androidx.compose.ui.text.input;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import com.google.firebase.concurrent.ExecutorsRegistrar$$ExternalSyntheticLambda8;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EditCommand.kt */
/* loaded from: classes.dex */
public final class DeleteSurroundingTextInCodePointsCommand implements EditCommand {
    public final int lengthAfterCursor;
    public final int lengthBeforeCursor;

    public DeleteSurroundingTextInCodePointsCommand(int r4, int r5) {
        boolean z;
        this.lengthBeforeCursor = r4;
        this.lengthAfterCursor = r5;
        if (r4 >= 0 && r5 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
        } else {
            throw new IllegalArgumentException(ExecutorsRegistrar$$ExternalSyntheticLambda8.m("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were ", r4, " and ", r5, " respectively.").toString());
        }
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public final void applyTo(EditingBuffer buffer) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int r2 = 0;
        for (int r1 = 0; r1 < this.lengthBeforeCursor; r1++) {
            r2++;
            if (buffer.selectionStart > r2) {
                char c = buffer.get$ui_text_release((r3 - r2) - 1);
                char c2 = buffer.get$ui_text_release(buffer.selectionStart - r2);
                if (Character.isHighSurrogate(c) && Character.isLowSurrogate(c2)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    r2++;
                }
            }
            if (r2 == buffer.selectionStart) {
                break;
            }
        }
        int r3 = 0;
        for (int r12 = 0; r12 < this.lengthAfterCursor; r12++) {
            r3++;
            if (buffer.selectionEnd + r3 < buffer.getLength$ui_text_release()) {
                char c3 = buffer.get$ui_text_release((buffer.selectionEnd + r3) - 1);
                char c4 = buffer.get$ui_text_release(buffer.selectionEnd + r3);
                if (Character.isHighSurrogate(c3) && Character.isLowSurrogate(c4)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    r3++;
                }
            }
            if (buffer.selectionEnd + r3 == buffer.getLength$ui_text_release()) {
                break;
            }
        }
        int r0 = buffer.selectionEnd;
        buffer.delete$ui_text_release(r0, r3 + r0);
        int r02 = buffer.selectionStart;
        buffer.delete$ui_text_release(r02 - r2, r02);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeleteSurroundingTextInCodePointsCommand)) {
            return false;
        }
        DeleteSurroundingTextInCodePointsCommand deleteSurroundingTextInCodePointsCommand = (DeleteSurroundingTextInCodePointsCommand) obj;
        if (this.lengthBeforeCursor == deleteSurroundingTextInCodePointsCommand.lengthBeforeCursor && this.lengthAfterCursor == deleteSurroundingTextInCodePointsCommand.lengthAfterCursor) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.lengthBeforeCursor * 31) + this.lengthAfterCursor;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DeleteSurroundingTextInCodePointsCommand(lengthBeforeCursor=");
        sb.append(this.lengthBeforeCursor);
        sb.append(", lengthAfterCursor=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.lengthAfterCursor, ')');
    }
}
