package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Lazy.kt */
/* loaded from: classes.dex */
public final class UnsafeLazyImpl<T> implements Lazy<T>, Serializable {
    public Object _value;
    public Function0<? extends T> initializer;

    public UnsafeLazyImpl(Function0<? extends T> initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        this.initializer = initializer;
        this._value = UNINITIALIZED_VALUE.INSTANCE;
    }

    @Override // kotlin.Lazy
    public final T getValue() {
        if (this._value == UNINITIALIZED_VALUE.INSTANCE) {
            Function0<? extends T> function0 = this.initializer;
            Intrinsics.checkNotNull(function0);
            this._value = function0.invoke();
            this.initializer = null;
        }
        return (T) this._value;
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
