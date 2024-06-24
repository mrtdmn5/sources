package androidx.compose.ui.text.input;

import androidx.compose.foundation.layout.AndroidWindowInsets$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: EditCommand.kt */
/* loaded from: classes.dex */
public final class SetSelectionCommand implements EditCommand {
    public final int end;
    public final int start;

    public SetSelectionCommand(int r1, int r2) {
        this.start = r1;
        this.end = r2;
    }

    @Override // androidx.compose.ui.text.input.EditCommand
    public final void applyTo(EditingBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int coerceIn = RangesKt___RangesKt.coerceIn(this.start, 0, buffer.getLength$ui_text_release());
        int coerceIn2 = RangesKt___RangesKt.coerceIn(this.end, 0, buffer.getLength$ui_text_release());
        if (coerceIn < coerceIn2) {
            buffer.setSelection$ui_text_release(coerceIn, coerceIn2);
        } else {
            buffer.setSelection$ui_text_release(coerceIn2, coerceIn);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SetSelectionCommand)) {
            return false;
        }
        SetSelectionCommand setSelectionCommand = (SetSelectionCommand) obj;
        if (this.start == setSelectionCommand.start && this.end == setSelectionCommand.end) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.start * 31) + this.end;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SetSelectionCommand(start=");
        sb.append(this.start);
        sb.append(", end=");
        return AndroidWindowInsets$$ExternalSyntheticOutline0.m(sb, this.end, ')');
    }
}
