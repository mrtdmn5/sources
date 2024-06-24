package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Sequences.kt */
/* loaded from: classes.dex */
public final class GeneratorSequence<T> implements Sequence<T> {
    public final Function0<T> getInitialValue;
    public final Function1<T, T> getNextValue;

    public GeneratorSequence(Function1 getNextValue, SequencesKt__SequencesKt$generateSequence$2 sequencesKt__SequencesKt$generateSequence$2) {
        Intrinsics.checkNotNullParameter(getNextValue, "getNextValue");
        this.getInitialValue = sequencesKt__SequencesKt$generateSequence$2;
        this.getNextValue = getNextValue;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator<T> iterator() {
        return new GeneratorSequence$iterator$1(this);
    }
}
