package com.animaconnected.watch.display;

import java.util.Iterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: WatchAppInterfaces.kt */
/* loaded from: classes3.dex */
public final class VisibilityState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ VisibilityState[] $VALUES;
    public static final Companion Companion;
    private final int value;
    public static final VisibilityState Stopped = new VisibilityState("Stopped", 0, 0);
    public static final VisibilityState Glanceable = new VisibilityState("Glanceable", 1, 1);
    public static final VisibilityState Persistent = new VisibilityState("Persistent", 2, 2);
    public static final VisibilityState PersistentHidden = new VisibilityState("PersistentHidden", 3, 3);

    /* compiled from: WatchAppInterfaces.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VisibilityState fromInt(int r4) {
            Object obj;
            boolean z;
            Iterator<E> it = VisibilityState.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((VisibilityState) obj).getValue() == r4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            return (VisibilityState) obj;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ VisibilityState[] $values() {
        return new VisibilityState[]{Stopped, Glanceable, Persistent, PersistentHidden};
    }

    static {
        VisibilityState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    private VisibilityState(String str, int r2, int r3) {
        this.value = r3;
    }

    public static EnumEntries<VisibilityState> getEntries() {
        return $ENTRIES;
    }

    public static VisibilityState valueOf(String str) {
        return (VisibilityState) Enum.valueOf(VisibilityState.class, str);
    }

    public static VisibilityState[] values() {
        return (VisibilityState[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}
