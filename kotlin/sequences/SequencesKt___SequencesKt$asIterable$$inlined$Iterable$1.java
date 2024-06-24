package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.DelimitedRangesSequence;

/* compiled from: Iterables.kt */
/* loaded from: classes.dex */
public final class SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1 implements Iterable<Object>, KMappedMarker {
    public final /* synthetic */ Sequence $this_asIterable$inlined;

    public SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(DelimitedRangesSequence delimitedRangesSequence) {
        this.$this_asIterable$inlined = delimitedRangesSequence;
    }

    @Override // java.lang.Iterable
    public final Iterator<Object> iterator() {
        return this.$this_asIterable$inlined.iterator();
    }
}
