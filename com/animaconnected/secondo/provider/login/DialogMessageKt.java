package com.animaconnected.secondo.provider.login;

import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.googlefit.GoogleFitDataSetsKt$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.provider.login.DialogMessage;
import com.kronaby.watch.app.R;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DialogMessage.kt */
/* loaded from: classes3.dex */
public final class DialogMessageKt {
    private static final DialogInfo codeExpired() {
        KronabyApplication.Companion companion = KronabyApplication.Companion;
        return new DialogInfo(GoogleFitDataSetsKt$$ExternalSyntheticOutline0.m(companion, R.string.account_error_code_expired_title, "getString(...)"), GoogleFitDataSetsKt$$ExternalSyntheticOutline0.m(companion, R.string.account_error_code_expired_message, "getString(...)"), null, 4, null);
    }

    private static final DialogInfo codeMismatch() {
        KronabyApplication.Companion companion = KronabyApplication.Companion;
        return new DialogInfo(GoogleFitDataSetsKt$$ExternalSyntheticOutline0.m(companion, R.string.account_error_invalid_code_title, "getString(...)"), GoogleFitDataSetsKt$$ExternalSyntheticOutline0.m(companion, R.string.error_generic_resolution_retry, "getString(...)"), null, 4, null);
    }

    private static final DialogInfo confirmResetPassword(String str) {
        KronabyApplication.Companion companion = KronabyApplication.Companion;
        String m = GoogleFitDataSetsKt$$ExternalSyntheticOutline0.m(companion, R.string.account_check_your_email, "getString(...)");
        String string = companion.getContext().getString(R.string.account_reset_code_successfully_sent, str);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return new DialogInfo(m, string, null, 4, null);
    }

    private static final DialogInfo confirmationCodeSent(String str) {
        KronabyApplication.Companion companion = KronabyApplication.Companion;
        String m = GoogleFitDataSetsKt$$ExternalSyntheticOutline0.m(companion, R.string.account_check_your_email, "getString(...)");
        String string = companion.getContext().getString(R.string.account_verification_code_successfully_sent, str);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return new DialogInfo(m, string, null, 4, null);
    }

    private static final DialogInfo connectToInternet() {
        KronabyApplication.Companion companion = KronabyApplication.Companion;
        return new DialogInfo(GoogleFitDataSetsKt$$ExternalSyntheticOutline0.m(companion, R.string.onboarding_internet_access_enable_title, "getString(...)"), GoogleFitDataSetsKt$$ExternalSyntheticOutline0.m(companion, R.string.body_connect_to_internet, "getString(...)"), null, 4, null);
    }

    private static final DialogInfo failedToSendConfirmationCode(String str) {
        KronabyApplication.Companion companion = KronabyApplication.Companion;
        return new DialogInfo(GoogleFitDataSetsKt$$ExternalSyntheticOutline0.m(companion, R.string.error_generic_title, "getString(...)"), GoogleFitDataSetsKt$$ExternalSyntheticOutline0.m(companion, R.string.error_generic_description_and_resolution_retry, "getString(...)"), null, 4, null);
    }

    private static final DialogInfo generic() {
        KronabyApplication.Companion companion = KronabyApplication.Companion;
        return new DialogInfo(GoogleFitDataSetsKt$$ExternalSyntheticOutline0.m(companion, R.string.error_generic_title, "getString(...)"), GoogleFitDataSetsKt$$ExternalSyntheticOutline0.m(companion, R.string.error_generic_description_and_resolution_retry, "getString(...)"), null, 4, null);
    }

    public static final DialogInfo getDialogInfo(DialogMessage message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (message instanceof DialogMessage.ConfirmationCodeSent) {
            return confirmationCodeSent(((DialogMessage.ConfirmationCodeSent) message).getToEmail());
        }
        if (message instanceof DialogMessage.FailedToSendConfirmationCode) {
            return failedToSendConfirmationCode(((DialogMessage.FailedToSendConfirmationCode) message).getToEmail());
        }
        if (message instanceof DialogMessage.Generic) {
            return generic();
        }
        if (message instanceof DialogMessage.InvalidUsernamePassword) {
            return invalidUsernamePassword();
        }
        if (message instanceof DialogMessage.CodeMismatch) {
            return codeMismatch();
        }
        if (message instanceof DialogMessage.CodeExpired) {
            return codeExpired();
        }
        if (message instanceof DialogMessage.ResetPasswordEmailEmpty) {
            return resetPasswordEmailEmpty();
        }
        if (message instanceof DialogMessage.ConfirmResetPassword) {
            return confirmResetPassword(((DialogMessage.ConfirmResetPassword) message).getEmail());
        }
        if (message instanceof DialogMessage.NoInternetConnection) {
            return connectToInternet();
        }
        if (message instanceof DialogMessage.ResetPasswordSuccess) {
            return resetPasswordSuccess();
        }
        if (message instanceof DialogMessage.UsernameExistsException) {
            return usernameExists();
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final DialogInfo invalidUsernamePassword() {
        KronabyApplication.Companion companion = KronabyApplication.Companion;
        return new DialogInfo(GoogleFitDataSetsKt$$ExternalSyntheticOutline0.m(companion, R.string.account_error_failed_to_login_title, "getString(...)"), GoogleFitDataSetsKt$$ExternalSyntheticOutline0.m(companion, R.string.account_error_incorrect_password_body, "getString(...)"), null, 4, null);
    }

    private static final DialogInfo resetPasswordEmailEmpty() {
        return new DialogInfo("Reset password", "Email can not be empty", null, 4, null);
    }

    private static final DialogInfo resetPasswordSuccess() {
        KronabyApplication.Companion companion = KronabyApplication.Companion;
        return new DialogInfo(GoogleFitDataSetsKt$$ExternalSyntheticOutline0.m(companion, R.string.account_reset_password_success_title, "getString(...)"), GoogleFitDataSetsKt$$ExternalSyntheticOutline0.m(companion, R.string.account_reset_password_success_body, "getString(...)"), null, 4, null);
    }

    private static final DialogInfo usernameExists() {
        KronabyApplication.Companion companion = KronabyApplication.Companion;
        return new DialogInfo(GoogleFitDataSetsKt$$ExternalSyntheticOutline0.m(companion, R.string.account_error_email_in_use_title, "getString(...)"), GoogleFitDataSetsKt$$ExternalSyntheticOutline0.m(companion, R.string.account_error_email_in_use_body, "getString(...)"), null, 4, null);
    }
}
