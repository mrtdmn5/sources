package com.animaconnected.secondo.screens.settings.health;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: HealthSettings.kt */
/* loaded from: classes3.dex */
public final class BottomSheetType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BottomSheetType[] $VALUES;
    public static final BottomSheetType Walk = new BottomSheetType("Walk", 0);
    public static final BottomSheetType Stand = new BottomSheetType("Stand", 1);
    public static final BottomSheetType Exercise = new BottomSheetType("Exercise", 2);
    public static final BottomSheetType GoogleFitDisconnect = new BottomSheetType("GoogleFitDisconnect", 3);
    public static final BottomSheetType GoogleFitDisabledInDemo = new BottomSheetType("GoogleFitDisabledInDemo", 4);
    public static final BottomSheetType StravaDisabledInDemo = new BottomSheetType("StravaDisabledInDemo", 5);
    public static final BottomSheetType StravaDisconnect = new BottomSheetType("StravaDisconnect", 6);
    public static final BottomSheetType StravaConnect = new BottomSheetType("StravaConnect", 7);
    public static final BottomSheetType NoInternet = new BottomSheetType("NoInternet", 8);

    private static final /* synthetic */ BottomSheetType[] $values() {
        return new BottomSheetType[]{Walk, Stand, Exercise, GoogleFitDisconnect, GoogleFitDisabledInDemo, StravaDisabledInDemo, StravaDisconnect, StravaConnect, NoInternet};
    }

    static {
        BottomSheetType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private BottomSheetType(String str, int r2) {
    }

    public static EnumEntries<BottomSheetType> getEntries() {
        return $ENTRIES;
    }

    public static BottomSheetType valueOf(String str) {
        return (BottomSheetType) Enum.valueOf(BottomSheetType.class, str);
    }

    public static BottomSheetType[] values() {
        return (BottomSheetType[]) $VALUES.clone();
    }
}
