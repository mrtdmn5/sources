package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyJVM.kt */
/* loaded from: classes.dex */
public final class SafePublicationLazyImpl<T> implements Lazy<T>, Serializable {
    public static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> valueUpdater = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "_value");
    public volatile Object _value;
    public volatile Function0<? extends T> initializer;

    public SafePublicationLazyImpl(Function0<? extends T> initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        this.initializer = initializer;
        this._value = UNINITIALIZED_VALUE.INSTANCE;
    }

    @Override // kotlin.Lazy
    public final T getValue() {
        boolean z;
        T t = (T) this._value;
        UNINITIALIZED_VALUE r1 = UNINITIALIZED_VALUE.INSTANCE;
        if (t != r1) {
            return t;
        }
        Function0<? extends T> function0 = this.initializer;
        if (function0 != null) {
            T invoke = function0.invoke();
            AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> atomicReferenceFieldUpdater = valueUpdater;
            while (true) {
                if (atomicReferenceFieldUpdater.compareAndSet(this, r1, invoke)) {
                    z = true;
                    break;
                }
                if (atomicReferenceFieldUpdater.get(this) != r1) {
                    z = false;
                    break;
                }
            }
            if (z) {
                this.initializer = null;
                return invoke;
            }
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
