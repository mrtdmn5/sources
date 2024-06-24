package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.collections.IntIterator;

/* compiled from: ProgressionIterators.kt */
/* loaded from: classes.dex */
public final class IntProgressionIterator extends IntIterator {
    public final int finalElement;
    public boolean hasNext;
    public int next;
    public final int step;

    public IntProgressionIterator(int r3, int r4, int r5) {
        this.step = r5;
        this.finalElement = r4;
        boolean z = true;
        if (r5 <= 0 ? r3 < r4 : r3 > r4) {
            z = false;
        }
        this.hasNext = z;
        this.next = z ? r3 : r4;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.IntIterator
    public final int nextInt() {
        int r0 = this.next;
        if (r0 == this.finalElement) {
            if (this.hasNext) {
                this.hasNext = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.next = this.step + r0;
        }
        return r0;
    }
}
