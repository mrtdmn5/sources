package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;

/* compiled from: Sequences.kt */
/* loaded from: classes.dex */
public final class FilteringSequence<T> implements Sequence<T> {
    public final Function1<T, Boolean> predicate;
    public final boolean sendWhen = false;
    public final Sequence<T> sequence;

    public FilteringSequence(TransformingSequence transformingSequence, SequencesKt___SequencesKt$filterNotNull$1 sequencesKt___SequencesKt$filterNotNull$1) {
        this.sequence = transformingSequence;
        this.predicate = sequencesKt___SequencesKt$filterNotNull$1;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator<T> iterator() {
        return new FilteringSequence$iterator$1(this);
    }
}
