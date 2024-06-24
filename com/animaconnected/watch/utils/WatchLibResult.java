package com.animaconnected.watch.utils;

import java.lang.Throwable;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchLibResult.kt */
/* loaded from: classes3.dex */
public abstract class WatchLibResult<S, F extends Throwable> {

    /* compiled from: WatchLibResult.kt */
    /* loaded from: classes3.dex */
    public static final class Failure<S, F extends Throwable> extends WatchLibResult<S, F> {
        private final F failure;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(F failure) {
            super(null);
            Intrinsics.checkNotNullParameter(failure, "failure");
            this.failure = failure;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Failure copy$default(Failure failure, Throwable th, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                th = failure.failure;
            }
            return failure.copy(th);
        }

        public final F component1() {
            return this.failure;
        }

        public final Failure<S, F> copy(F failure) {
            Intrinsics.checkNotNullParameter(failure, "failure");
            return new Failure<>(failure);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Failure) && Intrinsics.areEqual(this.failure, ((Failure) obj).failure)) {
                return true;
            }
            return false;
        }

        public final F getFailure() {
            return this.failure;
        }

        public int hashCode() {
            return this.failure.hashCode();
        }

        public String toString() {
            return "Failure(failure=" + this.failure + ')';
        }
    }

    /* compiled from: WatchLibResult.kt */
    /* loaded from: classes3.dex */
    public static final class Success<S, F extends Throwable> extends WatchLibResult<S, F> {
        private final S success;

        public Success(S s) {
            super(null);
            this.success = s;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success success, Object obj, int r2, Object obj2) {
            if ((r2 & 1) != 0) {
                obj = success.success;
            }
            return success.copy(obj);
        }

        public final S component1() {
            return this.success;
        }

        public final Success<S, F> copy(S s) {
            return new Success<>(s);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Success) && Intrinsics.areEqual(this.success, ((Success) obj).success)) {
                return true;
            }
            return false;
        }

        public final S getSuccess() {
            return this.success;
        }

        public int hashCode() {
            S s = this.success;
            if (s == null) {
                return 0;
            }
            return s.hashCode();
        }

        public String toString() {
            return "Success(success=" + this.success + ')';
        }
    }

    public /* synthetic */ WatchLibResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final <T> T fold(Function1<? super S, ? extends T> succeeded, Function1<? super F, ? extends T> failed) {
        Intrinsics.checkNotNullParameter(succeeded, "succeeded");
        Intrinsics.checkNotNullParameter(failed, "failed");
        if (this instanceof Success) {
            return succeeded.invoke((Object) ((Success) this).getSuccess());
        }
        if (this instanceof Failure) {
            return failed.invoke(((Failure) this).getFailure());
        }
        throw new NoWhenBranchMatchedException();
    }

    public final S getOrNull() {
        if (this instanceof Success) {
            return (S) ((Success) this).getSuccess();
        }
        if (this instanceof Failure) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void onSuccess(Function0<Unit> succeeded) {
        Intrinsics.checkNotNullParameter(succeeded, "succeeded");
        if (this instanceof Success) {
            succeeded.invoke();
        } else if (this instanceof Failure) {
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private WatchLibResult() {
    }
}
