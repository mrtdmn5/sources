package androidx.compose.ui.text.input;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: EditCommand.kt */
/* loaded from: classes.dex */
public final class FinishComposingTextCommand implements EditCommand {
    @Override // androidx.compose.ui.text.input.EditCommand
    public final void applyTo(EditingBuffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        buffer.compositionStart = -1;
        buffer.compositionEnd = -1;
    }

    public final boolean equals(Object obj) {
        return obj instanceof FinishComposingTextCommand;
    }

    public final int hashCode() {
        return Reflection.getOrCreateKotlinClass(FinishComposingTextCommand.class).hashCode();
    }

    public final String toString() {
        return "FinishComposingTextCommand()";
    }
}
