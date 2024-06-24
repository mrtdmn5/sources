package io.reactivex.internal.functions;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class Functions {
    public static final Identity IDENTITY = new Identity();
    public static final EmptyRunnable EMPTY_RUNNABLE = new EmptyRunnable();
    public static final EmptyAction EMPTY_ACTION = new EmptyAction();
    public static final EmptyConsumer EMPTY_CONSUMER = new EmptyConsumer();
    public static final TruePredicate ALWAYS_TRUE = new TruePredicate();

    /* loaded from: classes.dex */
    public static final class ActionConsumer<T> implements Consumer<T> {
        public final Action action;

        public ActionConsumer(Action action) {
            this.action = action;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(T t) throws Exception {
            this.action.run();
        }
    }

    /* loaded from: classes.dex */
    public static final class CastToClass<T, U> implements Function<T, U> {
        public final Class<U> clazz = byte[].class;

        @Override // io.reactivex.functions.Function
        public final U apply(T t) throws Exception {
            return this.clazz.cast(t);
        }
    }

    /* loaded from: classes.dex */
    public static final class JustValue<T, U> implements Callable<U>, Function<T, U> {
        public final U value;

        public JustValue(U u) {
            this.value = u;
        }

        @Override // io.reactivex.functions.Function
        public final U apply(T t) throws Exception {
            return this.value;
        }

        @Override // java.util.concurrent.Callable
        public final U call() throws Exception {
            return this.value;
        }
    }

    /* loaded from: classes.dex */
    public static final class TruePredicate implements Predicate<Object> {
        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object obj) {
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static final class EmptyAction implements Action {
        public final String toString() {
            return "EmptyAction";
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
        }
    }

    /* loaded from: classes.dex */
    public static final class EmptyRunnable implements Runnable {
        public final String toString() {
            return "EmptyRunnable";
        }

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    /* loaded from: classes.dex */
    public static final class EmptyConsumer implements Consumer<Object> {
        public final String toString() {
            return "EmptyConsumer";
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object obj) {
        }
    }

    /* loaded from: classes.dex */
    public static final class Identity implements Function<Object, Object> {
        public final String toString() {
            return "IdentityFunction";
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object obj) {
            return obj;
        }
    }
}
