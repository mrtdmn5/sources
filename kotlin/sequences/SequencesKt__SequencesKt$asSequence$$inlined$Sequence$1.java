package kotlin.sequences;

import java.util.Iterator;

/* compiled from: Sequences.kt */
/* loaded from: classes.dex */
public final class SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1 implements Sequence<Object> {
    public final /* synthetic */ Iterator $this_asSequence$inlined;

    public SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1(Iterator it) {
        this.$this_asSequence$inlined = it;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator<Object> iterator() {
        return this.$this_asSequence$inlined;
    }
}
