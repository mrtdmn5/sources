package com.animaconnected.watch.graphs;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: LineCharts.kt */
/* loaded from: classes3.dex */
public final class ZoomOutLevel {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ZoomOutLevel[] $VALUES;
    public static final ZoomOutLevel HIGH = new ZoomOutLevel("HIGH", 0);
    public static final ZoomOutLevel DEFAULT = new ZoomOutLevel("DEFAULT", 1);

    private static final /* synthetic */ ZoomOutLevel[] $values() {
        return new ZoomOutLevel[]{HIGH, DEFAULT};
    }

    static {
        ZoomOutLevel[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private ZoomOutLevel(String str, int r2) {
    }

    public static EnumEntries<ZoomOutLevel> getEntries() {
        return $ENTRIES;
    }

    public static ZoomOutLevel valueOf(String str) {
        return (ZoomOutLevel) Enum.valueOf(ZoomOutLevel.class, str);
    }

    public static ZoomOutLevel[] values() {
        return (ZoomOutLevel[]) $VALUES.clone();
    }
}
