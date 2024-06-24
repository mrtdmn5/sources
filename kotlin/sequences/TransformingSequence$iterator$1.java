package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: Sequences.kt */
/* loaded from: classes.dex */
public final class TransformingSequence$iterator$1<R> implements Iterator<R>, KMappedMarker {
    public final Iterator<T> iterator;
    public final /* synthetic */ TransformingSequence<T, R> this$0;

    public TransformingSequence$iterator$1(TransformingSequence<T, R> transformingSequence) {
        this.this$0 = transformingSequence;
        this.iterator = transformingSequence.sequence.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public final R next() {
        return this.this$0.transformer.invoke(this.iterator.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
