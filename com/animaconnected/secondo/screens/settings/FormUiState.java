package com.animaconnected.secondo.screens.settings;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: FormValidationViewModel.kt */
/* loaded from: classes3.dex */
public final class FormUiState {
    public static final int $stable = 0;
    private final boolean hasEmailFocus;
    private final boolean hasPasswordFocus;
    private final boolean isEmailEmpty;
    private final boolean isEmailValid;
    private final boolean isFormValid;
    private final boolean isPasswordEmpty;
    private final boolean isPasswordValid;

    public FormUiState() {
        this(false, false, false, false, false, false, false, R.styleable.AppTheme_statusTextH5, null);
    }

    public static /* synthetic */ FormUiState copy$default(FormUiState formUiState, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int r13, Object obj) {
        if ((r13 & 1) != 0) {
            z = formUiState.hasEmailFocus;
        }
        if ((r13 & 2) != 0) {
            z2 = formUiState.hasPasswordFocus;
        }
        boolean z8 = z2;
        if ((r13 & 4) != 0) {
            z3 = formUiState.isEmailValid;
        }
        boolean z9 = z3;
        if ((r13 & 8) != 0) {
            z4 = formUiState.isPasswordValid;
        }
        boolean z10 = z4;
        if ((r13 & 16) != 0) {
            z5 = formUiState.isEmailEmpty;
        }
        boolean z11 = z5;
        if ((r13 & 32) != 0) {
            z6 = formUiState.isPasswordEmpty;
        }
        boolean z12 = z6;
        if ((r13 & 64) != 0) {
            z7 = formUiState.isFormValid;
        }
        return formUiState.copy(z, z8, z9, z10, z11, z12, z7);
    }

    public final boolean component1() {
        return this.hasEmailFocus;
    }

    public final boolean component2() {
        return this.hasPasswordFocus;
    }

    public final boolean component3() {
        return this.isEmailValid;
    }

    public final boolean component4() {
        return this.isPasswordValid;
    }

    public final boolean component5() {
        return this.isEmailEmpty;
    }

    public final boolean component6() {
        return this.isPasswordEmpty;
    }

    public final boolean component7() {
        return this.isFormValid;
    }

    public final FormUiState copy(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        return new FormUiState(z, z2, z3, z4, z5, z6, z7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FormUiState)) {
            return false;
        }
        FormUiState formUiState = (FormUiState) obj;
        if (this.hasEmailFocus == formUiState.hasEmailFocus && this.hasPasswordFocus == formUiState.hasPasswordFocus && this.isEmailValid == formUiState.isEmailValid && this.isPasswordValid == formUiState.isPasswordValid && this.isEmailEmpty == formUiState.isEmailEmpty && this.isPasswordEmpty == formUiState.isPasswordEmpty && this.isFormValid == formUiState.isFormValid) {
            return true;
        }
        return false;
    }

    public final boolean getHasEmailFocus() {
        return this.hasEmailFocus;
    }

    public final boolean getHasPasswordFocus() {
        return this.hasPasswordFocus;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isFormValid) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.isPasswordEmpty, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.isEmailEmpty, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.isPasswordValid, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.isEmailValid, JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.hasPasswordFocus, Boolean.hashCode(this.hasEmailFocus) * 31, 31), 31), 31), 31), 31);
    }

    public final boolean isEmailEmpty() {
        return this.isEmailEmpty;
    }

    public final boolean isEmailValid() {
        return this.isEmailValid;
    }

    public final boolean isFormValid() {
        return this.isFormValid;
    }

    public final boolean isPasswordEmpty() {
        return this.isPasswordEmpty;
    }

    public final boolean isPasswordValid() {
        return this.isPasswordValid;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FormUiState(hasEmailFocus=");
        sb.append(this.hasEmailFocus);
        sb.append(", hasPasswordFocus=");
        sb.append(this.hasPasswordFocus);
        sb.append(", isEmailValid=");
        sb.append(this.isEmailValid);
        sb.append(", isPasswordValid=");
        sb.append(this.isPasswordValid);
        sb.append(", isEmailEmpty=");
        sb.append(this.isEmailEmpty);
        sb.append(", isPasswordEmpty=");
        sb.append(this.isPasswordEmpty);
        sb.append(", isFormValid=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.isFormValid, ')');
    }

    public FormUiState(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.hasEmailFocus = z;
        this.hasPasswordFocus = z2;
        this.isEmailValid = z3;
        this.isPasswordValid = z4;
        this.isEmailEmpty = z5;
        this.isPasswordEmpty = z6;
        this.isFormValid = z7;
    }

    public /* synthetic */ FormUiState(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int r14, DefaultConstructorMarker defaultConstructorMarker) {
        this((r14 & 1) != 0 ? false : z, (r14 & 2) != 0 ? false : z2, (r14 & 4) != 0 ? false : z3, (r14 & 8) != 0 ? false : z4, (r14 & 16) != 0 ? true : z5, (r14 & 32) != 0 ? true : z6, (r14 & 64) != 0 ? false : z7);
    }
}
