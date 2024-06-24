package com.animaconnected.watch.account.fitness;

import com.amplifyframework.statemachine.codegen.data.GlobalSignOutErrorData$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FitnessCloudSyncApi.kt */
/* loaded from: classes3.dex */
public abstract class FitnessApiResult<T> {

    /* compiled from: FitnessCloudSyncApi.kt */
    /* loaded from: classes3.dex */
    public static final class Failure<T> extends FitnessApiResult<T> {
        private final Exception exception;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(Exception exception) {
            super(null);
            Intrinsics.checkNotNullParameter(exception, "exception");
            this.exception = exception;
        }

        public static /* synthetic */ Failure copy$default(Failure failure, Exception exc, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                exc = failure.exception;
            }
            return failure.copy(exc);
        }

        public final Exception component1() {
            return this.exception;
        }

        public final Failure<T> copy(Exception exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            return new Failure<>(exception);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Failure) && Intrinsics.areEqual(this.exception, ((Failure) obj).exception)) {
                return true;
            }
            return false;
        }

        public final Exception getException() {
            return this.exception;
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return GlobalSignOutErrorData$$ExternalSyntheticOutline0.m(new StringBuilder("Failure(exception="), this.exception, ')');
        }
    }

    /* compiled from: FitnessCloudSyncApi.kt */
    /* loaded from: classes3.dex */
    public static final class Success<T> extends FitnessApiResult<T> {
        private final T result;

        public Success(T t) {
            super(null);
            this.result = t;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success success, Object obj, int r2, Object obj2) {
            if ((r2 & 1) != 0) {
                obj = success.result;
            }
            return success.copy(obj);
        }

        public final T component1() {
            return this.result;
        }

        public final Success<T> copy(T t) {
            return new Success<>(t);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Success) && Intrinsics.areEqual(this.result, ((Success) obj).result)) {
                return true;
            }
            return false;
        }

        public final T getResult() {
            return this.result;
        }

        public int hashCode() {
            T t = this.result;
            if (t == null) {
                return 0;
            }
            return t.hashCode();
        }

        public String toString() {
            return "Success(result=" + this.result + ')';
        }
    }

    public /* synthetic */ FitnessApiResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private FitnessApiResult() {
    }
}
