package kotlin.sequences;

import java.util.Iterator;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Sequences.kt */
/* loaded from: classes.dex */
public final class SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1 implements Sequence<Object> {
    public final /* synthetic */ Function2 $block$inlined;

    public SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1(Function2 function2) {
        this.$block$inlined = function2;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator<Object> iterator() {
        Function2 block = this.$block$inlined;
        Intrinsics.checkNotNullParameter(block, "block");
        SequenceBuilderIterator sequenceBuilderIterator = new SequenceBuilderIterator();
        sequenceBuilderIterator.nextStep = IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted(block, sequenceBuilderIterator, sequenceBuilderIterator);
        return sequenceBuilderIterator;
    }
}
