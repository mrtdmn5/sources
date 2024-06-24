package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextPreparedSelectionState;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.FinishComposingTextCommand;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextFieldKeyInput.kt */
/* loaded from: classes.dex */
public final class TextFieldKeyInput {
    public final boolean editable;
    public final int imeAction;
    public final DeadKeyCombiner keyCombiner;
    public final KeyMapping keyMapping;
    public final OffsetMapping offsetMapping;
    public final Function1<TextFieldValue, Unit> onValueChange;
    public final TextPreparedSelectionState preparedSelectionState;
    public final TextFieldSelectionManager selectionManager;
    public final boolean singleLine;
    public final TextFieldState state;
    public final UndoManager undoManager;
    public final TextFieldValue value;

    public TextFieldKeyInput() {
        throw null;
    }

    public TextFieldKeyInput(TextFieldState state, TextFieldSelectionManager selectionManager, TextFieldValue value, boolean z, boolean z2, TextPreparedSelectionState preparedSelectionState, OffsetMapping offsetMapping, UndoManager undoManager, DeadKeyCombiner keyCombiner, Function1 onValueChange, int r13) {
        KeyMapping_androidKt$platformDefaultKeyMapping$1 keyMapping_androidKt$platformDefaultKeyMapping$1 = KeyMapping_androidKt.platformDefaultKeyMapping;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(selectionManager, "selectionManager");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(preparedSelectionState, "preparedSelectionState");
        Intrinsics.checkNotNullParameter(offsetMapping, "offsetMapping");
        Intrinsics.checkNotNullParameter(keyCombiner, "keyCombiner");
        Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
        this.state = state;
        this.selectionManager = selectionManager;
        this.value = value;
        this.editable = z;
        this.singleLine = z2;
        this.preparedSelectionState = preparedSelectionState;
        this.offsetMapping = offsetMapping;
        this.undoManager = undoManager;
        this.keyCombiner = keyCombiner;
        this.keyMapping = keyMapping_androidKt$platformDefaultKeyMapping$1;
        this.onValueChange = onValueChange;
        this.imeAction = r13;
    }

    public final void apply(List<? extends EditCommand> list) {
        EditProcessor editProcessor = this.state.processor;
        ArrayList mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        mutableList.add(0, new FinishComposingTextCommand());
        this.onValueChange.invoke(editProcessor.apply(mutableList));
    }
}
