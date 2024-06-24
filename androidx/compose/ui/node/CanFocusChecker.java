package androidx.compose.ui.node;

import androidx.compose.ui.focus.FocusProperties;

/* compiled from: NodeKind.kt */
/* loaded from: classes.dex */
public final class CanFocusChecker implements FocusProperties {
    public static final CanFocusChecker INSTANCE = new CanFocusChecker();
    public static Boolean canFocusValue;

    @Override // androidx.compose.ui.focus.FocusProperties
    public final boolean getCanFocus() {
        Boolean bool = canFocusValue;
        if (bool != null) {
            return bool.booleanValue();
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final void setCanFocus(boolean z) {
        canFocusValue = Boolean.valueOf(z);
    }
}
