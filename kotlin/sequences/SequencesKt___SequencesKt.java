package kotlin.sequences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: _Sequences.kt */
/* loaded from: classes.dex */
public class SequencesKt___SequencesKt extends SequencesKt___SequencesJvmKt {
    public static final <T> int count(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Iterator<? extends T> it = sequence.iterator();
        int r0 = 0;
        while (it.hasNext()) {
            it.next();
            r0++;
            if (r0 < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
                throw null;
            }
        }
        return r0;
    }

    public static final Object firstOrNull(FilteringSequence filteringSequence) {
        FilteringSequence$iterator$1 filteringSequence$iterator$1 = new FilteringSequence$iterator$1(filteringSequence);
        if (!filteringSequence$iterator$1.hasNext()) {
            return null;
        }
        return filteringSequence$iterator$1.next();
    }

    public static final FilteringSequence mapNotNull(Sequence sequence, Function1 transform) {
        Intrinsics.checkNotNullParameter(transform, "transform");
        TransformingSequence transformingSequence = new TransformingSequence(sequence, transform);
        SequencesKt___SequencesKt$filterNotNull$1 predicate = new Function1<Object, Boolean>() { // from class: kotlin.sequences.SequencesKt___SequencesKt$filterNotNull$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Object obj) {
                boolean z;
                if (obj == null) {
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        };
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        return new FilteringSequence(transformingSequence, predicate);
    }

    public static final <T> List<T> toList(Sequence<? extends T> sequence) {
        Iterator<? extends T> it = sequence.iterator();
        if (!it.hasNext()) {
            return EmptyList.INSTANCE;
        }
        T next = it.next();
        if (!it.hasNext()) {
            return CollectionsKt__CollectionsKt.listOf(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
