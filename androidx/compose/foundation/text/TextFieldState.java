package androidx.compose.foundation.text;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.ui.graphics.AndroidPaint;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.unit.Dp;
import com.google.common.collect.Platform;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoreTextField.kt */
/* loaded from: classes.dex */
public final class TextFieldState {
    public final ParcelableSnapshotMutableState handleState$delegate;
    public final ParcelableSnapshotMutableState hasFocus$delegate;
    public TextInputSession inputSession;
    public boolean isLayoutResultStale;
    public final KeyboardActionRunner keyboardActionRunner;
    public LayoutCoordinates layoutCoordinates;
    public final ParcelableSnapshotMutableState layoutResultState;
    public final ParcelableSnapshotMutableState minHeightForSingleLineField$delegate;
    public final TextFieldState$onImeActionPerformed$1 onImeActionPerformed;
    public final TextFieldState$onValueChange$1 onValueChange;
    public Function1<? super TextFieldValue, Unit> onValueChangeOriginal;
    public final EditProcessor processor = new EditProcessor();
    public final RecomposeScope recomposeScope;
    public final AndroidPaint selectionPaint;
    public final ParcelableSnapshotMutableState showCursorHandle$delegate;
    public boolean showFloatingToolbar;
    public final ParcelableSnapshotMutableState showSelectionHandleEnd$delegate;
    public final ParcelableSnapshotMutableState showSelectionHandleStart$delegate;
    public TextDelegate textDelegate;
    public AnnotatedString untransformedText;

    public TextFieldState(TextDelegate textDelegate, RecomposeScope recomposeScope) {
        this.textDelegate = textDelegate;
        this.recomposeScope = recomposeScope;
        Boolean bool = Boolean.FALSE;
        this.hasFocus$delegate = Platform.mutableStateOf$default(bool);
        this.minHeightForSingleLineField$delegate = Platform.mutableStateOf$default(new Dp(0));
        this.layoutResultState = Platform.mutableStateOf$default(null);
        this.handleState$delegate = Platform.mutableStateOf$default(HandleState.None);
        this.showSelectionHandleStart$delegate = Platform.mutableStateOf$default(bool);
        this.showSelectionHandleEnd$delegate = Platform.mutableStateOf$default(bool);
        this.showCursorHandle$delegate = Platform.mutableStateOf$default(bool);
        this.isLayoutResultStale = true;
        this.keyboardActionRunner = new KeyboardActionRunner();
        this.onValueChangeOriginal = new Function1<TextFieldValue, Unit>() { // from class: androidx.compose.foundation.text.TextFieldState$onValueChangeOriginal$1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(TextFieldValue textFieldValue) {
                TextFieldValue it = textFieldValue;
                Intrinsics.checkNotNullParameter(it, "it");
                return Unit.INSTANCE;
            }
        };
        this.onValueChange = new TextFieldState$onValueChange$1(this);
        this.onImeActionPerformed = new TextFieldState$onImeActionPerformed$1(this);
        this.selectionPaint = AndroidPaint_androidKt.Paint();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final HandleState getHandleState() {
        return (HandleState) this.handleState$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getHasFocus() {
        return ((Boolean) this.hasFocus$delegate.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TextLayoutResultProxy getLayoutResult() {
        return (TextLayoutResultProxy) this.layoutResultState.getValue();
    }
}
