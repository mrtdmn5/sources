package com.animaconnected.secondo.screens.settings;

import android.text.TextUtils;
import android.util.Patterns;
import com.animaconnected.secondo.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: FormValidationViewModel.kt */
/* loaded from: classes3.dex */
public final class FormValidationViewModel {
    public static final int minPasswordLength = 10;
    private MutableStateFlow<String> _confirmationCodeFlow;
    private final StateFlow<String> confirmationCodeFlow;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final MutableStateFlow<Boolean> isConfirmationCodeValid = StateFlowKt.MutableStateFlow(Boolean.FALSE);
    private final MutableStateFlow<FormUiState> state = StateFlowKt.MutableStateFlow(new FormUiState(false, false, false, false, false, false, false, R.styleable.AppTheme_statusTextH5, null));
    private String email = "";
    private String password = "";
    private String confirmationCode = "";

    /* compiled from: FormValidationViewModel.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public FormValidationViewModel() {
        StateFlowImpl MutableStateFlow = StateFlowKt.MutableStateFlow("");
        this._confirmationCodeFlow = MutableStateFlow;
        this.confirmationCodeFlow = MutableStateFlow;
    }

    private final boolean isEmailValid() {
        return Patterns.EMAIL_ADDRESS.matcher(StringsKt__StringsKt.trim(this.email).toString()).matches();
    }

    private final boolean isPasswordValid() {
        if (this.password.length() >= 10) {
            return true;
        }
        return false;
    }

    private final FormUiState refreshFormProperties(FormUiState formUiState) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean isEmailValid = isEmailValid();
        boolean isPasswordValid = isPasswordValid();
        if (this.email.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.password.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (isEmailValid() && isPasswordValid()) {
            z3 = true;
        } else {
            z3 = false;
        }
        return FormUiState.copy$default(formUiState, false, false, isEmailValid, isPasswordValid, z, z2, z3, 3, null);
    }

    private final void validateConfirmationCode() {
        boolean z;
        MutableStateFlow<Boolean> mutableStateFlow = this.isConfirmationCodeValid;
        if (this.confirmationCode.length() == 6 && TextUtils.isDigitsOnly(this.confirmationCode)) {
            z = true;
        } else {
            z = false;
        }
        mutableStateFlow.setValue(Boolean.valueOf(z));
    }

    public final String getConfirmationCode() {
        return this.confirmationCode;
    }

    public final StateFlow<String> getConfirmationCodeFlow() {
        return this.confirmationCodeFlow;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getPassword() {
        return this.password;
    }

    public final MutableStateFlow<FormUiState> getState() {
        return this.state;
    }

    public final MutableStateFlow<Boolean> isConfirmationCodeValid() {
        return this.isConfirmationCodeValid;
    }

    public final void setConfirmationCode(String code) {
        Intrinsics.checkNotNullParameter(code, "code");
        this.confirmationCode = code;
        MutableStateFlow<String> mutableStateFlow = this._confirmationCodeFlow;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), code));
        validateConfirmationCode();
    }

    public final void setEmail(String newEmail) {
        FormUiState value;
        Intrinsics.checkNotNullParameter(newEmail, "newEmail");
        this.email = newEmail;
        MutableStateFlow<FormUiState> mutableStateFlow = this.state;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, refreshFormProperties(value)));
    }

    public final void setEmailHasFocus(boolean z) {
        FormUiState value;
        MutableStateFlow<FormUiState> mutableStateFlow = this.state;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, refreshFormProperties(FormUiState.copy$default(value, z, false, false, false, false, false, false, 124, null))));
    }

    public final void setPassword(String newPassword) {
        FormUiState value;
        Intrinsics.checkNotNullParameter(newPassword, "newPassword");
        this.password = newPassword;
        MutableStateFlow<FormUiState> mutableStateFlow = this.state;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, refreshFormProperties(value)));
    }

    public final void setPasswordHasFocus(boolean z) {
        FormUiState value;
        MutableStateFlow<FormUiState> mutableStateFlow = this.state;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, refreshFormProperties(FormUiState.copy$default(value, false, z, false, false, false, false, false, 124, null))));
    }
}
