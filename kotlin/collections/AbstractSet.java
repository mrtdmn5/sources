package kotlin.collections;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AbstractSet.kt */
/* loaded from: classes.dex */
public abstract class AbstractSet<E> extends AbstractCollection<E> implements Set<E> {
    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set other = (Set) obj;
        Intrinsics.checkNotNullParameter(other, "other");
        if (size() != other.size()) {
            return false;
        }
        return containsAll(other);
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        int r3;
        int r2 = 0;
        for (E e : this) {
            if (e != null) {
                r3 = e.hashCode();
            } else {
                r3 = 0;
            }
            r2 += r3;
        }
        return r2;
    }
}
