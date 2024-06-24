package aws.smithy.kotlin.runtime.retries.policy;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: RetryDirective.kt */
/* loaded from: classes.dex */
public abstract class RetryDirective {

    /* compiled from: RetryDirective.kt */
    /* loaded from: classes.dex */
    public static final class RetryError extends RetryDirective {
        public final RetryErrorType reason;

        public RetryError(RetryErrorType reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof RetryError) && this.reason == ((RetryError) obj).reason) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return this.reason.hashCode();
        }

        public final String toString() {
            return "RetryError(reason=" + this.reason + ')';
        }
    }

    /* compiled from: RetryDirective.kt */
    /* loaded from: classes.dex */
    public static final class TerminateAndFail extends RetryDirective {
        public static final TerminateAndFail INSTANCE = new TerminateAndFail();
    }

    /* compiled from: RetryDirective.kt */
    /* loaded from: classes.dex */
    public static final class TerminateAndSucceed extends RetryDirective {
        public static final TerminateAndSucceed INSTANCE = new TerminateAndSucceed();
    }
}
