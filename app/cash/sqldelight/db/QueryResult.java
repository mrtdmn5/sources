package app.cash.sqldelight.db;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: QueryResult.kt */
/* loaded from: classes.dex */
public interface QueryResult<T> {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: QueryResult.kt */
    /* loaded from: classes.dex */
    public static final class AsyncValue<T> implements QueryResult<T> {
        public final Function1<Continuation<? super T>, Object> getter;

        @Override // app.cash.sqldelight.db.QueryResult
        public final Object await(Continuation<? super T> continuation) {
            return this.getter.invoke(continuation);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof AsyncValue)) {
                return false;
            }
            if (!Intrinsics.areEqual(this.getter, ((AsyncValue) obj).getter)) {
                return false;
            }
            return true;
        }

        @Override // app.cash.sqldelight.db.QueryResult
        public final T getValue() {
            throw new IllegalStateException("The driver used with SQLDelight is asynchronous, so SQLDelight should be configured for\nasynchronous usage:\n\nsqldelight {\n  databases {\n    MyDatabase {\n      generateAsync = true\n    }\n  }\n}");
        }

        public final int hashCode() {
            return this.getter.hashCode();
        }

        public final String toString() {
            return "AsyncValue(getter=" + this.getter + ')';
        }
    }

    /* compiled from: QueryResult.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final Unit Unit = Unit.INSTANCE;
    }

    /* compiled from: QueryResult.kt */
    /* loaded from: classes.dex */
    public static final class Value<T> implements QueryResult<T> {
        public final T value;

        @Override // app.cash.sqldelight.db.QueryResult
        public final Object await(Continuation<? super T> continuation) {
            return this.value;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Value)) {
                return false;
            }
            if (!Intrinsics.areEqual(this.value, ((Value) obj).value)) {
                return false;
            }
            return true;
        }

        @Override // app.cash.sqldelight.db.QueryResult
        public final T getValue() {
            return this.value;
        }

        public final int hashCode() {
            T t = this.value;
            if (t == null) {
                return 0;
            }
            return t.hashCode();
        }

        public final String toString() {
            return "Value(value=" + this.value + ')';
        }
    }

    Object await(Continuation<? super T> continuation);

    T getValue();
}
