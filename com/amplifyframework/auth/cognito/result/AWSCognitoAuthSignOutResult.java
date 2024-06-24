package com.amplifyframework.auth.cognito.result;

import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.result.AuthSignOutResult;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AWSCognitoAuthSignOutResult.kt */
/* loaded from: classes.dex */
public abstract class AWSCognitoAuthSignOutResult extends AuthSignOutResult {

    /* compiled from: AWSCognitoAuthSignOutResult.kt */
    /* loaded from: classes.dex */
    public static final class CompleteSignOut extends AWSCognitoAuthSignOutResult {
        public static final CompleteSignOut INSTANCE = new CompleteSignOut();
        private static final boolean signedOutLocally = true;

        private CompleteSignOut() {
            super(null);
        }

        @Override // com.amplifyframework.auth.cognito.result.AWSCognitoAuthSignOutResult
        public boolean getSignedOutLocally() {
            return signedOutLocally;
        }
    }

    /* compiled from: AWSCognitoAuthSignOutResult.kt */
    /* loaded from: classes.dex */
    public static final class FailedSignOut extends AWSCognitoAuthSignOutResult {
        private final AuthException exception;
        private final boolean signedOutLocally;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FailedSignOut(AuthException exception) {
            super(null);
            Intrinsics.checkNotNullParameter(exception, "exception");
            this.exception = exception;
        }

        public static /* synthetic */ FailedSignOut copy$default(FailedSignOut failedSignOut, AuthException authException, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                authException = failedSignOut.exception;
            }
            return failedSignOut.copy(authException);
        }

        public final AuthException component1() {
            return this.exception;
        }

        public final FailedSignOut copy(AuthException exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            return new FailedSignOut(exception);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof FailedSignOut) && Intrinsics.areEqual(this.exception, ((FailedSignOut) obj).exception)) {
                return true;
            }
            return false;
        }

        public final AuthException getException() {
            return this.exception;
        }

        @Override // com.amplifyframework.auth.cognito.result.AWSCognitoAuthSignOutResult
        public boolean getSignedOutLocally() {
            return this.signedOutLocally;
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "FailedSignOut(exception=" + this.exception + ')';
        }
    }

    /* compiled from: AWSCognitoAuthSignOutResult.kt */
    /* loaded from: classes.dex */
    public static final class PartialSignOut extends AWSCognitoAuthSignOutResult {
        private final GlobalSignOutError globalSignOutError;
        private final HostedUIError hostedUIError;
        private final RevokeTokenError revokeTokenError;
        private final boolean signedOutLocally;

        public PartialSignOut() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ PartialSignOut copy$default(PartialSignOut partialSignOut, HostedUIError hostedUIError, GlobalSignOutError globalSignOutError, RevokeTokenError revokeTokenError, int r4, Object obj) {
            if ((r4 & 1) != 0) {
                hostedUIError = partialSignOut.hostedUIError;
            }
            if ((r4 & 2) != 0) {
                globalSignOutError = partialSignOut.globalSignOutError;
            }
            if ((r4 & 4) != 0) {
                revokeTokenError = partialSignOut.revokeTokenError;
            }
            return partialSignOut.copy(hostedUIError, globalSignOutError, revokeTokenError);
        }

        public final HostedUIError component1() {
            return this.hostedUIError;
        }

        public final GlobalSignOutError component2() {
            return this.globalSignOutError;
        }

        public final RevokeTokenError component3() {
            return this.revokeTokenError;
        }

        public final PartialSignOut copy(HostedUIError hostedUIError, GlobalSignOutError globalSignOutError, RevokeTokenError revokeTokenError) {
            return new PartialSignOut(hostedUIError, globalSignOutError, revokeTokenError);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PartialSignOut)) {
                return false;
            }
            PartialSignOut partialSignOut = (PartialSignOut) obj;
            if (Intrinsics.areEqual(this.hostedUIError, partialSignOut.hostedUIError) && Intrinsics.areEqual(this.globalSignOutError, partialSignOut.globalSignOutError) && Intrinsics.areEqual(this.revokeTokenError, partialSignOut.revokeTokenError)) {
                return true;
            }
            return false;
        }

        public final GlobalSignOutError getGlobalSignOutError() {
            return this.globalSignOutError;
        }

        public final HostedUIError getHostedUIError() {
            return this.hostedUIError;
        }

        public final RevokeTokenError getRevokeTokenError() {
            return this.revokeTokenError;
        }

        @Override // com.amplifyframework.auth.cognito.result.AWSCognitoAuthSignOutResult
        public boolean getSignedOutLocally() {
            return this.signedOutLocally;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            HostedUIError hostedUIError = this.hostedUIError;
            int r1 = 0;
            if (hostedUIError == null) {
                hashCode = 0;
            } else {
                hashCode = hostedUIError.hashCode();
            }
            int r0 = hashCode * 31;
            GlobalSignOutError globalSignOutError = this.globalSignOutError;
            if (globalSignOutError == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = globalSignOutError.hashCode();
            }
            int r02 = (r0 + hashCode2) * 31;
            RevokeTokenError revokeTokenError = this.revokeTokenError;
            if (revokeTokenError != null) {
                r1 = revokeTokenError.hashCode();
            }
            return r02 + r1;
        }

        public String toString() {
            return "PartialSignOut(hostedUIError=" + this.hostedUIError + ", globalSignOutError=" + this.globalSignOutError + ", revokeTokenError=" + this.revokeTokenError + ')';
        }

        public /* synthetic */ PartialSignOut(HostedUIError hostedUIError, GlobalSignOutError globalSignOutError, RevokeTokenError revokeTokenError, int r5, DefaultConstructorMarker defaultConstructorMarker) {
            this((r5 & 1) != 0 ? null : hostedUIError, (r5 & 2) != 0 ? null : globalSignOutError, (r5 & 4) != 0 ? null : revokeTokenError);
        }

        public PartialSignOut(HostedUIError hostedUIError, GlobalSignOutError globalSignOutError, RevokeTokenError revokeTokenError) {
            super(null);
            this.hostedUIError = hostedUIError;
            this.globalSignOutError = globalSignOutError;
            this.revokeTokenError = revokeTokenError;
            this.signedOutLocally = true;
        }
    }

    public /* synthetic */ AWSCognitoAuthSignOutResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract boolean getSignedOutLocally();

    private AWSCognitoAuthSignOutResult() {
    }
}
