package androidx.compose.ui.text.input;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import com.google.firebase.concurrent.ExecutorsRegistrar$$ExternalSyntheticLambda8;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EditCommand.kt */
/* loaded from: classes.dex */
public final class DeleteSurroundingTextCommand implements EditCommand {
    public final int lengthAfterCursor;
    public final int lengthBeforeCursor;

    public DeleteSurroundingTextCommand(int r4, int r5) {
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
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int r0 = buffer.selectionEnd;
        int r1 = this.lengthAfterCursor;
        int r2 = r0 + r1;
        if (((r0 ^ r2) & (r1 ^ r2)) < 0) {
            r2 = buffer.getLength$ui_text_release();
        }
        buffer.delete$ui_text_release(buffer.selectionEnd, Math.min(r2, buffer.getLength$ui_text_release()));
        int r02 = buffer.selectionStart;
        DeleteSurroundingTextCommand$applyTo$start$1 defaultValue = new Function0<Integer>() { // from class: androidx.compose.ui.text.input.DeleteSurroundingTextCommand$applyTo$start$1
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return 0;
            }
        };
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        int r12 = this.lengthBeforeCursor;
        int r22 = r02 - r12;
        if (((r02 ^ r22) & (r12 ^ r02)) < 0) {
            Integer num = 0;
            r22 = num.intValue();
        }
        buffer.delete$ui_text_release(Math.max(0, r22), buffer.selectionStart);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeleteSurroundingTextCommand)) {
            return false;
        }
        DeleteSurroundingTextCommand deleteSurroundingTextCommand = (DeleteSurroundingTextCommand) obj;
        if (this.lengthBeforeCursor == deleteSurroundingTextCommand.lengthBeforeCursor && this.lengthAfterCursor == deleteSurroundingTextCommand.lengthAfterCursor) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.lengthBeforeCursor * 31) + this.lengthAfterCursor;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DeleteSurroundingTextCommand(lengthBeforeCursor=");
        sb.append(this.lengthBeforeCursor);
        sb.append(", lengthAfterCursor=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.lengthAfterCursor, ')');
    }
}
