package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Sequences.kt */
/* loaded from: classes.dex */
public final class DropSequence<T> implements Sequence<T>, DropTakeSequence<T> {
    public final int count;
    public final Sequence<T> sequence;

    /* JADX WARN: Multi-variable type inference failed */
    public DropSequence(Sequence<? extends T> sequence, int r3) {
        boolean z;
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.sequence = sequence;
        this.count = r3;
        if (r3 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + r3 + '.').toString());
    }

    @Override // kotlin.sequences.DropTakeSequence
    public final Sequence<T> drop(int r3) {
        int r0 = this.count + r3;
        if (r0 < 0) {
            return new DropSequence(this, r3);
        }
        return new DropSequence(this.sequence, r0);
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator<T> iterator() {
        return new DropSequence$iterator$1(this);
    }
}
