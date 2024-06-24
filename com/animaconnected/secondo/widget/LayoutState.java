package com.animaconnected.secondo.widget;

import com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SectionLayout.kt */
/* loaded from: classes3.dex */
public final class LayoutState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LayoutState[] $VALUES;
    public static final LayoutState Enabled = new LayoutState("Enabled", 0);
    public static final LayoutState Disabled = new LayoutState(BucketLifecycleConfiguration.DISABLED, 1);
    public static final LayoutState WarningDisabled = new LayoutState("WarningDisabled", 2);
    public static final LayoutState WarningEnabled = new LayoutState("WarningEnabled", 3);
    public static final LayoutState DisabledButtonEnabled = new LayoutState("DisabledButtonEnabled", 4);

    private static final /* synthetic */ LayoutState[] $values() {
        return new LayoutState[]{Enabled, Disabled, WarningDisabled, WarningEnabled, DisabledButtonEnabled};
    }

    static {
        LayoutState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private LayoutState(String str, int r2) {
    }

    public static EnumEntries<LayoutState> getEntries() {
        return $ENTRIES;
    }

    public static LayoutState valueOf(String str) {
        return (LayoutState) Enum.valueOf(LayoutState.class, str);
    }

    public static LayoutState[] values() {
        return (LayoutState[]) $VALUES.clone();
    }
}
