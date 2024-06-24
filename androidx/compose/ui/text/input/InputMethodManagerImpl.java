package androidx.compose.ui.text.input;

import android.view.View;
import android.view.inputmethod.ExtractedText;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.coreshims.SoftwareKeyboardControllerCompat;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InputMethodManager.kt */
/* loaded from: classes.dex */
public final class InputMethodManagerImpl implements InputMethodManager {
    public final Lazy imm$delegate;
    public final SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat;
    public final View view;

    public InputMethodManagerImpl(AndroidComposeView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.imm$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new Function0<android.view.inputmethod.InputMethodManager>() { // from class: androidx.compose.ui.text.input.InputMethodManagerImpl$imm$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final android.view.inputmethod.InputMethodManager invoke() {
                Object systemService = InputMethodManagerImpl.this.view.getContext().getSystemService("input_method");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                return (android.view.inputmethod.InputMethodManager) systemService;
            }
        });
        this.softwareKeyboardControllerCompat = new SoftwareKeyboardControllerCompat(view);
    }

    @Override // androidx.compose.ui.text.input.InputMethodManager
    public final void hideSoftInput() {
        this.softwareKeyboardControllerCompat.mImpl.hide();
    }

    @Override // androidx.compose.ui.text.input.InputMethodManager
    public final void restartInput() {
        ((android.view.inputmethod.InputMethodManager) this.imm$delegate.getValue()).restartInput(this.view);
    }

    @Override // androidx.compose.ui.text.input.InputMethodManager
    public final void showSoftInput() {
        this.softwareKeyboardControllerCompat.mImpl.show();
    }

    @Override // androidx.compose.ui.text.input.InputMethodManager
    public final void updateExtractedText(int r3, ExtractedText extractedText) {
        ((android.view.inputmethod.InputMethodManager) this.imm$delegate.getValue()).updateExtractedText(this.view, r3, extractedText);
    }

    @Override // androidx.compose.ui.text.input.InputMethodManager
    public final void updateSelection(int r8, int r9, int r10, int r11) {
        ((android.view.inputmethod.InputMethodManager) this.imm$delegate.getValue()).updateSelection(this.view, r8, r9, r10, r11);
    }
}
