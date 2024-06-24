package kotlin.ranges;

import java.lang.Comparable;

/* compiled from: Range.kt */
/* loaded from: classes.dex */
public interface ClosedRange<T extends Comparable<? super T>> {
    boolean contains(T t);

    T getEndInclusive();

    T getStart();

    boolean isEmpty();
}
