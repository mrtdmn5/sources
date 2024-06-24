package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.collections.CharIterator;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProgressionIterators.kt */
/* loaded from: classes.dex */
public final class CharProgressionIterator extends CharIterator {
    public final int finalElement;
    public boolean hasNext;
    public int next;
    public final int step;

    public CharProgressionIterator(char c, char c2, int r5) {
        this.step = r5;
        this.finalElement = c2;
        boolean z = true;
        if (r5 <= 0 ? Intrinsics.compare(c, c2) < 0 : Intrinsics.compare(c, c2) > 0) {
            z = false;
        }
        this.hasNext = z;
        this.next = z ? c : c2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.hasNext;
    }

    @Override // kotlin.collections.CharIterator
    public final char nextChar() {
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
        return (char) r0;
    }
}
