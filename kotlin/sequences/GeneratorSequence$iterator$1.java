package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Sequences.kt */
/* loaded from: classes.dex */
public final class GeneratorSequence$iterator$1<T> implements Iterator<T>, KMappedMarker {
    public T nextItem;
    public int nextState = -2;
    public final /* synthetic */ GeneratorSequence<T> this$0;

    public GeneratorSequence$iterator$1(GeneratorSequence<T> generatorSequence) {
        this.this$0 = generatorSequence;
    }

    public final void calcNext() {
        T invoke;
        int r0;
        int r02 = this.nextState;
        GeneratorSequence<T> generatorSequence = this.this$0;
        if (r02 == -2) {
            invoke = generatorSequence.getInitialValue.invoke();
        } else {
            Function1<T, T> function1 = generatorSequence.getNextValue;
            T t = this.nextItem;
            Intrinsics.checkNotNull(t);
            invoke = function1.invoke(t);
        }
        this.nextItem = invoke;
        if (invoke == null) {
            r0 = 0;
        } else {
            r0 = 1;
        }
        this.nextState = r0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.nextState < 0) {
            calcNext();
        }
        if (this.nextState == 1) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (this.nextState < 0) {
            calcNext();
        }
        if (this.nextState != 0) {
            T t = this.nextItem;
            Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.nextState = -1;
            return t;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
