package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyJVM.kt */
/* loaded from: classes.dex */
public final class SynchronizedLazyImpl<T> implements Lazy<T>, Serializable {
    public volatile Object _value;
    public Function0<? extends T> initializer;
    public final Object lock;

    public SynchronizedLazyImpl(Function0 initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        this.initializer = initializer;
        this._value = UNINITIALIZED_VALUE.INSTANCE;
        this.lock = this;
    }

    @Override // kotlin.Lazy
    public final T getValue() {
        T t;
        T t2 = (T) this._value;
        UNINITIALIZED_VALUE r1 = UNINITIALIZED_VALUE.INSTANCE;
        if (t2 != r1) {
            return t2;
        }
        synchronized (this.lock) {
            t = (T) this._value;
            if (t == r1) {
                Function0<? extends T> function0 = this.initializer;
                Intrinsics.checkNotNull(function0);
                t = function0.invoke();
                this._value = t;
                this.initializer = null;
            }
        }
        return t;
    }

    @Override // kotlin.Lazy
    public final boolean isInitialized() {
        if (this._value != UNINITIALIZED_VALUE.INSTANCE) {
            return true;
        }
        return false;
    }

    public final String toString() {
        if (isInitialized()) {
            return String.valueOf(getValue());
        }
        return "Lazy value not initialized yet.";
    }
}
