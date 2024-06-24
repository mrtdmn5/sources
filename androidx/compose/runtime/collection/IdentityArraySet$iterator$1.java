package androidx.compose.runtime.collection;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: IdentityArraySet.kt */
/* loaded from: classes.dex */
public final class IdentityArraySet$iterator$1<T> implements Iterator<T>, KMappedMarker {
    public int index;
    public final /* synthetic */ IdentityArraySet<T> this$0;

    public IdentityArraySet$iterator$1(IdentityArraySet<T> identityArraySet) {
        this.this$0 = identityArraySet;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.index < this.this$0.size) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final T next() {
        Object[] objArr = this.this$0.values;
        int r1 = this.index;
        this.index = r1 + 1;
        T t = (T) objArr[r1];
        Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
        return t;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
