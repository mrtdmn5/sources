package androidx.compose.ui.focus;

import kotlin.NoWhenBranchMatchedException;

/* compiled from: FocusState.kt */
/* loaded from: classes.dex */
public enum FocusStateImpl implements FocusState {
    Active,
    ActiveParent,
    Captured,
    Inactive;

    /* compiled from: FocusState.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[FocusStateImpl.values().length];
            try {
                r0[FocusStateImpl.Captured.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[FocusStateImpl.Active.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[FocusStateImpl.ActiveParent.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    @Override // androidx.compose.ui.focus.FocusState
    public boolean getHasFocus() {
        int r0 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (r0 == 1 || r0 == 2 || r0 == 3) {
            return true;
        }
        if (r0 == 4) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    public boolean isCaptured() {
        int r0 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (r0 == 1) {
            return true;
        }
        if (r0 != 2 && r0 != 3 && r0 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return false;
    }

    @Override // androidx.compose.ui.focus.FocusState
    public boolean isFocused() {
        int r0 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (r0 == 1 || r0 == 2) {
            return true;
        }
        if (r0 != 3 && r0 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return false;
    }
}
