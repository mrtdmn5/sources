package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;

/* compiled from: Sequences.kt */
/* loaded from: classes.dex */
public final class TakeWhileSequence<T> implements Sequence<T> {
    public final Function1<T, Boolean> predicate;
    public final Sequence<T> sequence;

    /* JADX WARN: Multi-variable type inference failed */
    public TakeWhileSequence(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        this.sequence = sequence;
        this.predicate = function1;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator<T> iterator() {
        return new TakeWhileSequence$iterator$1(this);
    }
}
