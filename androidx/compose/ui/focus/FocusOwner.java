package androidx.compose.ui.focus;

import android.view.KeyEvent;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.unit.LayoutDirection;

/* compiled from: FocusOwner.kt */
/* loaded from: classes.dex */
public interface FocusOwner extends FocusManager {
    void clearFocus(boolean z, boolean z2);

    /* renamed from: dispatchInterceptedSoftKeyboardEvent-ZmokQxo */
    boolean mo239dispatchInterceptedSoftKeyboardEventZmokQxo(KeyEvent keyEvent);

    /* renamed from: dispatchKeyEvent-ZmokQxo */
    boolean mo240dispatchKeyEventZmokQxo(KeyEvent keyEvent);

    boolean dispatchRotaryEvent(RotaryScrollEvent rotaryScrollEvent);

    Rect getFocusRect();

    FocusOwnerImpl$modifier$1 getModifier();

    void releaseFocus();

    void scheduleInvalidation(FocusEventModifierNode focusEventModifierNode);

    void scheduleInvalidation(FocusPropertiesModifierNode focusPropertiesModifierNode);

    void scheduleInvalidation(FocusTargetNode focusTargetNode);

    void setLayoutDirection(LayoutDirection layoutDirection);

    void takeFocus();
}
