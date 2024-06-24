package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: SequenceBuilder.kt */
/* loaded from: classes.dex */
public final class SequenceBuilderIterator<T> extends SequenceScope<T> implements Iterator<T>, Continuation<Unit>, KMappedMarker {
    public Iterator<? extends T> nextIterator;
    public Continuation<? super Unit> nextStep;
    public T nextValue;
    public int state;

    public final RuntimeException exceptionalState() {
        int r0 = this.state;
        if (r0 != 4) {
            if (r0 != 5) {
                return new IllegalStateException("Unexpected state of the iterator: " + this.state);
            }
            return new IllegalStateException("Iterator has failed.");
        }
        return new NoSuchElementException();
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (true) {
            int r0 = this.state;
            if (r0 != 0) {
                if (r0 != 1) {
                    if (r0 == 2 || r0 == 3) {
                        return true;
                    }
                    if (r0 == 4) {
                        return false;
                    }
                    throw exceptionalState();
                }
                Iterator<? extends T> it = this.nextIterator;
                Intrinsics.checkNotNull(it);
                if (it.hasNext()) {
                    this.state = 2;
                    return true;
                }
                this.nextIterator = null;
            }
            this.state = 5;
            Continuation<? super Unit> continuation = this.nextStep;
            Intrinsics.checkNotNull(continuation);
            this.nextStep = null;
            continuation.resumeWith(Unit.INSTANCE);
        }
    }

    @Override // java.util.Iterator
    public final T next() {
        int r0 = this.state;
        if (r0 != 0 && r0 != 1) {
            if (r0 != 2) {
                if (r0 == 3) {
                    this.state = 0;
                    T t = this.nextValue;
                    this.nextValue = null;
                    return t;
                }
                throw exceptionalState();
            }
            this.state = 1;
            Iterator<? extends T> it = this.nextIterator;
            Intrinsics.checkNotNull(it);
            return it.next();
        }
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        ResultKt.throwOnFailure(obj);
        this.state = 4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.sequences.SequenceScope
    public final CoroutineSingletons yield(Object obj, Continuation frame) {
        this.nextValue = obj;
        this.state = 3;
        this.nextStep = frame;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Intrinsics.checkNotNullParameter(frame, "frame");
        return coroutineSingletons;
    }

    @Override // kotlin.sequences.SequenceScope
    public final Object yieldAll(Iterator<? extends T> it, Continuation<? super Unit> frame) {
        if (!it.hasNext()) {
            return Unit.INSTANCE;
        }
        this.nextIterator = it;
        this.state = 2;
        this.nextStep = frame;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        Intrinsics.checkNotNullParameter(frame, "frame");
        return coroutineSingletons;
    }
}
