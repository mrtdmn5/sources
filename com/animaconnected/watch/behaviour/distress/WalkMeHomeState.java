package com.animaconnected.watch.behaviour.distress;

import java.util.Iterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Distress.kt */
/* loaded from: classes3.dex */
public final class WalkMeHomeState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ WalkMeHomeState[] $VALUES;
    public static final Companion Companion;
    public final String string;
    public static final WalkMeHomeState NotStarted = new WalkMeHomeState("NotStarted", 0, "not-started");
    public static final WalkMeHomeState Registered = new WalkMeHomeState("Registered", 1, "registered");
    public static final WalkMeHomeState Idle = new WalkMeHomeState("Idle", 2, "idle");
    public static final WalkMeHomeState Pending = new WalkMeHomeState("Pending", 3, "pending");
    public static final WalkMeHomeState Active = new WalkMeHomeState("Active", 4, "active");
    public static final WalkMeHomeState Distress = new WalkMeHomeState("Distress", 5, "in-distress");

    /* compiled from: Distress.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WalkMeHomeState fromString(String str) {
            Object obj;
            Iterator<E> it = WalkMeHomeState.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((WalkMeHomeState) obj).string, str)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            WalkMeHomeState walkMeHomeState = (WalkMeHomeState) obj;
            if (walkMeHomeState == null) {
                return WalkMeHomeState.NotStarted;
            }
            return walkMeHomeState;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ WalkMeHomeState[] $values() {
        return new WalkMeHomeState[]{NotStarted, Registered, Idle, Pending, Active, Distress};
    }

    static {
        WalkMeHomeState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    private WalkMeHomeState(String str, int r2, String str2) {
        this.string = str2;
    }

    public static EnumEntries<WalkMeHomeState> getEntries() {
        return $ENTRIES;
    }

    public static WalkMeHomeState valueOf(String str) {
        return (WalkMeHomeState) Enum.valueOf(WalkMeHomeState.class, str);
    }

    public static WalkMeHomeState[] values() {
        return (WalkMeHomeState[]) $VALUES.clone();
    }
}
