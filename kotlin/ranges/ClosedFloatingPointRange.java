package kotlin.ranges;

import java.lang.Comparable;

/* compiled from: Ranges.kt */
/* loaded from: classes.dex */
public interface ClosedFloatingPointRange<T extends Comparable<? super T>> extends ClosedRange<T> {
    boolean lessThanOrEquals(T t, T t2);
}
