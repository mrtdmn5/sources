package com.animaconnected.secondo.behaviour.habittracker;

import com.animaconnected.secondo.provider.habittracker.HabitTrackerProvider;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.Pusher;
import com.animaconnected.watch.device.ButtonAction;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HabitTracker.kt */
/* loaded from: classes3.dex */
public final class HabitTracker implements Pusher {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    public static final String TYPE = "HabitTracker";
    private final String type = TYPE;
    private final String analyticsName = "habittracker";

    /* compiled from: HabitTracker.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: HabitTracker.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[ButtonAction.values().length];
            try {
                r0[ButtonAction.Press.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[ButtonAction.DoublePress.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[ButtonAction.TriplePress.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[ButtonAction.QuadruplePress.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public Slot[] compatibleSlots() {
        return Slot.Companion.getPushers();
    }

    @Override // com.animaconnected.watch.behaviour.Pusher
    public boolean execute(ButtonAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        HabitTrackerProvider habitTrackerProvider = HabitTrackerProvider.getInstance();
        int r4 = WhenMappings.$EnumSwitchMapping$0[action.ordinal()];
        if (r4 != 1) {
            if (r4 != 2) {
                if (r4 != 3) {
                    if (r4 != 4) {
                        return false;
                    }
                    habitTrackerProvider.addCount(4);
                    return true;
                }
                habitTrackerProvider.addCount(3);
                return true;
            }
            habitTrackerProvider.addCount(2);
            return true;
        }
        habitTrackerProvider.addCount(1);
        return true;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getAnalyticsName() {
        return this.analyticsName;
    }

    @Override // com.animaconnected.watch.behaviour.Behaviour
    public String getType() {
        return this.type;
    }
}
