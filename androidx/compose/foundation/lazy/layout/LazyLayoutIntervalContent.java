package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent.Interval;
import kotlin.jvm.functions.Function1;

/* compiled from: LazyLayoutIntervalContent.kt */
/* loaded from: classes.dex */
public abstract class LazyLayoutIntervalContent<Interval extends Interval> {

    /* compiled from: LazyLayoutIntervalContent.kt */
    /* loaded from: classes.dex */
    public interface Interval {
        default Function1<Integer, Object> getKey() {
            return null;
        }

        default Function1<Integer, Object> getType() {
            return new Function1() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent$Interval$type$1
                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    ((Number) obj).intValue();
                    return null;
                }
            };
        }
    }

    public abstract MutableIntervalList getIntervals$1();

    public final Object getKey(int r3) {
        Object invoke;
        IntervalList$Interval intervalList$Interval = getIntervals$1().get(r3);
        int r1 = r3 - intervalList$Interval.startIndex;
        Function1<Integer, Object> key = ((Interval) intervalList$Interval.value).getKey();
        if (key == null || (invoke = key.invoke(Integer.valueOf(r1))) == null) {
            return new DefaultLazyKey(r3);
        }
        return invoke;
    }
}
