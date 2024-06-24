package com.animaconnected.watch.graphs.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.IntIterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: YAxisScaleFormatter.kt */
/* loaded from: classes3.dex */
public final class YAxisScaleFormatter {
    private List<IntRange> customRanges;
    private List<YAxisEntry> entries;
    private Function1<? super Integer, String> formatValue;
    private int highestValue;
    private int lowestValue;
    private int maxTicks;
    private int roundedHighestValue;
    private int roundedLowestValue;
    private ScaleType scaleType;
    private int tickSpacing;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: YAxisScaleFormatter.kt */
    /* loaded from: classes3.dex */
    public static final class ScaleType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ScaleType[] $VALUES;
        public static final ScaleType AUTO = new ScaleType("AUTO", 0);
        public static final ScaleType CUSTOM_RANGES = new ScaleType("CUSTOM_RANGES", 1);

        private static final /* synthetic */ ScaleType[] $values() {
            return new ScaleType[]{AUTO, CUSTOM_RANGES};
        }

        static {
            ScaleType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private ScaleType(String str, int r2) {
        }

        public static EnumEntries<ScaleType> getEntries() {
            return $ENTRIES;
        }

        public static ScaleType valueOf(String str) {
            return (ScaleType) Enum.valueOf(ScaleType.class, str);
        }

        public static ScaleType[] values() {
            return (ScaleType[]) $VALUES.clone();
        }
    }

