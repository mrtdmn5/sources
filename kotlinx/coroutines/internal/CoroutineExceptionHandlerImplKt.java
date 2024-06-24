package kotlinx.coroutines.internal;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.ConstrainedOnceSequence;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* compiled from: CoroutineExceptionHandlerImpl.kt */
/* loaded from: classes4.dex */
public final class CoroutineExceptionHandlerImplKt {
    public static final Collection<CoroutineExceptionHandler> platformExceptionHandlers;

    static {
        Iterator m = CoroutineExceptionHandlerImplKt$$ExternalSyntheticServiceLoad0.m();
        Intrinsics.checkNotNullParameter(m, "<this>");
        Sequence sequencesKt__SequencesKt$asSequence$$inlined$Sequence$1 = new SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1(m);
        if (!(sequencesKt__SequencesKt$asSequence$$inlined$Sequence$1 instanceof ConstrainedOnceSequence)) {
            sequencesKt__SequencesKt$asSequence$$inlined$Sequence$1 = new ConstrainedOnceSequence(sequencesKt__SequencesKt$asSequence$$inlined$Sequence$1);
        }
        platformExceptionHandlers = SequencesKt___SequencesKt.toList(sequencesKt__SequencesKt$asSequence$$inlined$Sequence$1);
    }
}
