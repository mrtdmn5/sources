package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: AbstractIterator.kt */
/* loaded from: classes.dex */
public abstract class AbstractIterator<T> implements Iterator<T>, KMappedMarker {
    public T nextValue;
    public State state = State.NotReady;

    /* compiled from: AbstractIterator.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[State.values().length];
            try {
                r0[State.Done.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[State.Ready.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        boolean z;
        State state = this.state;
        State state2 = State.Failed;
        if (state != state2) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int r0 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (r0 == 1) {
                return false;
            }
            if (r0 != 2) {
                this.state = state2;
                RingBuffer$iterator$1 ringBuffer$iterator$1 = (RingBuffer$iterator$1) this;
                int r1 = ringBuffer$iterator$1.count;
                if (r1 == 0) {
                    ringBuffer$iterator$1.state = State.Done;
                } else {
                    RingBuffer<T> ringBuffer = ringBuffer$iterator$1.this$0;
                    Object[] objArr = ringBuffer.buffer;
                    int r6 = ringBuffer$iterator$1.index;
                    ringBuffer$iterator$1.nextValue = (T) objArr[r6];
                    ringBuffer$iterator$1.state = State.Ready;
                    ringBuffer$iterator$1.index = (r6 + 1) % ringBuffer.capacity;
                    ringBuffer$iterator$1.count = r1 - 1;
                }
                if (this.state != State.Ready) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            this.state = State.NotReady;
            return this.nextValue;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