    /* compiled from: YAxisScaleFormatter.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[ScaleType.values().length];
            try {
                r0[ScaleType.AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[ScaleType.CUSTOM_RANGES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public YAxisScaleFormatter() {
        this(0, 0, 0, null, 15, null);
    }

    private final List<YAxisEntry> calculateAxisValues() {
        int r0 = WhenMappings.$EnumSwitchMapping$0[this.scaleType.ordinal()];
        if (r0 != 1) {
            if (r0 == 2) {
                return generateAxisValuesFromRanges();
            }
            throw new NoWhenBranchMatchedException();
        }
        return calculateNiceAxisValues();
    }

    private final List<YAxisEntry> calculateNiceAxisValues() {
        int r0 = this.highestValue;
        int r1 = this.lowestValue;
        if (r0 < r1) {
            r0 = r1;
        }
        float niceNum = niceNum(r0 - r1, false);
        int r2 = this.maxTicks;
        int r3 = 1;
        if (r2 < 1) {
            r2 = 1;
        }
        int niceNum2 = (int) niceNum(niceNum / r2, true);
        if (niceNum2 >= 1) {
            r3 = niceNum2;
        }
        this.tickSpacing = r3;
        if (this.lowestValue >= this.highestValue) {
            int r02 = (int) niceNum;
            return CollectionsKt__CollectionsKt.listOf(new YAxisEntry(r02, this.formatValue.invoke(Integer.valueOf(r02))));
        }
        IntRange intRange = new IntRange(0, (getRoundedHighestValue() - getRoundedLowestValue()) / this.tickSpacing);
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            int roundedLowestValue = getRoundedLowestValue() + (((IntIterator) it).nextInt() * this.tickSpacing);
            arrayList.add(new YAxisEntry(roundedLowestValue, this.formatValue.invoke(Integer.valueOf(roundedLowestValue))));
        }
        return arrayList;
    }

    private final List<YAxisEntry> generateAxisValuesFromRanges() {
        List<IntRange> list = this.customRanges;
        ArrayList arrayList = new ArrayList();
        for (IntRange intRange : list) {
            CollectionsKt__ReversedViewsKt.addAll(CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(intRange.first), Integer.valueOf(intRange.last)}), arrayList);
        }
        List sorted = CollectionsKt___CollectionsKt.sorted(CollectionsKt___CollectionsKt.toSet(arrayList));
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(sorted, 10));
        Iterator it = sorted.iterator();
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            arrayList2.add(new YAxisEntry(intValue, this.formatValue.invoke(Integer.valueOf(intValue))));
        }
        return arrayList2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003d, code lost:            if (r14 < 7.0f) goto L25;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0050, code lost:            r2 = 5.0f;     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004e, code lost:            if (r14 <= 5.0f) goto L25;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final float niceNum(float r14, boolean r15) {
        /*
            r13 = this;
            r0 = 0
            int r0 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r0 >= 0) goto L7
            r0 = -1
            goto L8
        L7:
            r0 = 1
        L8:
            float r14 = java.lang.Math.abs(r14)
            double r1 = (double) r14
            double r1 = java.lang.Math.log10(r1)
            float r1 = (float) r1
            double r1 = (double) r1
            double r1 = java.lang.Math.floor(r1)
            float r1 = (float) r1
            r2 = 1092616192(0x41200000, float:10.0)
            double r3 = (double) r2
            double r5 = (double) r1
            double r7 = java.lang.Math.pow(r3, r5)
            float r1 = (float) r7
            float r14 = r14 / r1
            r1 = 1084227584(0x40a00000, float:5.0)
            r7 = 1073741824(0x40000000, float:2.0)
            r8 = 1065353216(0x3f800000, float:1.0)
            if (r15 == 0) goto L40
            double r9 = (double) r14
            r11 = 4609434218613702656(0x3ff8000000000000, double:1.5)
            int r15 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r15 >= 0) goto L32
            goto L44
        L32:
            r15 = 1077936128(0x40400000, float:3.0)
            int r15 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1))
            if (r15 >= 0) goto L39
            goto L4a
        L39:
            r15 = 1088421888(0x40e00000, float:7.0)
            int r14 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1))
            if (r14 >= 0) goto L51
            goto L50
        L40:
            int r15 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r15 > 0) goto L46
        L44:
            r2 = r8
            goto L51
        L46:
            int r15 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r15 > 0) goto L4c
        L4a:
            r2 = r7
            goto L51
        L4c:
            int r14 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
            if (r14 > 0) goto L51
        L50:
            r2 = r1
        L51:
            float r14 = (float) r0
            float r14 = r14 * r2
            double r0 = java.lang.Math.pow(r3, r5)
            float r15 = (float) r0
            float r14 = r14 * r15
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.graphs.utils.YAxisScaleFormatter.niceNum(float, boolean):float");
    }

    public final List<IntRange> getCustomRanges() {
        return this.customRanges;
    }

    public final List<YAxisEntry> getEntries() {
        return this.entries;
    }

    public final Function1<Integer, String> getFormatValue() {
        return this.formatValue;
    }

    public final int getHighestValue() {
        return this.highestValue;
    }

    public final int getLowestValue() {
        return this.lowestValue;
    }

    public final int getMaxTicks() {
        return this.maxTicks;
    }

    public final int getRoundedHighestValue() {
        return ((int) Math.ceil(this.highestValue / this.tickSpacing)) * this.tickSpacing;
    }

    public final int getRoundedLowestValue() {
        return ((int) Math.floor(this.lowestValue / this.tickSpacing)) * this.tickSpacing;
    }

    public final ScaleType getScaleType() {
        return this.scaleType;
    }

    public final void setCustomRanges(List<IntRange> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.customRanges = value;
        this.entries = calculateAxisValues();
    }

    public final void setFormatValue(Function1<? super Integer, String> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.formatValue = function1;
    }

    public final void setHighestValue(int r1) {
        this.highestValue = r1;
        this.entries = calculateAxisValues();
    }

    public final void setLowestValue(int r1) {
        this.lowestValue = r1;
        this.entries = calculateAxisValues();
    }

    public final void setMaxTicks(int r1) {
        this.maxTicks = r1;
    }

    public final void setScaleType(ScaleType value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.scaleType = value;
        this.entries = calculateAxisValues();
    }

    public YAxisScaleFormatter(int r2, int r3, int r4, Function1<? super Integer, String> formatValue) {
        Intrinsics.checkNotNullParameter(formatValue, "formatValue");
        this.maxTicks = r4;
        this.formatValue = formatValue;
        this.scaleType = ScaleType.AUTO;
        this.highestValue = r2;
        this.lowestValue = r3;
        this.customRanges = EmptyList.INSTANCE;
        this.entries = calculateAxisValues();
        if (!(r2 >= r3)) {
            throw new IllegalArgumentException("Highest value must be greater than or equal to lowest value".toString());
        }
    }

    public /* synthetic */ YAxisScaleFormatter(int r2, int r3, int r4, Function1 function1, int r6, DefaultConstructorMarker defaultConstructorMarker) {
        this((r6 & 1) != 0 ? 0 : r2, (r6 & 2) != 0 ? 0 : r3, (r6 & 4) != 0 ? 10 : r4, (r6 & 8) != 0 ? new Function1<Integer, String>() { // from class: com.animaconnected.watch.graphs.utils.YAxisScaleFormatter.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ String invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final String invoke(int r1) {
                return String.valueOf(r1);
            }
        } : function1);
    }
}
