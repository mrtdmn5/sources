package androidx.compose.ui.focus;

/* compiled from: FocusProperties.kt */
/* loaded from: classes.dex */
public final class FocusPropertiesImpl implements FocusProperties {
    public boolean canFocus = true;
    public final FocusRequester down;
    public final FocusRequester end;
    public final FocusPropertiesImpl$enter$1 enter;
    public final FocusPropertiesImpl$exit$1 exit;
    public final FocusRequester left;
    public final FocusRequester next;
    public final FocusRequester previous;
    public final FocusRequester right;
    public final FocusRequester start;
    public final FocusRequester up;

    public FocusPropertiesImpl() {
        FocusRequester focusRequester = FocusRequester.Default;
        this.next = focusRequester;
        this.previous = focusRequester;
        this.up = focusRequester;
        this.down = focusRequester;
        this.left = focusRequester;
        this.right = focusRequester;
        this.start = focusRequester;
        this.end = focusRequester;
        this.enter = FocusPropertiesImpl$enter$1.INSTANCE;
        this.exit = FocusPropertiesImpl$exit$1.INSTANCE;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final boolean getCanFocus() {
        return this.canFocus;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public final void setCanFocus(boolean z) {
        this.canFocus = z;
    }
}
