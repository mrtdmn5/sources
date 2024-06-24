package kotlin.collections;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: IndexedValue.kt */
/* loaded from: classes.dex */
public final class IndexedValue<T> {
    public final int index;
    public final T value;

    public IndexedValue(int r1, T t) {
        this.index = r1;
        this.value = t;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IndexedValue)) {
            return false;
        }
        IndexedValue indexedValue = (IndexedValue) obj;
        if (this.index == indexedValue.index && Intrinsics.areEqual(this.value, indexedValue.value)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = Integer.hashCode(this.index) * 31;
        T t = this.value;
        if (t == null) {
            hashCode = 0;
        } else {
            hashCode = t.hashCode();
        }
        return hashCode2 + hashCode;
    }

    public final String toString() {
        return "IndexedValue(index=" + this.index + ", value=" + this.value + ')';
    }
}
