package androidx.compose.ui.input;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.platform.AndroidComposeView$_inputModeManager$1;
import com.google.common.collect.Platform;
import kotlin.jvm.functions.Function1;

/* compiled from: InputModeManager.kt */
/* loaded from: classes.dex */
public final class InputModeManagerImpl implements InputModeManager {
    public final ParcelableSnapshotMutableState inputMode$delegate;
    public final Function1<InputMode, Boolean> onRequestInputModeChange;

    public InputModeManagerImpl(int r1, AndroidComposeView$_inputModeManager$1 androidComposeView$_inputModeManager$1) {
        this.onRequestInputModeChange = androidComposeView$_inputModeManager$1;
        this.inputMode$delegate = Platform.mutableStateOf$default(new InputMode(r1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.input.InputModeManager
    /* renamed from: getInputMode-aOaMEAU */
    public final int mo397getInputModeaOaMEAU() {
        return ((InputMode) this.inputMode$delegate.getValue()).value;
    }
}
