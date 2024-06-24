package androidx.compose.runtime;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ValueHolders.kt */
/* loaded from: classes.dex */
public final class StaticValueHolder<T> implements State<T> {
    public final T value;

    public StaticValueHolder(T t) {
        this.value = t;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof StaticValueHolder) && Intrinsics.areEqual(this.value, ((StaticValueHolder) obj).value)) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.runtime.State
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
        return "StaticValueHolder(value=" + this.value + ')';
    }
}
