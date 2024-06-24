package com.animaconnected.watch.graphs;

import com.animaconnected.watch.graphs.utils.DrawBarOptions;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SegmentedProgressBarCharts.kt */
/* loaded from: classes3.dex */
public final class BarChartSize {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BarChartSize[] $VALUES;
    public static final BarChartSize Large;
    private final DrawBarOptions options;
    public static final BarChartSize Small = new BarChartSize("Small", 0, new DrawBarOptions(0, 0, null, null, null, null, 2.0f, 0.0f, 2.0f, 188, null));
    public static final BarChartSize Medium = new BarChartSize("Medium", 1, new DrawBarOptions(12, 12, null, null, null, null, 2.0f, 0.0f, 1.0f, 188, null));

    private static final /* synthetic */ BarChartSize[] $values() {
        return new BarChartSize[]{Small, Medium, Large};
    }

    static {
        Float valueOf = Float.valueOf(5.0f);
        Large = new BarChartSize("Large", 2, new DrawBarOptions(12, 12, valueOf, null, valueOf, null, 7.0f, 2.0f, 0.0f, 296, null));
        BarChartSize[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private BarChartSize(String str, int r2, DrawBarOptions drawBarOptions) {
        this.options = drawBarOptions;
    }

    public static EnumEntries<BarChartSize> getEntries() {
        return $ENTRIES;
    }

    public static BarChartSize valueOf(String str) {
        return (BarChartSize) Enum.valueOf(BarChartSize.class, str);
    }

    public static BarChartSize[] values() {
        return (BarChartSize[]) $VALUES.clone();
    }

    public final DrawBarOptions getOptions() {
        return this.options;
    }
}
