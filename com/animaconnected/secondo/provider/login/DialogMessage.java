package com.animaconnected.secondo.provider.login;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DialogMessage.kt */
/* loaded from: classes3.dex */
public abstract class DialogMessage {
    public static final int $stable = 0;

    /* compiled from: DialogMessage.kt */
    /* loaded from: classes3.dex */
    public static final class CodeExpired extends DialogMessage {
        public static final int $stable = 0;
        public static final CodeExpired INSTANCE = new CodeExpired();

        private CodeExpired() {
            super(null);
        }
    }

    /* compiled from: DialogMessage.kt */
    /* loaded from: classes3.dex */
    public static final class CodeMismatch extends DialogMessage {
        public static final int $stable = 0;
        public static final CodeMismatch INSTANCE = new CodeMismatch();

        private CodeMismatch() {
            super(null);
        }
    }

    /* compiled from: DialogMessage.kt */
    /* loaded from: classes3.dex */
    public static final class ConfirmResetPassword extends DialogMessage {
        public static final int $stable = 0;
        private final String email;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConfirmResetPassword(String email) {
            super(null);
            Intrinsics.checkNotNullParameter(email, "email");
            this.email = email;
        }

        public static /* synthetic */ ConfirmResetPassword copy$default(ConfirmResetPassword confirmResetPassword, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = confirmResetPassword.email;
            }
            return confirmResetPassword.copy(str);
        }

        public final String component1() {
            return this.email;
        }

        public final ConfirmResetPassword copy(String email) {
            Intrinsics.checkNotNullParameter(email, "email");
            return new ConfirmResetPassword(email);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof ConfirmResetPassword) && Intrinsics.areEqual(this.email, ((ConfirmResetPassword) obj).email)) {
                return true;
            }
            return false;
        }

        public final String getEmail() {
            return this.email;
        }

        public int hashCode() {
            return this.email.hashCode();
        }

        public String toString() {
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("ConfirmResetPassword(email="), this.email, ')');
        }
    }

    /* compiled from: DialogMessage.kt */
    /* loaded from: classes3.dex */
    public static final class ConfirmationCodeSent extends DialogMessage {
        public static final int $stable = 0;
        private final String toEmail;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConfirmationCodeSent(String toEmail) {
            super(null);
            Intrinsics.checkNotNullParameter(toEmail, "toEmail");
            this.toEmail = toEmail;
        }

        public static /* synthetic */ ConfirmationCodeSent copy$default(ConfirmationCodeSent confirmationCodeSent, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = confirmationCodeSent.toEmail;
            }
            return confirmationCodeSent.copy(str);
        }

        public final String component1() {
            return this.toEmail;
        }

        public final ConfirmationCodeSent copy(String toEmail) {
            Intrinsics.checkNotNullParameter(toEmail, "toEmail");
            return new ConfirmationCodeSent(toEmail);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof ConfirmationCodeSent) && Intrinsics.areEqual(this.toEmail, ((ConfirmationCodeSent) obj).toEmail)) {
                return true;
            }
            return false;
        }

        public final String getToEmail() {
            return this.toEmail;
        }

        public int hashCode() {
            return this.toEmail.hashCode();
        }

        public String toString() {
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("ConfirmationCodeSent(toEmail="), this.toEmail, ')');
        }
    }

    /* compiled from: DialogMessage.kt */
    /* loaded from: classes3.dex */
    public static final class FailedToSendConfirmationCode extends DialogMessage {
        public static final int $stable = 0;
        private final String toEmail;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FailedToSendConfirmationCode(String toEmail) {
            super(null);
            Intrinsics.checkNotNullParameter(toEmail, "toEmail");
            this.toEmail = toEmail;
        }

        public static /* synthetic */ FailedToSendConfirmationCode copy$default(FailedToSendConfirmationCode failedToSendConfirmationCode, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = failedToSendConfirmationCode.toEmail;
            }
            return failedToSendConfirmationCode.copy(str);
        }

        public final String component1() {
            return this.toEmail;
        }

        public final FailedToSendConfirmationCode copy(String toEmail) {
            Intrinsics.checkNotNullParameter(toEmail, "toEmail");
            return new FailedToSendConfirmationCode(toEmail);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof FailedToSendConfirmationCode) && Intrinsics.areEqual(this.toEmail, ((FailedToSendConfirmationCode) obj).toEmail)) {
                return true;
            }
            return false;
        }

        public final String getToEmail() {
            return this.toEmail;
        }

        public int hashCode() {
            return this.toEmail.hashCode();
        }

        public String toString() {
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("FailedToSendConfirmationCode(toEmail="), this.toEmail, ')');
        }
    }

    /* compiled from: DialogMessage.kt */
    /* loaded from: classes3.dex */
    public static final class Generic extends DialogMessage {
        public static final int $stable = 0;
        public static final Generic INSTANCE = new Generic();

        private Generic() {
            super(null);
        }
    }

    /* compiled from: DialogMessage.kt */
    /* loaded from: classes3.dex */
    public static final class InvalidUsernamePassword extends DialogMessage {
        public static final int $stable = 0;
        public static final InvalidUsernamePassword INSTANCE = new InvalidUsernamePassword();

        private InvalidUsernamePassword() {
            super(null);
        }
    }

    /* compiled from: DialogMessage.kt */
    /* loaded from: classes3.dex */
    public static final class NoInternetConnection extends DialogMessage {
        public static final int $stable = 0;
        public static final NoInternetConnection INSTANCE = new NoInternetConnection();

        private NoInternetConnection() {
            super(null);
        }
    }

    /* compiled from: DialogMessage.kt */
    /* loaded from: classes3.dex */
    public static final class ResetPasswordEmailEmpty extends DialogMessage {
        public static final int $stable = 0;
        public static final ResetPasswordEmailEmpty INSTANCE = new ResetPasswordEmailEmpty();

        private ResetPasswordEmailEmpty() {
            super(null);
        }
    }

    /* compiled from: DialogMessage.kt */
    /* loaded from: classes3.dex */
    public static final class ResetPasswordSuccess extends DialogMessage {
        public static final int $stable = 0;
        public static final ResetPasswordSuccess INSTANCE = new ResetPasswordSuccess();

        private ResetPasswordSuccess() {
            super(null);
        }
    }

    /* compiled from: DialogMessage.kt */
    /* loaded from: classes3.dex */
    public static final class UsernameExistsException extends DialogMessage {
        public static final int $stable = 0;
        public static final UsernameExistsException INSTANCE = new UsernameExistsException();

        private UsernameExistsException() {
            super(null);
        }
    }

    public /* synthetic */ DialogMessage(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private DialogMessage() {
    }
}
