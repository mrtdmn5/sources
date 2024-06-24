package com.animaconnected.watch.model.alarms;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.CharsKt__CharKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: DaysOfWeek.kt */
/* loaded from: classes3.dex */
public final class DaysOfWeek {
    public static final Companion Companion = new Companion(null);
    private static final int DAYS_IN_A_WEEK = 7;
    public static final int NO_DAYS_SET = 0;
    private final Set<Integer> days;

    /* compiled from: DaysOfWeek.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DaysOfWeek fromBitSet(int r6) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<Integer> it = RangesKt___RangesKt.until(1, 8).iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                if (((1 << nextInt) & r6) > 0) {
                    linkedHashSet.add(Integer.valueOf(nextInt));
                }
            }
            return new DaysOfWeek(linkedHashSet);
        }

        private Companion() {
        }
    }

    public DaysOfWeek(Set<Integer> days) {
        Intrinsics.checkNotNullParameter(days, "days");
        this.days = days;
    }

    public final Set<Integer> getDays() {
        return this.days;
    }

    public final int toBitSet() {
        Iterator<T> it = this.days.iterator();
        int r1 = 0;
        while (it.hasNext()) {
            r1 |= 1 << ((Number) it.next()).intValue();
        }
        return r1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DaysOfWeek{bitSet=0b");
        int bitSet = toBitSet();
        CharsKt__CharKt.checkRadix(2);
        String num = Integer.toString(bitSet, 2);
        Intrinsics.checkNotNullExpressionValue(num, "toString(...)");
        sb.append(StringsKt__StringsKt.padStart(num, 8, '0'));
        sb.append('}');
        return sb.toString();
    }
}
