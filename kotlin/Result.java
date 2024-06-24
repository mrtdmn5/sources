package kotlin;

import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Result.kt */
/* loaded from: classes.dex */
public final class Result<T> implements Serializable {
    public final Object value;

    /* compiled from: Result.kt */
    /* loaded from: classes.dex */
    public static final class Failure implements Serializable {
        public final Throwable exception;

        public Failure(Throwable exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            this.exception = exception;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof Failure) {
                if (Intrinsics.areEqual(this.exception, ((Failure) obj).exception)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return this.exception.hashCode();
        }

        public final String toString() {
            return "Failure(" + this.exception + ')';
        }
    }

    /* renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m1661exceptionOrNullimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1662toStringimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Result)) {
            return false;
        }
        if (!Intrinsics.areEqual(this.value, ((Result) obj).value)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        Object obj = this.value;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        return m1662toStringimpl(this.value);
    }
}
