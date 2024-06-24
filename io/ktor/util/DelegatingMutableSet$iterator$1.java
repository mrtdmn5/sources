package io.ktor.util;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [To] */
/* compiled from: DelegatingMutableSet.kt */
/* loaded from: classes3.dex */
public final class DelegatingMutableSet$iterator$1<To> implements Iterator<To>, KMappedMarker {
    public final Iterator<From> delegateIterator;
    public final /* synthetic */ DelegatingMutableSet<From, To> this$0;

    public DelegatingMutableSet$iterator$1(DelegatingMutableSet<From, To> delegatingMutableSet) {
        this.this$0 = delegatingMutableSet;
        this.delegateIterator = delegatingMutableSet.delegate.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.delegateIterator.hasNext();
    }

    @Override // java.util.Iterator
    public final To next() {
        return this.this$0.convertTo.invoke(this.delegateIterator.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.delegateIterator.remove();
    }
}
