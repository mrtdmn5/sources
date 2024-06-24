package aws.smithy.kotlin.runtime.retries;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Outcome.kt */
/* loaded from: classes.dex */
public abstract class Outcome<T> {

    /* compiled from: Outcome.kt */
    /* loaded from: classes.dex */
    public static final class Exception extends Outcome {
        public final int attempts;
        public final Throwable exception;

        public Exception(int r1, Throwable th) {
            this.attempts = r1;
            this.exception = th;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Exception)) {
                return false;
            }
            Exception exception = (Exception) obj;
            if (this.attempts == exception.attempts && Intrinsics.areEqual(this.exception, exception.exception)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return this.exception.hashCode() + (Integer.hashCode(this.attempts) * 31);
        }

        public final String toString() {
            return "Exception(attempts=" + this.attempts + ", exception=" + this.exception + ')';
        }
    }

    /* compiled from: Outcome.kt */
    /* loaded from: classes.dex */
    public static final class Response<T> extends Outcome<T> {
        public final int attempts;
        public final T response;

        public Response(int r1, T t) {
            this.attempts = r1;
            this.response = t;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Response)) {
                return false;
            }
            Response response = (Response) obj;
            if (this.attempts == response.attempts && Intrinsics.areEqual(this.response, response.response)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            int hashCode;
            int hashCode2 = Integer.hashCode(this.attempts) * 31;
            T t = this.response;
            if (t == null) {
                hashCode = 0;
            } else {
                hashCode = t.hashCode();
            }
            return hashCode2 + hashCode;
        }

        public final String toString() {
            return "Response(attempts=" + this.attempts + ", response=" + this.response + ')';
        }
    }
}
