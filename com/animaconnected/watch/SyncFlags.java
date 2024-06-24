package com.animaconnected.watch;

import java.util.Iterator;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SyncFlags.kt */
/* loaded from: classes3.dex */
public final class SyncFlags {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SyncFlags[] $VALUES;
    public static final Companion Companion;
    private final int rawValue;
    public static final SyncFlags FlashTranslations = new SyncFlags("FlashTranslations", 0, 0);
    public static final SyncFlags AppReady = new SyncFlags("AppReady", 1, 1);
    public static final SyncFlags RamTranslations = new SyncFlags("RamTranslations", 2, 2);

    /* compiled from: SyncFlags.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Set<SyncFlags> all() {
            return CollectionsKt___CollectionsKt.toSet(SyncFlags.getEntries());
        }

        public final int bitmask(Set<? extends SyncFlags> parts) {
            Intrinsics.checkNotNullParameter(parts, "parts");
            Iterator it = CollectionsKt___CollectionsKt.toList(parts).iterator();
            int r0 = 0;
            while (it.hasNext()) {
                r0 |= ((SyncFlags) it.next()).bitmask();
            }
            return r0;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ SyncFlags[] $values() {
        return new SyncFlags[]{FlashTranslations, AppReady, RamTranslations};
    }

    static {
        SyncFlags[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    private SyncFlags(String str, int r2, int r3) {
        this.rawValue = r3;
    }

    public static EnumEntries<SyncFlags> getEntries() {
        return $ENTRIES;
    }

    public static SyncFlags valueOf(String str) {
        return (SyncFlags) Enum.valueOf(SyncFlags.class, str);
    }

    public static SyncFlags[] values() {
        return (SyncFlags[]) $VALUES.clone();
    }

    public final int bitmask() {
        return 1 << this.rawValue;
    }
}
